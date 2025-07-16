package com.videogame.front.db;

import jakarta.persistence.PersistenceException;
import jakarta.validation.ConstraintViolationException;

public interface OperationsCRUD<T> {
    
    public boolean create(T t) throws ConstraintViolationException;
    
    public T findById(int id) throws PersistenceException;
    
    public T findByName(String name) throws PersistenceException;
    
    public void delete(int id);
    
}
