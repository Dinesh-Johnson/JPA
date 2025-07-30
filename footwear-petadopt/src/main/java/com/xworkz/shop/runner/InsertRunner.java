package com.xworkz.shop.runner;

import com.xworkz.shop.footwear.FootwearEntity;
import com.xworkz.shop.pet.PetAdoptionEntity;

import javax.persistence.*;

public class InsertRunner {

    public static void main(String[] args) {
        FootwearEntity shoe = new FootwearEntity();
        shoe.setBrand("Nike");
        shoe.setCategory("Running");
        shoe.setSize("9");
        shoe.setPrice(4499.0);

        PetAdoptionEntity pet = new PetAdoptionEntity();
        pet.setName("Simba");
        pet.setBreed("Golden Retriever");
        pet.setAge(3);
        pet.setAdoptionStatus("Available");

        EntityManagerFactory emf = null;
        EntityManager manager = null;
        EntityTransaction transaction = null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            manager = emf.createEntityManager();
            transaction = manager.getTransaction();

            transaction.begin();
            manager.persist(shoe);
            manager.persist(pet);
            transaction.commit();

            System.out.println("Footwear and Pet inserted successfully.");
        } catch (PersistenceException e) {
            e.printStackTrace();
            if (transaction != null) transaction.rollback();
        } finally {
            if (manager != null) manager.close();
            if (emf != null) emf.close();
        }
    }
}
