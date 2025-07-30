package com.xworkz.demo.runner;

import com.xworkz.shop.passport.PassportApplicationEntity;
import com.xworkz.shop.voter.VoterCandidateEntity;

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

            PassportApplicationEntity passport = manager.find(PassportApplicationEntity.class, 1);
            if (passport != null) {
                passport.setStatus("Approved");
                System.out.println("Updated Passport Status");
            }

            VoterCandidateEntity voter = manager.find(VoterCandidateEntity.class, 1);
            if (voter != null) {
                voter.setParty("People's Reform Party");
                System.out.println("Updated Voter Party");
            }

            transaction.commit();
            System.out.println("Update committed successfully.");
        } catch (PersistenceException e) {
            e.printStackTrace();
            if (transaction != null) transaction.rollback();
            System.out.println("Rollback executed.");
        } finally {
            if (manager != null) manager.close();
            if (emf != null) emf.close();
        }
    }
}
