package com.motel.app.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.motel.app.database.AccessConnectionFactory;

public class CancelaSaidaController {

    @FXML
    private ComboBox<String> cboApto;

    @FXML
    public void initialize() {
        carregarAptosDoBanco();
    }

    private void carregarAptosDoBanco() {
        try (Connection conn = AccessConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT Numero FROM APTO")) {

            while (rs.next()) {
                String numero = rs.getString("Numero");
                cboApto.getItems().add(numero);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onOkClick() {
        System.out.println("Selecionado: " + cboApto.getValue());
    }

    @FXML
    private void onCancelaClick() {
        cboApto.getSelectionModel().clearSelection();
    }

    @FXML
    private void onSairClick() {
        System.exit(0);
    }
}
