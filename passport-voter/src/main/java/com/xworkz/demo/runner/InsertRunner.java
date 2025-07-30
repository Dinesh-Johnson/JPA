package com.xworkz.demo.runner;

import com.xworkz.shop.passport.PassportApplicationEntity;
import com.xworkz.shop.voter.VoterCandidateEntity;

import javax.persistence.*;

public class InsertRunner {

    public static void main(String[] args) {
        PassportApplicationEntity passport = new PassportApplicationEntity();
        passport.setName("Arun Kumar");
        passport.setNationality("Indian");
        passport.setDob("1995-04-18");
        passport.setStatus("Pending");

        VoterCandidateEntity voter = new VoterCandidateEntity();
        voter.setName("Seema Joshi");
        voter.setParty("Unity Party");
        voter.setConstituency("North Zone");
        voter.setAge(42);

        EntityManagerFactory emf = null;
        EntityManager manager = null;
        EntityTransaction transaction = null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            manager = emf.createEntityManager();
            transaction = manager.getTransaction();

            transaction.begin();
            manager.persist(passport);
            manager.persist(voter);
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
