package com.motel.app.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PessoaDAOImpl implements PessoaDAO {

    @Override
    public void inserir(String usuario, String nomeCompleto, String cargo, String senha) {
        String sql = "INSERT INTO PESSOA (usuario, nome_completo, cargo, senha) VALUES (?, ?, ?, ?)";
        try (Connection conn = AccessConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
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
        try (Connection conn = AccessConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
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
        try (Connection conn = AccessConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
