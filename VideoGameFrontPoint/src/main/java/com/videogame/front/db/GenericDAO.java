package com.videogame.front.db;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import jakarta.validation.ConstraintViolationException;
import java.io.Closeable;

public abstract class GenericDAO<T> implements Closeable, OperationsCRUD<T> {

    //@PersistenceContext(unitName = "ToDoListPU")
    public EntityManager em;
    private final EntityManagerFactory emf
            = Persistence.createEntityManagerFactory("userPU");
    private final Class<T> entityClass;

    public GenericDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
        em = emf.createEntityManager();
    }

    @Override
    public boolean create(T t) throws ConstraintViolationException {
        try {
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
            return true;
        } catch (PersistenceException pe) {
            Throwable cause = pe.getCause();
            System.err.println("Cause: " + (cause != null ? cause.getMessage() : "Unknown")
                    + " - Message: " + pe.getMessage());
            return false;
        } catch (ConstraintViolationException cve) {
            throw cve;
        }
    }

    @Override
    public void delete(int id) {
        try {
            em.getTransaction().begin(); 
            T t1 = em.find(entityClass, id);
            if(t1 != null) em.remove(t1);          
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            Throwable cause = e.getCause();
            System.err.println("Cause: " + (cause != null ? cause.getMessage() : "Unknown")
                    + " - Message: " + e.getMessage());
        }
    }
    
    @Override
    public T findById(int id) throws PersistenceException {
        em.clear();
        T t = em.find(entityClass, id);
        if (t != null) {
            em.refresh(t);
        }
        return t;
    }
    
    protected void refresh(T entity) {
        em.refresh(entity);
    }
    
    @Override
    public void close() {
        em.close();
    }
}
