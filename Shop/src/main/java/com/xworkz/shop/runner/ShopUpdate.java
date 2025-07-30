package com.xworkz.shop.runner;

import com.xworkz.shop.bakery.BakeryEntity;
import com.xworkz.shop.ecom.ClothesEntity;

import javax.persistence.*;

public class ShopUpdate {

    public static void main(String[] args) {
//        BakeryEntity bakery = new BakeryEntity();
//        bakery.setName("Choco Muffin");
//        bakery.setCategory("Snack");
//        bakery.setPrice(120.0);
//
//        ClothesEntity clothes = new ClothesEntity();
//        clothes.setCategory("T-Shirt");
//        clothes.setSize("L");
//        clothes.setBrand("Puma");
//        clothes.setPrice(899.0);

        EntityManagerFactory emf =null;
        EntityManager manager =null;
        EntityTransaction entityTransaction =null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            manager = emf.createEntityManager();
            entityTransaction = manager.getTransaction();

            entityTransaction.begin();
            BakeryEntity bakery= manager.find(BakeryEntity.class,1);
            if (bakery!=null) {
            bakery.setPrice(200.0);
            }
            entityTransaction.commit();

            System.out.println("Updated :"+bakery);
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
