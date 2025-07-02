package com.planify.db;


import com.planify.models.AppUser;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceException;
import jakarta.validation.ConstraintViolationException;

public class UserDAO extends GenericDAO<AppUser>{
    

    public UserDAO() {
        super(AppUser.class);
       
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

}
