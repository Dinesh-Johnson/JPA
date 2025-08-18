package com.xworkz.registraition.utill;

import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

@Component
public class DBConnection {

    private EntityManagerFactory emf;

    public EntityManager entityManager()
    {
        if (emf == null) {

            try {
                emf = Persistence.createEntityManagerFactory("x-workz");
            } catch (PersistenceException e) {
                System.out.println(e.getMessage());
            }

        }
        return emf.createEntityManager();
    }

    @PreDestroy
    public void close(){
        if (emf!=null&& emf.isOpen()){
            emf.close();
        }
    }
}
