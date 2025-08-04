package com.xworkz.demo.repository;


import com.xworkz.demo.entity.AlbumEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import java.time.LocalDate;
import java.util.Optional;

public class AlbumRepositoryImpl implements AlbumRepository {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("x-workz");

    @Override
    public boolean save(AlbumEntity entity) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
            return true;
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return Optional.empty().isPresent();
    }


    @Override
    public Optional<AlbumEntity> findByTitle(String title) {
        EntityManager em = emf.createEntityManager();
        try {
            AlbumEntity result = (AlbumEntity) em.createNamedQuery("findByAlbumTitle")
                    .setParameter("title", title)
                    .getSingleResult();
            return Optional.of(result);
        } catch (Exception e) {
            return Optional.empty();
        } finally {
            em.close();
        }
    }

    @Override
    public Optional<AlbumEntity> findByArtist(String artist) {
        EntityManager em = emf.createEntityManager();
        try {
            AlbumEntity result = (AlbumEntity) em.createNamedQuery("findByArtist")
                    .setParameter("artist", artist)
                    .getSingleResult();
            return Optional.of(result);
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return Optional.empty();
    }


    @Override
    public Optional<AlbumEntity> findByReleaseDate(LocalDate date) {
        EntityManager em = emf.createEntityManager();
        try {
            AlbumEntity result = (AlbumEntity) em.createNamedQuery("findByReleaseDate")
                    .setParameter("releaseDate", date)
                    .getSingleResult();
            return Optional.of(result);
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return Optional.empty();
    }
}