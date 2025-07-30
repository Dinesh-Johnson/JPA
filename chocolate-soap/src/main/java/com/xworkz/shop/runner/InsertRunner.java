package com.xworkz.shop.runner;

import com.xworkz.shop.chocolate.ChocolateIngredientEntity;
import com.xworkz.shop.soap.SoapEntity;

import javax.persistence.*;

public class InsertRunner {

    public static void main(String[] args) {
        ChocolateIngredientEntity chocolate = new ChocolateIngredientEntity();
        chocolate.setName("Cocoa Butter");
        chocolate.setType("Fat");
        chocolate.setQuantity(3.5);
        chocolate.setUnit("kg");

        SoapEntity soap = new SoapEntity();
        soap.setBrand("Dove");
        soap.setFragrance("Jasmine");
        soap.setWeight(125.0);
        soap.setPrice(62.0);

        EntityManagerFactory emf = null;
        EntityManager manager = null;
        EntityTransaction transaction = null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            manager = emf.createEntityManager();
            transaction = manager.getTransaction();

            transaction.begin();
            manager.persist(chocolate);
            manager.persist(soap);
            transaction.commit();

            System.out.println("Entities inserted successfully.");
        } catch (PersistenceException e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            if (manager != null) manager.close();
            if (emf != null) emf.close();
        }
    }
}
