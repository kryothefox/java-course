/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.videogame.front.userlogic;

import com.videogame.front.db.UserDAO;
import com.videogame.front.user.entity.User;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author manana
 */
@Named(value = "userHandler")
@SessionScoped
public class UserHandler implements Serializable {

    /**
     * Creates a new instance of UserHandler
     */
    
    private User currentUser;
    private String errorMessage;

    //@Inject
    //private TasksManager tasksManager;
    
    public UserHandler() {
        this.currentUser = new User();
        
    }
    
    // Lógica
    public String login() {
        try (UserDAO udb = new UserDAO()) {
            User newUser = udb.findByName(currentUser.getUsername());
            System.out.println("login initiated with " + newUser.getUsername() + newUser.getPassword());
            if (newUser != null && newUser.getPassword().equals(currentUser.getPassword())) {
                currentUser = newUser;
                errorMessage = "";
                return "index";
            } else {
                errorMessage = "User or password incorrect";
            }
        } catch (Exception e) {
            errorMessage = "There was an error logging in";
            Throwable cause = e.getCause();
            System.err.println("Error logging in. Cause: " + (cause != null ? cause.getMessage() : "Unknown")
                    + " - Message: " + e.getMessage());
        }
        return "";
    }
    public String createUser() {
        try (UserDAO udb = new UserDAO()) {
            udb.create(currentUser);
            currentUser = new User();
            return "gameslist";
        } catch (Exception e) {
            Throwable cause = e.getCause();
            System.err.println("Error creating a user. Cause: " + (cause != null ? cause.getMessage() : "Unknown")
                    + " - Message: " + e.getMessage());
        }
        return "";
    }
    
    
 

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
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
        final UserHandler other = (UserHandler) obj;
        return Objects.equals(this.currentUser, other.currentUser);
    }
    
}
