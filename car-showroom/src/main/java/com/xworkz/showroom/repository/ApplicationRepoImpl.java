package com.xworkz.showroom.repository;

import com.xworkz.showroom.entity.ApplicationEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ApplicationRepoImpl implements ApplicationRepo{

     private EntityManagerFactory emf = Persistence.createEntityManagerFactory("x-workz");

    @Override
    public void saveApplication(ApplicationEntity entity) {

        EntityManager manager = null;
        EntityTransaction transaction = null;

        try {

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

        EntityManager manager = null;
        ApplicationEntity entity=null;


        try {
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

        EntityManager manager = null;
        EntityTransaction transaction =null;


        try {
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


        }

    }

    @Override
    public boolean updateById(int id, String company) {

        EntityManager manger = null;
        EntityTransaction transaction = null;

        try {
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

    @Override
    public ApplicationEntity getApplicationByName(String name) {

        EntityManager manger = null;
        ApplicationEntity entity=null;

        try {
            manger = emf.createEntityManager();

            entity=(ApplicationEntity) manger.createNamedQuery("findByApplicationName").setParameter("name",name).getSingleResult();

            System.out.println("findByApplicationName :"+entity);
        } catch (PersistenceException e) {
            System.out.println(e.getMessage());

        } finally {


        }

        return null;
    }

    @Override
    public ApplicationEntity getApplicationSize(String size) {
        EntityManager manger = null;
        ApplicationEntity entity=null;

        try {
            manger = emf.createEntityManager();

            entity=(ApplicationEntity) manger.createNamedQuery("findByApplicationSize").setParameter("size",size).getSingleResult();

            System.out.println("findByApplicationSize :"+entity);
        } catch (PersistenceException e) {
            System.out.println(e.getMessage());

        } finally {


        }

        return null;
    }

    @Override
    public ApplicationEntity getApplicationCompany(String company) {
        EntityManager manger = null;
        ApplicationEntity entity=null;

        try {
            manger = emf.createEntityManager();

            entity=(ApplicationEntity) manger.createNamedQuery("findByApplicationCompany").setParameter("company",company).getSingleResult();

            System.out.println("findByApplicationCompany :"+entity);
        } catch (PersistenceException e) {
            System.out.println(e.getMessage());

        } finally {


        }

        return null;
    }

    @Override
    public ApplicationEntity getApplicationUser(Integer user) {

        EntityManager manger = null;
        ApplicationEntity entity=null;

        try {
            manger = emf.createEntityManager();

            entity=(ApplicationEntity) manger.createNamedQuery("findByApplicationUsers").setParameter("users",user).getSingleResult();

            System.out.println("findByApplicationUsers :"+entity);
        } catch (PersistenceException e) {
            System.out.println(e.getMessage());

        } finally {

        }

        return null;
    }

    @Override
    public ApplicationEntity getApplicationRatings(Float ratings) {
        EntityManager manger = null;
        ApplicationEntity entity=null;

        try {
            manger = emf.createEntityManager();

            entity=(ApplicationEntity) manger.createNamedQuery("findByApplicationRatings").setParameter("ratings",ratings).getSingleResult();

            System.out.println("findByApplicationRatings :"+entity);
        } catch (PersistenceException e) {
            System.out.println(e.getMessage());

        } finally {


        }

        return null;
    }

    @Override
    public ApplicationEntity getApplicationLaunchDate(LocalDate date) {
        EntityManager manger = null;
        ApplicationEntity entity=null;

        try {
            manger = emf.createEntityManager();

            entity=(ApplicationEntity) manger.createNamedQuery("findByApplicationLaunchDate").setParameter("date",date).getSingleResult();

            System.out.println("findByApplicationLaunchDate :"+entity);
        } catch (PersistenceException e) {
            System.out.println(e.getMessage());

        } finally {

        }

        return null;
    }

    @Override
    public List<ApplicationEntity> getAllApplication() {

        EntityManager manager = null;
        ApplicationEntity entity = null;
        List list=null;

        try {
            manager = emf.createEntityManager();

            Query query = manager.createNamedQuery("findAllApplication");
            list = query.getResultList();


        } catch (PersistenceException e) {
            System.out.println(e.getMessage());

        } finally {

        }

        return null;
    }
    }