package com.planify.db;

import com.planify.models.AppUser;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import jakarta.validation.ConstraintViolationException;
import java.io.Closeable;

public class UserDAO extends GenericDAO implements OperationsCRUD<AppUser> {
    


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
    public void delete(int id) {
        try {
            em.getTransaction().begin();
            em.remove(id);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(e.getCause() + " - " + e.getMessage());
        }
    }

    @Override
    public void close() {
        em.close();
    }

}
