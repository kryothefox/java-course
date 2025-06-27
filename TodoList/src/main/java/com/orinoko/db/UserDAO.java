package com.orinoko.db;

import com.orinoko.models.AppUser;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.PersistenceUnit;


@SuppressWarnings("unused")
public class UserDAO implements AutoCloseable, OperationsCRUD<AppUser> {

    @PersistenceContext(name = "TodoListPU")
    private EntityManager em;

    @Override
    public boolean create(AppUser t) throws PersistenceException {
        try {
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
            return true;
        } catch (PersistenceException p) {
            System.err.println("Causa: "+p.getCause()+" - Mensaje:"+p.getMessage());
            return false;
        }
    }

    @Override
    public AppUser findById(int id) throws PersistenceException {
        return em.find(AppUser.class, id);
    }

    @Override
    public AppUser findByName(String name) throws PersistenceException {
       return  em.createNamedQuery("AppUser.findByUsername",AppUser.class)
               .setParameter("username", name).getSingleResult();
    }

    @Override
    public void close() throws Exception {
        em.close();
    }

}
