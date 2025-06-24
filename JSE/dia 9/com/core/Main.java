package com.core;

import java.sql.Connection;

import com.core.DB.ConnectDB;
import com.core.DB.VeterinarioDAO;

public class Main {

    public static void main(String[] args){

        /*  Connection conn = ConnectDB.connect();
        String resp = (conn != null)?"Connected!":"There was an error connecting";
        System.out.println(resp); */

        VeterinarioDAO vDao = new VeterinarioDAO();

        //vDao.printTodoMascotas();
        //vDao.findMascotas(null,"Perro");
        //vDao.runMascotasQuery("m.nombre");
        //vDao.insertDepartment("departamento secreto", "planta -10", "bottom text");
        vDao.revisarCitas(4);
    }


}
