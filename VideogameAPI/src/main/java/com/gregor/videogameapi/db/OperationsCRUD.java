package com.gregor.videogameapi.db;

import jakarta.persistence.PersistenceException;
import jakarta.validation.ConstraintViolationException;

public interface OperationsCRUD<T> {
    
    public boolean create(T t) throws ConstraintViolationException;
    
    public T findById(int id) throws PersistenceException;
    
    public T findByName(String name) throws PersistenceException;
    
    public void update(T t);
    
    public void delete(int id);
    
}
