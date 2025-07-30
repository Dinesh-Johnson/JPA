package com.xworkz.dmart.entity;

import javax.persistence.*;

public class ProductCreate {
    public static void main(String[] args) {

        ProductEntity productEntity = new ProductEntity();

        productEntity.setProductName("Ice-Cream");
        productEntity.setMfd("28-07-2025");
        productEntity.setPrice(50);
        productEntity.setCompany("Baskin's Robbins");

        EntityManagerFactory entityManagerFactory=null;
        EntityManager entityManager = null;
        EntityTransaction entityTransaction=null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction= entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.persist(productEntity);
            entityTransaction.commit();

        } catch (PersistenceException e) {
            e.printStackTrace();
            entityTransaction.rollback();
            System.out.println("Roll back worked");
        }finally {
            if (entityManagerFactory!=null){
                entityManagerFactory.close();
            }
            if (entityManager!=null){
                entityManager.close();
            }
        }
    }
}
