package com.motel.app.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class CorrigeSaldoController {

    @FXML
    private ComboBox<String> cboApto;

    @FXML
    private TextField txtSaldo;

    @FXML
    public void initialize() {
        // Aqui você pode carregar os apartamentos disponíveis
        cboApto.getItems().addAll("101", "102", "103"); // Substitua pelos dados reais
    }

    @FXML
    private void onCorrigirClick() {
        String apto = cboApto.getValue();
        String saldoStr = txtSaldo.getText();

        if (apto == null || apto.isEmpty() || saldoStr == null || saldoStr.isEmpty()) {
            mostrarAlerta("Erro", "Preencha todos os campos.");
            return;
        }

        try {
            double saldo = Double.parseDouble(saldoStr);
            // Aqui você deve atualizar o saldo do apartamento selecionado no banco de dados
            mostrarAlerta("Sucesso", "Saldo atualizado com sucesso para o apartamento " + apto + ".");
        } catch (NumberFormatException e) {
            mostrarAlerta("Erro", "Saldo inválido.");
        }
    }

    @FXML
    private void onSairClick() {
        // Lógica para fechar a tela, se necessário
        System.exit(0);
    }

    private void mostrarAlerta(String titulo, String mensagem) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
