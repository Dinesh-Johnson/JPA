package com.xworkz.registraition.repository;

import com.xworkz.registraition.entity.UserEntity;
import org.hibernate.QueryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository

public class UserRepoImpl implements UserRepo{

    @Autowired
    private EntityManagerFactory emf;

    private static final Logger log = LoggerFactory.getLogger(UserRepoImpl.class);



    @Override
    public boolean save(UserEntity entity) {
        System.out.println("repo data: " + entity);
        EntityManager em = null;
        boolean isSaved = false;
        try {
            em = emf.createEntityManager();
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
            em = emf.createEntityManager();
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
            em = emf.createEntityManager();
            entity = (String) em.createNamedQuery("getByEmail").setParameter("email",mail).getSingleResult();
        } catch (NoResultException  e) {
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
            em = emf.createEntityManager();
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
            em = emf.createEntityManager();
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
            em = emf.createEntityManager();
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
            em = emf.createEntityManager();
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

    @Override
    public boolean updateById(String name, Long mobile, String dob, String state, String address,Integer id,String filepath,String district,String pincode) {
        System.out.println("Repo Update By ID.....");
        boolean isUpdate=false;
        EntityManager em=null;
        try{
            em = emf.createEntityManager();
            em.getTransaction().begin();
            int rows=em.createNamedQuery("updateById").setParameter("name",name).setParameter("mobile",mobile)
                    .setParameter("dob",dob).setParameter("state",state).setParameter("address",address)
                    .setParameter("id",id).setParameter("filePath",filepath)
                    .setParameter("district",district).setParameter("pincode",pincode).executeUpdate();

            if (rows>0){
                em.getTransaction().commit();
                isUpdate = true;
            }
        }catch (QueryException | NoResultException e) {
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
            isUpdate = false;
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
        return isUpdate;
    }

    @Override
    public boolean updateOTPByEmail(String email, String otp) {
        System.out.println("GET OTP REPO");
        EntityManager em = null;
        int rows=0;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            rows = em.createNamedQuery("setOtpByMail").setParameter("otp",otp).setParameter("email",email).executeUpdate();
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
    public List<String> getAllEmails() {
        System.out.println("Repo Get all Emails....");
        List<String> list=null;
        EntityManager em=null;
        try {
            em= emf.createEntityManager();
            list=em.createNamedQuery("getAllEmails").getResultList();
            list.forEach(System.out::println);
        }catch (NoResultException|QueryException e){
            System.out.println(e.getMessage());
        }finally {
            if(em!=null&& em.isOpen())
            {
                em.close();
            }
        }
        return list;
    }
}
