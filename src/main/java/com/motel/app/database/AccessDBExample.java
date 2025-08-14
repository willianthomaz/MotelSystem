package com.motel.app.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccessDBExample {
    public static void main(String[] args) {
        try (Connection conn = AccessConnectionFactory.getConnection()) {
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
