package com.xworkz.shop.runner;

import com.xworkz.shop.footwear.FootwearEntity;
import com.xworkz.shop.pet.PetAdoptionEntity;

import javax.persistence.*;

public class ReadRunner {

    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager manager = null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            manager = emf.createEntityManager();

            FootwearEntity shoe = manager.find(FootwearEntity.class, 1);
            PetAdoptionEntity pet = manager.find(PetAdoptionEntity.class, 1);

            System.out.println(shoe);
            System.out.println(pet);
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            if (manager != null) manager.close();
            if (emf != null) emf.close();
        }
    }
}
