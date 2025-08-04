package com.xworkz.gadget.repository;

import com.xworkz.gadget.entity.GadgetEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Optional;

public class GadgetRepositoryImpl implements GadgetRepository {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("x-workz");

    @Override
    public boolean save(GadgetEntity entity) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(entity);
            tx.commit();
            return true;
        } finally {
            em.close();
        }
    }

    @Override
    public Optional<GadgetEntity> findByBrand(String brand) {
        EntityManager em = emf.createEntityManager();
        try {
            GadgetEntity entity =(GadgetEntity)em.createNamedQuery("findByBrand")
                    .setParameter("brand",brand)
                    .getSingleResult();
            System.out.println("findByBrand :"+entity);
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return Optional.empty();
    }

    @Override
    public Optional<GadgetEntity> findByGadgetType(String type) {
        EntityManager em = emf.createEntityManager();
        try {
            GadgetEntity entity =(GadgetEntity) em.createNamedQuery("findByGadgetType")
                    .setParameter("type",type).getSingleResult();
            System.out.println("findByGadgetType :"+entity);
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return Optional.empty();
    }

    @Override
    public Optional<GadgetEntity> findByLaunchDate(LocalDate date) {
        EntityManager em = emf.createEntityManager();
        try {
            GadgetEntity entity = (GadgetEntity) em.createNamedQuery("findByLaunchDate")
                    .setParameter("launchDate",date).getSingleResult();
            System.out.println("findByLaunchDate"+entity);
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return Optional.empty();
    }
}