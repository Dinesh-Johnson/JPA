package com.xworkz.shop.runner;

import com.xworkz.shop.chocolate.ChocolateIngredientEntity;
import com.xworkz.shop.soap.SoapEntity;

import javax.persistence.*;

public class UpdateRunner {

    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager manager = null;
        EntityTransaction transaction = null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            manager = emf.createEntityManager();
            transaction = manager.getTransaction();

            transaction.begin();

            ChocolateIngredientEntity chocolate = manager.find(ChocolateIngredientEntity.class, 1);
            if (chocolate != null) {
                chocolate.setQuantity(5.0);
                chocolate.setUnit("kg");
            }

            SoapEntity soap = manager.find(SoapEntity.class, 1);
            if (soap != null) {
                soap.setPrice(70.0);
            }

            transaction.commit();
            System.out.println("Entities updated successfully.");
        } catch (PersistenceException e) {
            e.printStackTrace();
            if (transaction != null) transaction.rollback();
        } finally {
            if (manager != null) manager.close();
            if (emf != null) emf.close();
        }
    }
}
