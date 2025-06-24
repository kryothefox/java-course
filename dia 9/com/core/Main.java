package com.core;

import java.sql.Connection;

import com.core.DB.ConnectDB;

public class Main {

    public static void main(String[] args){
        Connection conn = ConnectDB.connect();
        String resp = (conn != null)?"Connected!":"There was an error connecting";
        System.out.println(resp);
                
    }


}
