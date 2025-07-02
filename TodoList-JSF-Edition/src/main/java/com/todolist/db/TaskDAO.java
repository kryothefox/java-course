package com.todolist.db;

import com.todolist.models.Tasks;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceException;

public class TaskDAO extends GenericDAO<Tasks> {

    public TaskDAO() {
        super(Tasks.class);
    }

    @Override
    public Tasks findById(int id) throws PersistenceException {
        return em.find(Tasks.class, id);
    }

    @Override
    public Tasks findByName(String name) throws PersistenceException {
        try {
            return em.createNamedQuery("Tasks.findByTaskName", Tasks.class)
                    .setParameter("task_name", name)
                    // .getResultStream().findFirst().orElse(null);
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new PersistenceException("Error finding AppUser by name", e);
        }

    }

}
