package com.todolist.logic;

import com.todolist.db.UserDAO;
import com.todolist.models.AppUser;
import com.todolist.models.Tasks;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.Objects;

@Named(value = "userBean") //@ManagedBean
@SessionScoped
public class AppUserManager implements Serializable {
    
    private AppUser currentUser;
    private Tasks newTask;
    private String errorMessage;

    @Inject
    private TasksManager tasksManager;
    
    public AppUserManager() {
        this.currentUser = new AppUser();
        this.newTask = new Tasks();
    }
    
    // Lógica
    public String login() {
        try (UserDAO udb = new UserDAO()) {
            AppUser newUser = udb.findByName(currentUser.getUsername());
            System.out.println("login initiated with " + newUser.getUsername() + newUser.getPassword());
            if (newUser != null && newUser.getPassword().equals(currentUser.getPassword())) {
                currentUser = newUser;
                errorMessage = "";
                return "home";
            } else {
                errorMessage = "Usuario o contraseña incorrectos, inténtalo de nuevo.";
            }
        } catch (Exception e) {
            errorMessage = "Se ha producido algún error con el usuario o la contraseña, inténtalo de nuevo.";
            Throwable cause = e.getCause();
            System.err.println("Error logging in. Cause: " + (cause != null ? cause.getMessage() : "Unknown")
                    + " - Message: " + e.getMessage());
        }
        return "";
    }
    public String createUser() {
        try (UserDAO udb = new UserDAO()) {
            udb.create(currentUser);
            currentUser = new AppUser();
            return "index";
        } catch (Exception e) {
            Throwable cause = e.getCause();
            System.err.println("Error creating a user. Cause: " + (cause != null ? cause.getMessage() : "Unknown")
                    + " - Message: " + e.getMessage());
        }
        return "";
    }
    
    public void createTask() {
        currentUser = tasksManager.createTask(currentUser, newTask);
        newTask = new Tasks();
    }

    public void delete(int taskId) {
        currentUser = tasksManager.deleteTask(currentUser, taskId);
    }

    public AppUser getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(AppUser currentUser) {
        this.currentUser = currentUser;
    }

    public Tasks getNewTask() {
        return newTask;
    }

    public void setNewTask(Tasks newTask) {
        this.newTask = newTask;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.currentUser);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final AppUserManager other = (AppUserManager) obj;
        return Objects.equals(this.currentUser, other.currentUser);
    }
    
}
