package com.todolist.logic;

import com.todolist.models.AppUser;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Objects;


@Named("userBean") // Could be @ManagedBean() if Legacy
@SessionScoped
public class AppUserManager implements Serializable {

    private String username, password;
    private AppUser currentUser;
    /**
     * Creates a new instance of AppUserManager
     */
    // CONSTRUCTORS
    public AppUserManager() {
     
    }
    // APPLICATION LOGIC
    
    @SuppressWarnings("unused")
    public String login(){
        if(currentUser.getUsername().equals("Meowzers")){
            return "Home";
        } 
        return "";
    }
    
    
    // SETTERS AND GETTERS
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AppUser getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(AppUser currentUser) {
        this.currentUser = currentUser;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.username);
        hash = 89 * hash + Objects.hashCode(this.password);
        return hash;
    }

        @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AppUserManager other = (AppUserManager) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return Objects.equals(this.currentUser, other.currentUser);
    }

    @Override
    public String toString() {
        return "AppUserManager{" + "username=" + username + ", password=" + password + ", currentUser=" + currentUser + '}';
    }
    
    
    
}
