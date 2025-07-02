package com.planify.db;


import com.planify.models.AppUser;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import jakarta.validation.ConstraintViolationException;
import java.io.Closeable;
import java.io.IOException;

public abstract class GenericDAO<T> implements Closeable, OperationsCRUD<T> {

    //@PersistenceContext(unitName = "ToDoListPU")
    public EntityManager em;
    private final EntityManagerFactory emf
            = Persistence.createEntityManagerFactory("ToDoListPU");
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
        } catch (PersistenceException e) {
            System.err.println("Cause: " + e.getCause().getMessage()
                    + " - Message: " + e.getMessage());
            return false;
        } catch (ConstraintViolationException e) {
            throw e;
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
            System.err.println(e.getCause() + " - " + e.getMessage());
        }
    }

    
    @Override
    public void close() {
        em.close();
    }
}
