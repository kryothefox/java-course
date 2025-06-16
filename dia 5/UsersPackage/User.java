package UsersPackage;

import java.io.Serializable;

public class User implements Serializable{

    String userString;
    String passwordString;

    public User(){}

    

    public User(String userString, String passwordString) {
        this.userString = userString;
        this.passwordString = passwordString;
    }

    

    @Override
    public String toString() {
        return "User [userString=" + userString + ", passwordString=" + passwordString + "]";
    }



    public void sayHello() {
        System.out.println("Hello " + userString);
    }

    public String getUserString() {
        return userString;
    }

    public void setUserString(String userString) {
        this.userString = userString;
    }

    public String getPasswordString() {
        return passwordString;
    }
    
    public void setPasswordString(String passwordString) {
        this.passwordString = passwordString;
    }
}
