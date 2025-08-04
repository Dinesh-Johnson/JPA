package com.xworkz.dmart.entity;

import javax.persistence.*;

public class ProductDeleteRunner {

    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager manager =null;
        EntityTransaction et=null;


        try {
            emf = Persistence.createEntityManagerFactory("x-workz");//Load, Register,Connection
            manager = emf.createEntityManager();//DML(INSERT,UPDATE,DELETE),DQL(SELECT)
            et = manager.getTransaction();// TCL(autocommit , Rollback)

            et.begin();
            ProductEntity find1 = manager.find(ProductEntity.class,5);
            manager.remove(find1);
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
