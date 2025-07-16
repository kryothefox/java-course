package com.gregor.videogameapi.db;

import com.gregor.videogameapi.models.Games;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceException;

public class GameDAO extends GenericDAO<Games>{

    public GameDAO() {
        super(Games.class);
    }

    @Override
    public Games findByName(String name) throws PersistenceException {
        try {
            em.clear();
            Games game = em.createNamedQuery("Games.findByName", Games.class)
                     .setParameter("name", name)
                     .getSingleResult();
            if (game != null) {
                em.refresh(game);
            }
            return game;
        } catch (NoResultException nre) {
            return null;
        } catch (Exception e) {
            throw new PersistenceException("Error finding Games by name", e);
        }
    }
}
