package com.xworkz.demo.repository;


import com.xworkz.demo.entity.AlbumEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
        } finally {
            em.close();
        }
    }

    @Override
    public Optional<AlbumEntity> findByTitle(String title) {
        EntityManager em = emf.createEntityManager();
        try {
            AlbumEntity result = em.createNamedQuery("findByAlbumTitle", AlbumEntity.class)
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
            AlbumEntity result = em.createNamedQuery("findByArtist", AlbumEntity.class)
                    .setParameter("artist", artist)
                    .getSingleResult();
            return Optional.of(result);
        } catch (Exception e) {
            return Optional.empty();
        } finally {
            em.close();
        }
    }

    @Override
    public Optional<AlbumEntity> findByReleaseDate(LocalDate date) {
        EntityManager em = emf.createEntityManager();
        try {
            AlbumEntity result = em.createNamedQuery("findByReleaseDate", AlbumEntity.class)
                    .setParameter("releaseDate", date)
                    .getSingleResult();
            return Optional.of(result);
        } catch (Exception e) {
            return Optional.empty();
        } finally {
            em.close();
        }
    }

}
