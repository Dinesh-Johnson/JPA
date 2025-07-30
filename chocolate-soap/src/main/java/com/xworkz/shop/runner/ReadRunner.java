package com.xworkz.shop.runner;

import com.xworkz.shop.chocolate.ChocolateIngredientEntity;
import com.xworkz.shop.soap.SoapEntity;

import javax.persistence.*;

public class ReadRunner {

    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager manager = null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            manager = emf.createEntityManager();

            ChocolateIngredientEntity chocolate = manager.find(ChocolateIngredientEntity.class, 1);
            SoapEntity soap = manager.find(SoapEntity.class, 1);

            System.out.println(chocolate);
            System.out.println(soap);
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            if (manager != null) manager.close();
            if (emf != null) emf.close();
        }
    }
}
