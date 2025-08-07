package com.xworkz.demo.repository;


import com.xworkz.demo.entity.AlbumEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
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
        }
        return Optional.empty();
    }

    @Override
    public List<AlbumEntity> findByAllAlbums() {
        EntityManager em =  emf.createEntityManager();

        Query query = (Query) em.createNamedQuery("findAllAlbums");
        List list= query.getResultList();
        list.forEach(System.out::println);
        return Collections.emptyList();
    }

    @Override
    public Optional<AlbumEntity> findByGenre(String genre) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("findByGenre").setParameter("genre",genre);
        Object object= query.getSingleResult();
        System.out.println(object);
        return Optional.empty();
    }

    @Override
    public Optional<AlbumEntity> findById(Integer albumId) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("findById").setParameter("albumId",albumId);
        Object object= query.getSingleResult();
        System.out.println(object);
        return Optional.empty();
    }

    @Override
    public int updatePriceByArtist(String artist, Double price) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        int updated = 0;

        try {
            tx.begin();
            updated = em.createNamedQuery("updatePriceByArtist")
                    .setParameter("artist", artist)
                    .setParameter("price", price)
                    .executeUpdate();
            tx.commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            if (tx.isActive()) {
                tx.rollback();
            }
        }
        return updated;
    }

    @Override
    public int updateGenreByTitle(String title, String genre) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        int updated = 0;

        try {
            tx.begin();
            updated = em.createNamedQuery("updateGenreByTitle")
                    .setParameter("title", title)
                    .setParameter("genre", genre)
                    .executeUpdate();
            tx.commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            if (tx.isActive()) tx.rollback();
        }

        return updated;
    }

    @Override
    public int updateRatingById(Integer albumId, Float rating) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        int updated = 0;

        try {
            tx.begin();
            updated = em.createNamedQuery("updateRatingById")
                    .setParameter("albumId", albumId)
                    .setParameter("rating", rating)
                    .executeUpdate();
            tx.commit();
            System.out.println("No of rows Affected :"+updated);
        } catch (PersistenceException e) {
            e.printStackTrace();
            if (tx.isActive()) tx.rollback();
        }
        return updated;
    }

    @Override
    public List<Object[]> getTitleArtistAndGenre() {
        EntityManager em = null;
        List<Object[]> list=null;
        try{
            em = emf.createEntityManager();
            list =em.createNamedQuery("getTitleArtistAndGenre").getResultList();
        }catch (PersistenceException e){
            e.printStackTrace();
        }finally {
            if (emf.isOpen()){
                emf.close();
            }
        }
        return list;
    }
}