package com.motel.app.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

public class FazerLimpezaController {

    @FXML
    private ComboBox<String> comboApto;

    @FXML
    private Button btnSair;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnOk;

    @FXML
    public void initialize() {
        // Inicializa o ComboBox com valores de exemplo
        comboApto.getItems().addAll("101", "102", "103", "104", "105"); // Substituir por dados reais
    }

    @FXML
    private void onSairClick(ActionEvent event) {
        // Ação de sair
        System.out.println("Saindo da tela de limpeza...");
        // Aqui você pode fechar a janela, por exemplo
        btnSair.getScene().getWindow().hide();
    }

    @FXML
    private void onCancelarClick(ActionEvent event) {
        // Ação de cancelar seleção
        comboApto.getSelectionModel().clearSelection();
    }

    @FXML
    private void onOkClick(ActionEvent event) {
        String aptoSelecionado = comboApto.getValue();
        if (aptoSelecionado != null) {
            System.out.println("Iniciando limpeza no apto " + aptoSelecionado);
            // Chamar lógica de iniciar limpeza...
        } else {
            System.out.println("Nenhum apartamento selecionado.");
        }
    }
}
