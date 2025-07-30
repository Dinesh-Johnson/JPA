package com.xworkz.dmart.entity;

import javax.persistence.*;

public class ProductRunner {
    public static void main(String[] args) {

        ProductEntity productEntity = new ProductEntity();
        productEntity.setProductName("Laptop");
        productEntity.setMfd("28-03-2025");
        productEntity.setCompany("HP");
        productEntity.setPrice(50000.0);
        try {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");
            EntityManager manager = entityManagerFactory.createEntityManager();
            EntityTransaction entityTransaction= manager.getTransaction();
            entityTransaction.begin();
            manager.persist(productEntity);
            entityTransaction.commit();

        }catch (PersistenceException e){
            e.printStackTrace();
        }
    }
}
//illeagal excpetion
//IleagalState exception
//PersisitanceException
//service Exceptiom
//Hibernate exception
