package com.xworkz.showroom.repository;

import com.xworkz.showroom.entity.ApplicationEntity;

import javax.persistence.*;
import java.util.Optional;

public class ApplicationRepoImpl implements ApplicationRepo{

    @Override
    public void saveApplication(ApplicationEntity entity) {

        EntityManagerFactory emf = null;
        EntityManager manager = null;
        EntityTransaction transaction = null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            manager = emf.createEntityManager();
            transaction = manager.getTransaction();
            transaction.begin();
            manager.persist(entity);
            transaction.commit();

        } catch (PersistenceException e) {
            e.printStackTrace();
            transaction.rollback();

        }finally {
            if (emf!=null){
                emf.close();
            }
            if (manager!=null){
                manager.close();
            }
        }
    }

    @Override
    public Optional<ApplicationEntity> findByID(int id) {

        EntityManagerFactory emf = null;
        EntityManager manager = null;
        ApplicationEntity entity=null;


        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            manager = emf.createEntityManager();
            entity = manager.find(ApplicationEntity.class,id);


        } catch (PersistenceException e) {
            e.printStackTrace();


        }finally {
            if (emf!=null){
                emf.close();
            }
            if (manager!=null){
                manager.close();
            }
        }
        return entity == null?Optional.empty():Optional.of(entity);
    }

    @Override
    public void deleteById(int id) {

        EntityManagerFactory emf = null;
        EntityManager manager = null;
        EntityTransaction transaction =null;


        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            manager = emf.createEntityManager();
            transaction= manager.getTransaction();


            transaction.begin();
            ApplicationEntity entity = manager.find(ApplicationEntity.class,1);
            if (entity!=null){

                manager.remove(entity);
                System.out.println("Deleted...");
                transaction.commit();
            }



        } catch (PersistenceException e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }

            } finally {
            if (emf != null) {
                emf.close();
            }
            if (manager != null) {
                manager.close();
            }

        }

    }

    @Override
    public boolean updateById(int id, String company) {

        EntityManagerFactory emf = null;
        EntityManager manger = null;
        EntityTransaction transaction = null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            manger = emf.createEntityManager();
            transaction = manger.getTransaction();

            transaction.begin();
            ApplicationEntity applicationEntity = manger.find(ApplicationEntity.class, id);
            if (applicationEntity != null) {
                applicationEntity.setCompany(company);
                manger.merge(applicationEntity);
                transaction.commit();
            } else {
                System.out.println("Id is not found for update");
            }
        } catch (PersistenceException e) {
            System.out.println(e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (emf != null) {
                emf.close();
            }
            if (manger != null) {
                manger.close();
            }
        }
        return false;
    }
}
