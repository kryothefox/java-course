package com.gregor.videogameapi.db;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import jakarta.validation.ConstraintViolationException;
import java.io.Closeable;
import java.util.List;

public abstract class GenericDAO<T> implements Closeable, OperationsCRUD<T> {

    //@PersistenceContext(unitName = "VideogamePU")
    public EntityManager em;
    private final EntityManagerFactory emf
            = Persistence.createEntityManagerFactory("VideogamePU");
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
    public void update(T t) {
        try {
            if (!em.contains(t)) {
                em.getTransaction().begin();
                em.merge(t);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            Throwable cause = e.getCause();
            System.err.println("Cause: " + (cause != null ? cause.getMessage() : "Unknown")
                    + " - Message: " + e.getMessage());
        }
    }
    
    @Override
    public T findById(int id) throws PersistenceException {
        try {
            em.clear();
            T t = em.find(entityClass, id);
            if (t != null) {
                em.refresh(t);
            }
            return t;
        } catch (Exception e) {
            throw new PersistenceException("Error finding " + entityClass.getSimpleName() + " by id", e);
        }
    }
    
    public List<T> findAll() throws PersistenceException {
        try {
            em.clear();
            String jpql = "SELECT e FROM " + entityClass.getSimpleName() + " e";
            return em.createQuery(jpql, entityClass)
                     .getResultList();
        } catch (Exception e) {
            throw new PersistenceException("Error finding all " + entityClass.getSimpleName(), e);
        }
    }
    
    public List<T> findRange(int start, int size) throws PersistenceException {
        try {
            em.clear();
            String jpql = "SELECT e FROM " + entityClass.getSimpleName() + " e";
            return em.createQuery(jpql, entityClass)
                     .setFirstResult(start)
                     .setMaxResults(size)
                     .getResultList();
        } catch (Exception e) {
            throw new PersistenceException("Error retrieving paginated " + entityClass.getSimpleName(), e);
        }
    }
    
    protected void refresh(T entity) {
        em.refresh(entity);
    }
    
    @Override
    public void close() {
        em.close();
    }
}
