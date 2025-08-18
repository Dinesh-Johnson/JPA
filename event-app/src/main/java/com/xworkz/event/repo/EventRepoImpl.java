package com.xworkz.event.repo;


import com.xworkz.event.entity.EventEntity;
import org.hibernate.QueryException;
import org.springframework.stereotype.Repository;
import sun.util.locale.StringTokenIterator;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

@Repository
public class EventRepoImpl implements EventRepo {

    private static EntityManagerFactory emf=Persistence.createEntityManagerFactory("x-workz");
    @Override
    public boolean save(EventEntity entity) {
        System.out.println("Entity :"+entity);
        EntityManager em =null;
        EntityTransaction et =null;

        try {
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            em.persist(entity);
            et.commit();
        }catch (PersistenceException e){
            e.printStackTrace();
            et.rollback();
        }finally {
            if (emf.isOpen()){
                emf.close();
            }
            if (em.isOpen()){
                em.close();
            }
        }




        return true;
    }

    @Override
    public List<EventEntity> getAllEvents() {
        EntityManager em= null;
        List<EventEntity> list= null;

        try{
            em = emf.createEntityManager();
            list=em.createNamedQuery("getAllEvents").getResultList();
            list.stream().forEach(System.out::println);

        } catch (PersistenceException e) {
            e.printStackTrace();
        }finally {
            if (emf.isOpen()){
                em.close();
            }
        }
        return list;
    }

    @Override
    public EventEntity fetchDataByID(Integer id) {
        EntityManager em = null;
        EventEntity entity =null;
        try{

            em= emf.createEntityManager();
            entity = (EventEntity) em.createNamedQuery("fetchDataByID").setParameter("id",id).getSingleResult();

        } catch (PersistenceException e) {
            e.printStackTrace();
        }
        return entity;
    }

    @Override
    public boolean deleteByID(Integer id) {
        EntityManager em = null;
        boolean isDeleted= false;
        try{
            em = emf.createEntityManager();
            em.getTransaction().begin();
            int deleted = em.createNamedQuery("deleteById").setParameter("id",id).executeUpdate();

            System.out.println("DELETED"+deleted+" rows");
            if (deleted>0){
                em.getTransaction().commit();
                isDeleted = true;
            }
        } catch (QueryException | NoResultException e) {
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
            isDeleted = false;
        }
        return isDeleted;
    }

    @Override
    public boolean updateById(EventEntity entity) {
        EntityManager em = null;
        boolean isUpdated = false;
        try{
            em = emf.createEntityManager();
            em.getTransaction().begin();
            int updated = em.createNamedQuery("getUpdateByID")
                    .setParameter("name",entity.getName())
                    .setParameter("location",entity.getLocation())
                    .setParameter("date",entity.getDate())
                    .setParameter("organizer",entity.getOrganizer())
                    .setParameter("ticketPrice",entity.getTicketPrice())
                    .setParameter("id",entity.getId())
                    .executeUpdate();
            System.out.println("UPDATES"+updated+" rows");
            if (updated>0){
                em.getTransaction().commit();
                isUpdated = true;
            }
        } catch (QueryException|NoResultException e) {
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
            isUpdated = false;
        }
        return isUpdated;
    }

    @Override
    public EventEntity getByName(String name) {
        EntityManager em = null;
        EventEntity entity = null;
        try{
            em = emf.createEntityManager();
            entity = (EventEntity) em.createNamedQuery("getByEventName").setParameter("name",name).getSingleResult();

            System.out.println(entity);
        } catch (QueryException|NoResultException e) {
            System.out.println(e.getMessage());
        }
        return entity;
    }

//    public  static void closeEntityMangerFactory(){
//        if (emf!=null && emf.isOpen()){
//            emf.close();
//        }
//    }
}
