package com.xworkz.shop.runner;

import com.xworkz.shop.footwear.FootwearEntity;
import com.xworkz.shop.pet.PetAdoptionEntity;

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

            FootwearEntity shoe = manager.find(FootwearEntity.class, 1);
            if (shoe != null) {
                shoe.setPrice(3999.0);
                System.out.println("Updated footwear price.");
            }

            PetAdoptionEntity pet = manager.find(PetAdoptionEntity.class, 1);
            if (pet != null) {
                pet.setAdoptionStatus("Adopted");
                System.out.println("Updated pet adoption status.");
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
