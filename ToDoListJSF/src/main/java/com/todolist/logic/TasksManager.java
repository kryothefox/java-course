package com.todolist.logic;

import com.todolist.db.TaskDAO;
import com.todolist.db.UserDAO;
import com.todolist.models.AppUser;
import com.todolist.models.Tasks;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import java.io.Serializable;
import java.util.Date;

@Named(value = "tasksManager") //@ManagedBean
@RequestScoped
public class TasksManager implements Serializable {

    public AppUser createTask(AppUser currentUser, Tasks newTask) {
        newTask.setCreationDate(new Date());
        newTask.setUserId(currentUser);

        try (TaskDAO tdb = new TaskDAO();
             UserDAO udb = new UserDAO()) {
            tdb.create(newTask);
            return udb.findById(currentUser.getUserId());
        } catch (Exception e) {
            Throwable cause = e.getCause();
            System.err.println("Error creating a task. Cause: " + (cause != null ? cause.getMessage() : "Unknown")
                    + " - Message: " + e.getMessage());
        }
        return currentUser;
    }

    public AppUser deleteTask(AppUser currentUser, int taskId) {
        try (TaskDAO tdb = new TaskDAO();
             UserDAO udb = new UserDAO()) {
            tdb.delete(taskId);
            return udb.findById(currentUser.getUserId());
        } catch (Exception e) {
            Throwable cause = e.getCause();
            System.err.println("Error deleting a task. Cause: " + (cause != null ? cause.getMessage() : "Unknown")
                    + " - Message: " + e.getMessage());
        }
        return currentUser;
    }
}
