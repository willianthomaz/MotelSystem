package com.motel.app.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class EntradaController {

    @FXML
    private ComboBox<String> comboApto;

    @FXML
    private TextField txtHora;

    @FXML
    private TextField txtData;

    @FXML
    private TextField txtValor;

    @FXML
    private RadioButton radioNormal;

    @FXML
    private RadioButton radioEspecial;

    @FXML
    private RadioButton radio2p;

    @FXML
    private RadioButton radio3p;

    @FXML
    private RadioButton radio4p;

    @FXML
    private RadioButton radioSim;

    @FXML
    private RadioButton radioNao;

    @FXML
    private Label labelMensagem;

    @FXML
    private Button btnSair;

    @FXML
    private Button btnCancela;

    @FXML
    private Button btnOk;

    @FXML
    public void initialize() {
        // Popula comboBox como exemplo
        comboApto.getItems().addAll("101", "102", "103", "104");

        // Agrupamentos dos RadioButtons para escolha única
        ToggleGroup tabelaGroup = new ToggleGroup();
        radioNormal.setToggleGroup(tabelaGroup);
        radioEspecial.setToggleGroup(tabelaGroup);

        ToggleGroup pessoasGroup = new ToggleGroup();
        radio2p.setToggleGroup(pessoasGroup);
        radio3p.setToggleGroup(pessoasGroup);
        radio4p.setToggleGroup(pessoasGroup);

        ToggleGroup imprimirGroup = new ToggleGroup();
        radioSim.setToggleGroup(imprimirGroup);
        radioNao.setToggleGroup(imprimirGroup);
    }

    @FXML
    private void handleOk() {
        labelMensagem.setText("Dados registrados com sucesso.");
    }

    @FXML
    private void handleCancelar() {
        comboApto.getSelectionModel().clearSelection();
        txtHora.clear();
        txtData.clear();
        txtValor.clear();
        labelMensagem.setText("");
    }

    @FXML
    private void handleSair() {
        System.exit(0); // Ou feche apenas a janela
    }
}
