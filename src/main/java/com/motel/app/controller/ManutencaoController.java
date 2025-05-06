package com.motel.app.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class ManutencaoController {

    @FXML
    private ComboBox<String> cboNumeroApto;

    @FXML
    private TextField txtMotivo;

    @FXML
    private void handleSair() {
        Stage stage = (Stage) cboNumeroApto.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void handleCancelar() {
        cboNumeroApto.getSelectionModel().clearSelection();
        txtMotivo.clear();
    }

    @FXML
    private void handleOk() {
        String apto = cboNumeroApto.getValue();
        String motivo = txtMotivo.getText();

        if (apto == null || apto.isEmpty()) {
            showAlert("Selecione o número do apartamento.");
            return;
        }

        if (motivo == null || motivo.trim().isEmpty()) {
            showAlert("Informe o motivo da manutenção.");
            return;
        }

        // Aqui você pode adicionar a lógica de gravação da manutenção
        showAlert("Manutenção registrada com sucesso!");
        handleCancelar();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Aviso");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
