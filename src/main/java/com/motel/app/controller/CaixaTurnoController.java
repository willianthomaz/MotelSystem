package com.motel.app.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class CaixaTurnoController {

    @FXML
    private TextArea textAreaCaixa;

    @FXML
    private Button btnSair;

    @FXML
    public void initialize() {
        // Simula carregamento de dados do turno
        textAreaCaixa.setText("Resumo do Caixa do Turno:\n\n" +
                "Entradas: R$ 1.200,00\n" +
                "Saídas: R$ 300,00\n" +
                "Saldo Atual: R$ 900,00\n");
    }

    @FXML
    private void handleSair() {
        // Fecha a janela atual
        Stage stage = (Stage) btnSair.getScene().getWindow();
        stage.close();
    }
}
