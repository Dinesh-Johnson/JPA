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
            TypedQuery<GadgetEntity> query = em.createNamedQuery("findByBrand", GadgetEntity.class);
            query.setParameter("brand", brand);
            return Optional.ofNullable(query.getSingleResult());
        } catch (Exception e) {
            return Optional.empty();
        } finally {
            em.close();
        }
    }

    @Override
    public Optional<GadgetEntity> findByGadgetType(String type) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<GadgetEntity> query = em.createNamedQuery("findByGadgetType", GadgetEntity.class);
            query.setParameter("type", type);
            return Optional.ofNullable(query.getSingleResult());
        } catch (Exception e) {
            return Optional.empty();
        } finally {
            em.close();
        }
    }

    @Override
    public Optional<GadgetEntity> findByLaunchDate(LocalDate date) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<GadgetEntity> query = em.createNamedQuery("findByLaunchDate", GadgetEntity.class);
            query.setParameter("launchDate", date);
            return Optional.ofNullable(query.getSingleResult());
        } catch (Exception e) {
            return Optional.empty();
        } finally {
            em.close();
        }
    }
}