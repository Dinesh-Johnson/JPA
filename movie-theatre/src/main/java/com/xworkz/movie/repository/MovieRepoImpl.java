package com.xworkz.movie.repository;

import com.xworkz.movie.entity.MovieEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import java.time.LocalDate;
import java.util.Optional;

public class MovieRepoImpl implements MovieRepo {

    private EntityManagerFactory factory;

    public MovieRepoImpl(EntityManagerFactory factory) {
        this.factory = factory;
    }

    @Override
    public boolean save(MovieEntity entity) {
        EntityManager em = factory.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println("Error saving movie: " + e.getMessage());
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }
    }

    @Override
    public Optional<MovieEntity> findByTitle(String title) {
        EntityManager em = factory.createEntityManager();
        try {
            MovieEntity entity = (MovieEntity) em.createNamedQuery("findByMovieTitle")
                    .setParameter("title", title)
                    .getSingleResult();
            return Optional.of(entity);
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return Optional.empty();
    }


    @Override
    public Optional<MovieEntity> findByLanguage(String language) {
        EntityManager em = factory.createEntityManager();
        try {
            MovieEntity entity = (MovieEntity) em.createNamedQuery("findByMovieLanguage")
                    .setParameter("language", language)
                    .getSingleResult();
            return Optional.of(entity);
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return Optional.empty();
    }

    @Override
    public Optional<MovieEntity> findByReleaseDate(LocalDate releaseDate) {
        EntityManager em = factory.createEntityManager();
        try {
            MovieEntity entity = (MovieEntity) em.createNamedQuery("findByMovieReleaseDate")
                    .setParameter("releaseDate", releaseDate)
                    .getSingleResult();
            return Optional.of(entity);
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return Optional.empty();
    }
}
