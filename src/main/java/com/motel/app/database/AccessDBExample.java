package com.motel.app.database;

import java.io.File;
import java.net.URL;
import java.sql.*;

public class AccessDBExample {
    public static void main(String[] args) {
        URL resource = AccessDBExample.class.getClassLoader().getResource("db/controle.mdb");
        if (resource == null) {
            System.err.println("Database file not found.");
            return;
        }
        String dbPath = new File(resource.getFile()).getAbsolutePath();
        String url = "jdbc:ucanaccess://" + dbPath;

        try (Connection conn = DriverManager.getConnection(url)) {
            System.out.println("Conectado com sucesso!");

            String query = "SELECT * FROM APTO";
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {

                while (rs.next()) {
                    int numero = rs.getInt("Numero");
                    String status = rs.getString("Status");
                    System.out.println("Apto: " + numero + " | Status: " + status);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
