package com.xworkz.shop.runner;

import com.xworkz.shop.bakery.BakeryEntity;
import com.xworkz.shop.ecom.ClothesEntity;

import javax.persistence.*;

public class ShopReadRunner {

    public static void main(String[] args) {
        BakeryEntity bakery = new BakeryEntity();

        ClothesEntity clothes = new ClothesEntity();

        EntityManagerFactory emf =null;
        EntityManager manager =null;
        EntityTransaction entityTransaction =null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            manager = emf.createEntityManager();
            entityTransaction = manager.getTransaction();

            entityTransaction.begin();
            BakeryEntity find =manager.find(BakeryEntity.class,1);
            System.out.println(find);
            ClothesEntity clothFind = manager.find(ClothesEntity.class,1);
            System.out.println(clothFind);
            entityTransaction.commit();

            System.out.println("Its working Fine");
        } catch (PersistenceException e) {
            e.printStackTrace();
            entityTransaction.rollback();
            System.out.println("Roll back worked");
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
