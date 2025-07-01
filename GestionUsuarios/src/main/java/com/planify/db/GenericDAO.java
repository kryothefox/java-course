package com.planify.db;

import java.io.Closeable;
import java.io.IOException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public abstract class GenericDAO implements Closeable {


    public EntityManager em;
    private final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("ToDoListPU");


    public GenericDAO(){
        em = emf.createEntityManager();
    }

    @Override
    public void close() throws IOException {
       em.close();
    }

}
