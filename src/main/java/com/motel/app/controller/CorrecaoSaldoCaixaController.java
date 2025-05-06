package com.motel.app.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.text.DecimalFormat;

public class CorrecaoSaldoCaixaController {

    @FXML
    private Label labelSaldoCaixa;

    @FXML
    private Label labelSomatorio;

    @FXML
    private Label labelSaldoAtual;

    @FXML
    private TextField textRetirada;

    @FXML
    private Button btnSair;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnOk;

    private double saldoAtual = 200.00; // Exemplo inicial. No real, traga do banco de dados

    private final DecimalFormat df = new DecimalFormat("#,##0.00");

    @FXML
    public void initialize() {
        atualizarExibicao();
        textRetirada.textProperty().addListener((obs, oldVal, newVal) -> atualizarExibicao());
    }

    private void atualizarExibicao() {
        double retirada = 0.0;
        try {
            retirada = Double.parseDouble(textRetirada.getText().replace(",", "."));
        } catch (NumberFormatException ignored) {}

        double novoSaldo = saldoAtual - retirada;
        labelSaldoCaixa.setText("Saldo em caixa: R$ " + df.format(saldoAtual));
        labelSomatorio.setText("Retirada: R$ " + df.format(retirada));
        labelSaldoAtual.setText("Saldo Atual: R$ " + df.format(novoSaldo));
    }

    @FXML
    private void handleOk() {
        // Aqui você pode adicionar lógica de persistência no banco
        System.out.println("Saldo corrigido.");
        fecharJanela();
    }

    @FXML
    private void handleCancelar() {
        textRetirada.clear();
        atualizarExibicao();
    }

    @FXML
    private void handleSair() {
        fecharJanela();
    }

    private void fecharJanela() {
        Stage stage = (Stage) btnSair.getScene().getWindow();
        stage.close();
    }
}
