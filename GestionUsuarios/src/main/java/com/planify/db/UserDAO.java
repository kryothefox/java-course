package com.planify.db;

import com.planify.models.AppUser;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import jakarta.validation.ConstraintViolationException;
import java.io.Closeable;

public class UserDAO implements Closeable, OperationsCRUD<AppUser> {
    
    //@PersistenceContext(unitName = "ToDoListPU")
    private EntityManager em;
    private final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("ToDoListPU");

    public UserDAO() {
        em = emf.createEntityManager();
    }

    @Override
    public boolean create(AppUser t) throws ConstraintViolationException {
        try {
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
            return true;
        } catch (PersistenceException e) {
            System.err.println("Cause: " + e.getCause().getMessage()
                    + " - Message: " + e.getMessage());
            return false;
        } catch (ConstraintViolationException e) {
            throw e;
        }
    }

    @Override
    public AppUser findById(int id) throws PersistenceException {
        return em.find(AppUser.class, id);
    }

    @Override
    public AppUser findByName(String name) throws PersistenceException {
        try {
            return em.createNamedQuery("AppUser.findByUsername", AppUser.class)
                     .setParameter("username", name)
                     .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new PersistenceException("Error finding AppUser by name", e);
        }
    }

    @Override
    public void close() {
        em.close();
    }
}
