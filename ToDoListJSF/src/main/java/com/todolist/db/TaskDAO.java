package com.todolist.db;

import com.todolist.models.Tasks;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceException;

public class TaskDAO extends GenericDAO<Tasks> {

    public TaskDAO() {
        super(Tasks.class);
    }

    @Override
    public Tasks findByName(String name) throws PersistenceException {
        try {
            em.clear();
            Tasks task = em.createNamedQuery("Tasks.findByTaskName", Tasks.class)
                    .setParameter("taskname", name)
                    //.getResultStream().findFirst().orElse(null);
                    .getSingleResult();
            if (task != null) {
                em.refresh(task);
            }
            return task;
        } catch (NoResultException nre) {
            return null;
        } catch (Exception e) {
            throw new PersistenceException("Error finding AppUser by name", e);
        }

    }
    
}
