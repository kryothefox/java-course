package com.todolist.db;

import com.todolist.models.AppUser;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceException;

public class UserDAO extends GenericDAO<AppUser>{

    public UserDAO() {
        super(AppUser.class);
    }

    @Override
    public AppUser findByName(String name) throws PersistenceException {
        try {
            em.clear();
            AppUser user = em.createNamedQuery("AppUser.findByUsername", AppUser.class)
                     .setParameter("username", name)
                     .getSingleResult();
            if (user != null) {
                em.refresh(user);
            }
            return user;
        } catch (NoResultException nre) {
            return null;
        } catch (Exception e) {
            throw new PersistenceException("Error finding AppUser by name", e);
        }
    }

}
