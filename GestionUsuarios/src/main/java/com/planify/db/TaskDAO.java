package com.planify.db;

import com.planify.models.Tasks;

import jakarta.persistence.PersistenceException;
import jakarta.validation.ConstraintViolationException;

public class TaskDAO extends GenericDAO implements OperationsCRUD<Tasks>{

    @Override
    public boolean create(Object t) throws ConstraintViolationException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public Object findById(int id) throws PersistenceException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Object findByName(String name) throws PersistenceException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByName'");
    }

    @Override
    public void delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public boolean create(Tasks t) throws ConstraintViolationException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public void close() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'close'");
    }
    
}
