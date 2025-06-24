package com.core.DB;

import java.sql.*;

public class VeterinarioDAO {

    private String masterQuery = """
                    SELECT * FROM mascotas m
                    JOIN clientes c ON m.id_cliente = c.id_cliente
                    JOIN especies e ON m.id_especie = e.id_especie
            """;

    public void printMascotaDetalle(ResultSet rSet) throws SQLException {
        int idColumn = rSet.getInt("id_mascota");
        String especieNombre = rSet.getString("nombre_especie");
        String razaColumn = rSet.getString("raza");
        String nombreColumn = rSet.getString("nombre");
        Double pesoColumn = rSet.getDouble("peso");
        Date fechaN = rSet.getDate("fecha_nacimiento");
        String sexoColumn = rSet.getString("sexo");
        String observacionesColumn = rSet.getString("observaciones");
        boolean estadoActivo = rSet.getBoolean("activo");

        System.out.println(
                "-".repeat(30) +
                        "\nid mascota " + idColumn
                        + "\nnombre: " + nombreColumn
                        + "\nespecie: " + especieNombre
                        + "\nraza: " + razaColumn
                        + "\npeso(kg): " + pesoColumn
                        + "\nfecha de nacimiento: " + fechaN
                        + "\nsexo: " + sexoColumn + "\n"
                        + "\nOBSERVACIONES: " + "\n" + observacionesColumn + "\n"
                        + "\nESTADO ACTIVO: " + (estadoActivo == true ? "SI" : "NO")
                        + "\n"
                        + "-".repeat(30));

    }

    public void findMascotas(String nameString, String especieString) {
        try (
                Connection con = ConnectDB.connect();
                Statement st = con.createStatement()) {
            String sqlQuery = """
                    SELECT * FROM mascotas m
                    JOIN clientes c ON m.id_cliente = c.id_cliente
                    JOIN especies e ON m.id_especie = e.id_especie
                    """;
            ResultSet rSet = st.executeQuery(sqlQuery);
            while (rSet.next()) {
                if (nameString != null) {
                    String nombreMascota = rSet.getString("nombre");
                    if (nombreMascota.equals(nameString)) {
                        printMascotaDetalle(rSet);
                    }
                } else {
                    String especieNombre = rSet.getString("nombre_especie");
                    if (especieNombre.equals(especieString)) {
                        printMascotaDetalle(rSet);
                    }
                }

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public boolean insertDepartment(String nombre_departamento, String ubicacion, String descripcion){
        
        try (
            Connection conn = ConnectDB.connect();
            PreparedStatement pst = conn.prepareStatement(
                """
                    INSERT INTO departamentos
                    (nombre_departamento,ubicacion,descripcion)
                    VALUES (? ? ?)
                """);
        ) {
            
            pst.setString(1,nombre_departamento);
            pst.setString(2,ubicacion);
            pst.setString(3,descripcion);
            return pst.execute();
    
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    public void runMascotasQuery(String queryString) throws SQLException {

        Connection con = ConnectDB.connect();
        PreparedStatement pst = con.prepareStatement(masterQuery + "?;");
        ResultSet rSet = pst.executeQuery(queryString);
        while (rSet.next()) {
            
        }

    }
}
