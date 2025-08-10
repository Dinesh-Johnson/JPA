package com.xworkz.album.repo;


import com.xworkz.album.entity.AlbumEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@Repository
public class AlbumRepoImpl implements AlbumRepo{

    private EntityManagerFactory emf=Persistence.createEntityManagerFactory("x-workz");
    @Override
    public boolean save(AlbumEntity entity) {
        System.out.println("Entity :"+entity);
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(entity);
        et.commit();


        return true;
    }
}
