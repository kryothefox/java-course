package com.core.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {

    private static final String connectionStr = "jdbc:mysql://localhost:3306/clinica_veterinaria";
    private static final String userName = "root";
//    SQL script to change password:
//    ALTER USER 'root'@'localhost' IDENTIFIED WITH caching_sha2_password BY 'admin@1234';
//    FLUSH PRIVILEGES;
    private static final String userPassword = "admin@1234";

    public static Connection connect(){

        Connection conn;
        try {
            conn = DriverManager.getConnection(connectionStr, userName, userPassword);
        } catch (Exception e) {
            conn = null;
            System.out.println("There was an error connecting to the DB: " + e.getMessage());
        }

        return conn;
    }

}
