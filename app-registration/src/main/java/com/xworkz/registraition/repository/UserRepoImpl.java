package com.xworkz.registraition.repository;

import com.xworkz.registraition.entity.UserEntity;
import com.xworkz.registraition.utill.DBConnection;
import org.hibernate.QueryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Repository

public class UserRepoImpl implements UserRepo{

    @Autowired
    private DBConnection emf;

    private static final Logger log = LoggerFactory.getLogger(UserRepoImpl.class);



    @Override
    public boolean save(UserEntity entity) {
        System.out.println("repo data: " + entity);
        EntityManager em = null;
        boolean isSaved = false;
        try {
            em = emf.entityManager();
            em.getTransaction().begin();
            em.persist(entity);

            if (entity != null) {
                em.getTransaction().commit();
                System.out.println("DATA SAVED");
                return isSaved = true;
            }
        } catch (QueryException | NoResultException e) {
            System.out.println(e.getMessage());
            isSaved = false;
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
            return isSaved;
        }
    }

    @Override
    public UserEntity acceptLogin(String email) {
        System.out.println("REPO ACCEPT LOGIn");
        EntityManager em = null;
        UserEntity entity = null;
        try {
            em = emf.entityManager();
            entity = (UserEntity) em.createNamedQuery("acceptLogin").setParameter("email", email).getSingleResult();
            System.out.println(entity);
            log.info(String.valueOf(entity));
        } catch (QueryException | NoResultException e) {
            System.out.println(e.getMessage());
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
            return entity;
        }
    }
    @Override
    public String getByMail(String mail) {
        System.out.println("GET MAIL REPO");
        EntityManager em = null;
        String entity=null;
        try {
            em = emf.entityManager();
            entity = (String) em.createNamedQuery("getByEmail").setParameter("email",mail).getSingleResult();
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
            return null;
        }finally {
            if(em!=null&& em.isOpen())
            {
                em.close();
            }
        }
        return entity;
    }

    @Override
    public Long getByMobile(Long mobile) {
        System.out.println("GET Mobile REPO");
        EntityManager em = null;
        Long entity = 0L;
        try {
            em = emf.entityManager();
            entity = (Long) em.createNamedQuery("getByMobile").setParameter("mobile", mobile).getSingleResult();
        } catch (PersistenceException e) {
            System.out.println(e.getMessage());
            return null;
        }finally {
            if(em!=null&& em.isOpen())
            {
                em.close();
            }
        }
        return entity;
    }

    @Override
    public String getPassword(String mail) {
        System.out.println("GET Password OTP REPO");
        EntityManager em = null;
        String entity = null;
        try {
            em = emf.entityManager();
            entity = (String) em.createNamedQuery("getPassword").setParameter("email", mail).getSingleResult();
        } catch (PersistenceException e) {
            System.out.println(e.getMessage());
            return null;
        }finally {
            if(em!=null&& em.isOpen())
            {
                em.close();
            }
        }
        return entity;
    }

    @Override
    public boolean resetPassword(String mail, String password) {
        System.out.println("GET MAIL REPO");
        EntityManager em = null;
        int rows=0;
        try {
            em = emf.entityManager();
            em.getTransaction().begin();
            rows = em.createNamedQuery("updatePassword").setParameter("email",mail).setParameter("password",password).executeUpdate();
            System.out.println(rows+" are Updated");

            if (rows>0){
                em.getTransaction().commit();
                return true;
            }
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
            return false;
        }finally {
            if(em!=null&& em.isOpen())
            {
                em.close();
            }
        }
        return false;
    }

    @Override
    public void lockTimeUpdate(UserEntity entity) {
        System.out.println("repo Merge Lock Time: " + entity);
        EntityManager em = null;
        try {
            em = emf.entityManager();
            em.getTransaction().begin();
            em.merge(entity);

            if (entity != null) {
                em.getTransaction().commit();
                System.out.println("DATA Merged");
            }
        } catch (QueryException | NoResultException e) {
            System.out.println(e.getMessage());
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }
}
