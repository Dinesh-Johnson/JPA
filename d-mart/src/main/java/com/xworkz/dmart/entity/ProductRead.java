package com.xworkz.dmart.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

public class ProductRead {
    public static void main(String[] args) {

        EntityManagerFactory emf = null;
        EntityManager manager =null;

        try{
            emf= Persistence.createEntityManagerFactory("x-workz");
            manager= emf.createEntityManager();
           ProductEntity product= manager.find(ProductEntity.class,1);
            System.out.println(product);
        } catch (PersistenceException e) {
            e.printStackTrace();
        }finally {
            if (emf!=null){
                emf.close();
            }
            if (manager!=null){
                manager.close();
            }
        }
    }
}
