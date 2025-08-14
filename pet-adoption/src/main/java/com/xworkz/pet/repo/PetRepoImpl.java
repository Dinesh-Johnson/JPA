package com.xworkz.pet.repo;


import com.xworkz.pet.entity.PetEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Collections;
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

//    public  static void closeEntityMangerFactory(){
//        if (emf!=null && emf.isOpen()){
//            emf.close();
//        }
//    }
}