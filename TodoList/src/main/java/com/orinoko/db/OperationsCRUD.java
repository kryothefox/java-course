package com.orinoko.db;

import jakarta.persistence.PersistenceException;

public interface OperationsCRUD<T> {
    
    public boolean create(T t) throws PersistenceException;
    
    public T findById(int id) throws PersistenceException;
    
    public T findByName(String name) throws PersistenceException;
    
        
}
