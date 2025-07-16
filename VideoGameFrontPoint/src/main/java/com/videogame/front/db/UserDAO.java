package com.videogame.front.db;


import com.videogame.front.user.entity.User;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceException;

public class UserDAO extends GenericDAO<User>{

    public UserDAO() {
        super( User.class);
    }

    @Override
    public User findByName(String name) throws PersistenceException {
        try {
            em.clear();
            User user = em.createNamedQuery("User.findByUsername", User.class)
                     .setParameter("username", name)
                     .getSingleResult();
            if (user != null) {
                em.refresh(user);
            }
            return user;
        } catch (NoResultException nre) {
            return null;
        } catch (Exception e) {
            throw new PersistenceException("Error finding User by name", e);
        }
    }

}
