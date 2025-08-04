package com.xworkz.movie.repository;

import com.xworkz.movie.entity.MovieEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
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

    @Override
    public List<MovieEntity> findAllMovies() {
        EntityManager em = factory.createEntityManager();
        try {
            Query query = em.createNamedQuery("findAllMovies");
            List list =query.getResultList();

            list.forEach(System.out::println);
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Override
    public Optional<MovieEntity> findByDirector(String director) {
        EntityManager em = factory.createEntityManager();
        try{
            Query query =em.createNamedQuery("findByDirector").setParameter("director",director);
            Object o = query.getFirstResult();
            System.out.println(o);
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
