package com.xworkz.dmart.entity;

import javax.persistence.*;

public class ProductUpdate {

    public static void main(String[] args) {

        EntityManagerFactory emf = null;
        EntityManager manager =null;
        EntityTransaction et=null;


       try {
           emf = Persistence.createEntityManagerFactory("x-workz");//Load, Register,Connection
           manager = emf.createEntityManager();//DML(INSERT,UPDATE,DELETE),DQL(SELECT)
           et = manager.getTransaction();// TCL(autocommit , Rollback)

           et.begin();
           ProductEntity product = manager.find(ProductEntity.class, 4);
           if (product != null) {
               product.setPrice(100.0);
               ProductEntity updated = manager.merge(product);
               System.out.println("UPDATED :" + updated);
           }
           et.commit();
       }catch (PersistenceException e){
           System.out.println("You got a Exception");
           if (et!=null){
               et.rollback();
           }
       }finally {
           if (manager!=null){
               manager.close();
           }
           if (emf!=null){
               emf.close();
           }

       }
    }
}
