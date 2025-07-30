package com.xworkz.demo.runner;
import com.xworkz.shop.passport.PassportApplicationEntity;
import com.xworkz.shop.voter.VoterCandidateEntity;

import javax.persistence.*;

public class ReadRunner {

    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager manager = null;

        try {
            emf = Persistence.createEntityManagerFactory("x-workz");
            manager = emf.createEntityManager();

            PassportApplicationEntity passport = manager.find(PassportApplicationEntity.class, 1);
            VoterCandidateEntity voter = manager.find(VoterCandidateEntity.class, 1);

            System.out.println(passport);
            System.out.println(voter);
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            if (manager != null) manager.close();
            if (emf != null) emf.close();
        }
    }
}