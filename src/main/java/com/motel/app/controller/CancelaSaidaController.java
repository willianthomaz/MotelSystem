package com.motel.app.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CancelaSaidaController {

    private static final Logger logger = LoggerFactory.getLogger(CancelaSaidaController.class);

    @FXML
    private ComboBox<String> cboApto;

    @FXML
    public void initialize() {
        carregarAptosDoBanco();
    }

    private void carregarAptosDoBanco() {
        String dbPath = "src/main/resources/db/controle.mdb"; // ajuste se necessário
        String url = "jdbc:ucanaccess://" + dbPath;

        try (Connection conn = DriverManager.getConnection(url);
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
        logger.debug("Selecionado: {}", cboApto.getValue());
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
