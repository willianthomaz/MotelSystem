package com.motel.app.database;

import java.sql.*;

public class AccessDBExample {
    public static void main(String[] args) {
        String dbPath = "src/main/resources/database/controle.mdb"; // ajuste o caminho conforme necessário
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
