package com.xworkz.passport.repository;

import com.xworkz.passport.entity.PassportEntity;
import com.xworkz.passport.service.PassportService;
import com.xworkz.passport.utill.DBConnection;
import org.hibernate.QueryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import java.util.Collections;
import java.util.List;

@Repository
public class PassportRepoImpl implements PassportRepo{

    @Autowired
    private DBConnection emf;


    @Override
    public boolean save(PassportEntity entity) {
        System.out.println("Entity Saved"+entity);
        EntityManager em = null;
        EntityTransaction et=null;
        try{
            em =emf.entityManager();
            et = em.getTransaction();

            et.begin();
            em.persist(entity);
            et.commit();
        } catch (PersistenceException e) {
            e.printStackTrace();

        }finally {

            if (em!= null && em.isOpen()){
                em.close();
            }
        }

        return true;
    }

    @Override
    public String getByEmail(String mail) {
        System.out.println("GET MAIL REPO");
        EntityManager em = null;
        String entity=null;
        try {
            em = emf.entityManager();
            entity = (String) em.createNamedQuery("getByEmail").setParameter("email",mail).getSingleResult();
        } catch (PersistenceException e) {
            e.printStackTrace();
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
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
            return entity;
        }
    }
    @Override
    public String getByLoginId(String loginId) {
        System.out.println("GET Login ID REPO");
        EntityManager em = null;
        String entity = null;
        try {
            em = emf.entityManager();
            entity = (String) em.createNamedQuery("getByloginId").setParameter("loginId", loginId).getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
            return entity;
        }
    }
    @Override
    public List<PassportEntity> getAllData() {
        List<PassportEntity> entities = null;
        EntityManager em = null;
        try {
            em = emf.entityManager();
            entities = em.createNamedQuery("findAll").getResultList();
            entities.forEach(System.out::println);
        } catch (QueryException | NoResultException e) {
            System.out.println(e.getMessage());
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
            return entities;
        }
    }
    @Override
    public boolean updateById(PassportEntity entity) {
        EntityManager em = null;
        boolean isUpdated = false;
        try {
            em = emf.entityManager();
            em.getTransaction().begin();
            int updated = em.createNamedQuery("updateById")
                    .setParameter("passportOffice", entity.getPassportOffice())
                    .setParameter("name", entity.getName())
                    .setParameter("surname", entity.getSurname())
                    .setParameter("email", entity.getEmail())
                    .setParameter("mobile", entity.getMobile())
                    .setParameter("loginId", entity.getLoginId())
                    .setParameter("loginIdSameAsEmail", entity.getLoginIdSameAsEmail())
                    .setParameter("password", entity.getPassword())
                    .setParameter("confirmPassword", entity.getConfirmPassword())
                    .setParameter("hintQuestion", entity.getHintQuestion())
                    .setParameter("hintAnswer", entity.getHintAnswer())
                    .setParameter("passportId", entity.getPassportId())
                    .executeUpdate();
            System.err.println(updated + " Rows Updated");

            if (updated > 0) {
                em.getTransaction().commit();
                isUpdated = true;
            }
        } catch (QueryException | NoResultException e) {
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
            isUpdated = false;
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
            return isUpdated;
        }
    }
    @Override
    public boolean deleteByID(Integer id) {
        EntityManager em = null;
        boolean isDeleted = false;
        try {
            em = emf.entityManager();
            em.getTransaction().begin();
            int deleted = em.createNamedQuery("deleteById").setParameter("passportId", id).executeUpdate();
            if (deleted > 0) {
                System.err.println("Deleted Rows :" + deleted);
                em.getTransaction().commit();
                return isDeleted = true;
            }
        } catch (QueryException | NoResultException e) {
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
            isDeleted = false;
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
            return isDeleted;
        }
    }
    @Override
    public PassportEntity searchByName(String name) {
        EntityManager em =null;
        PassportEntity entity = null;
        try{
            em = emf.entityManager();
            entity = (PassportEntity) em.createNamedQuery("getByUserName").setParameter("name",name).getSingleResult();
            System.out.println("Search Results :"+entity);
        } catch (NoResultException | QueryException e) {
            System.out.println(e.getMessage());
        }
        return entity;
    }

    @Override
    public PassportEntity fetchByID(Integer id) {
        EntityManager em =null;
        PassportEntity entity = null;
        try{
            em = emf.entityManager();
            entity = (PassportEntity) em.createNamedQuery("fetchById").setParameter("passportId",id).getSingleResult();
            System.err.println("fetch ID Results :"+entity);
        } catch (NoResultException | QueryException e) {
            System.out.println(e.getMessage());
        }
        return entity;
    }

}
