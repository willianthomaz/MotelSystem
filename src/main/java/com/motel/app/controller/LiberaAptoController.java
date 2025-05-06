package com.motel.app.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class LiberaAptoController {

    @FXML
    private ComboBox<String> cboNumeroApto;

    @FXML
    private ComboBox<String> cboCamareira;

    @FXML
    private PasswordField txtSenha;

    @FXML
    private void initialize() {
        // Popular combos com dados fictícios ou de um serviço
        cboNumeroApto.getItems().addAll("101", "102", "103", "104");
        cboCamareira.getItems().addAll("Maria", "Joana", "Patrícia");
    }

    @FXML
    private void handleSair() {
        System.exit(0); // ou fechar somente a janela atual se preferir
    }

    @FXML
    private void handleCancelar() {
        cboNumeroApto.getSelectionModel().clearSelection();
        cboCamareira.getSelectionModel().clearSelection();
        txtSenha.clear();
    }

    @FXML
    private void handleOk() {
        String numeroApto = cboNumeroApto.getValue();
        String camareira = cboCamareira.getValue();
        String senha = txtSenha.getText();

        if (numeroApto == null || camareira == null || senha.isEmpty()) {
            exibirAlerta("Preencha todos os campos.");
            return;
        }

        // Simulação de verificação de senha
        if (senha.equals("1234")) {
            exibirAlerta("Apartamento " + numeroApto + " liberado com sucesso!");
            handleCancelar();
        } else {
            exibirAlerta("Senha incorreta!");
        }
    }

    private void exibirAlerta(String mensagem) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Aviso");
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
