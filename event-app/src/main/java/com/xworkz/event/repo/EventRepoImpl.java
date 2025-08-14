package com.xworkz.event.repo;


import com.xworkz.event.entity.EventEntity;
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

//    public  static void closeEntityMangerFactory(){
//        if (emf!=null && emf.isOpen()){
//            emf.close();
//        }
//    }
}
