package com.xworkz.pet.repo;


import com.xworkz.pet.entity.PetEntity;
import org.hibernate.QueryException;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class PetRepoImpl implements PetRepo{

    private static EntityManagerFactory emf=Persistence.createEntityManagerFactory("x-workz");
    @Override
    public boolean save(PetEntity entity) {
        System.out.println("Entity :"+entity);
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            et.begin();
            em.persist(entity);
            et.commit();
        }catch (PersistenceException e){
            e.printStackTrace();
            et.rollback();
        }


        return true;
    }

    @Override
    public List<PetEntity> getAllPets() {
        System.out.println("Repo getAllAlbum....");
        EntityManager em =null;
        List<PetEntity> list = null;

        try{
            em = emf.createEntityManager();

            list = em.createNamedQuery("getAllPets").getResultList();

            list.stream().forEach(System.out::println);

        } catch (PersistenceException e) {
            e.printStackTrace();

        }
        return list;
    }

    @Override
    public PetEntity fetchDataByID(Integer id) {
        EntityManager em = null;
        PetEntity entity = null;

        try{

            em = emf.createEntityManager();
            entity = em.createNamedQuery("fetchDataByID", PetEntity.class).setParameter("id",id).getSingleResult();

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
        } catch (QueryException|NoResultException e) {
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
            isDeleted = false;
        }
        return isDeleted;
    }

    @Override
    public boolean updateById(PetEntity entity) {
        EntityManager em= null;
        boolean isUpdated = false;
        try{
            em = emf.createEntityManager();
            em.getTransaction().begin();
            int updated = em.createNamedQuery("getUpdateByID")
                    .setParameter("name",entity.getName())
                    .setParameter("type",entity.getType())
                    .setParameter("age",entity.getAge())
                    .setParameter("breed",entity.getBreed())
                    .setParameter("adoptionFee",entity.getAdoptionFee())
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
    public PetEntity getByName(String name) {
        EntityManager em = null;
        PetEntity entity = null;
        try{
            em = emf.createEntityManager();
            entity = (PetEntity) em.createNamedQuery("getByPetName").setParameter("name",name).getSingleResult();

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