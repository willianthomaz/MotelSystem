package com.motel.app.database;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PessoaDAOImpl implements PessoaDAO {

    private Connection getConnection() throws SQLException {
        URL resource = PessoaDAOImpl.class.getClassLoader().getResource("db/controle.mdb");
        if (resource == null) {
            throw new SQLException("Database file not found.");
        }
        String dbPath = new File(resource.getFile()).getAbsolutePath();
        String url = "jdbc:ucanaccess://" + dbPath;
        return DriverManager.getConnection(url);
    }

    @Override
    public void inserir(String usuario, String nomeCompleto, String cargo, String senha) {
        String sql = "INSERT INTO PESSOA (usuario, nome_completo, cargo, senha) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario);
            stmt.setString(2, nomeCompleto);
            stmt.setString(3, cargo);
            stmt.setString(4, senha);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void alterar(String usuario, String nomeCompleto, String cargo, String senha) {
        String sql = "UPDATE PESSOA SET nome_completo = ?, cargo = ?, senha = ? WHERE usuario = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nomeCompleto);
            stmt.setString(2, cargo);
            stmt.setString(3, senha);
            stmt.setString(4, usuario);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluir(String usuario) {
        String sql = "DELETE FROM PESSOA WHERE usuario = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
