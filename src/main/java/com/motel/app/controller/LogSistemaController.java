package com.motel.app.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LogSistemaController {

    @FXML
    private ComboBox<String> cboOperador;

    @FXML
    private ComboBox<String> cboOperacao;

    @FXML
    private Button btnRelatorio;

    @FXML
    private Button btnSair;

    @FXML
    private TableView<LogEntry> tableLogs;

    @FXML
    private TableColumn<LogEntry, String> colOperador;

    @FXML
    private TableColumn<LogEntry, String> colOperacao;

    @FXML
    private TableColumn<LogEntry, String> colData;

    @FXML
    public void initialize() {
        cboOperador.setItems(FXCollections.observableArrayList("Operador 1", "Operador 2", "Operador 3"));
        cboOperacao.setItems(FXCollections.observableArrayList("Login", "Cadastro", "Alteração", "Exclusão"));

        colOperador.setCellValueFactory(new PropertyValueFactory<>("operador"));
        colOperacao.setCellValueFactory(new PropertyValueFactory<>("operacao"));
        colData.setCellValueFactory(new PropertyValueFactory<>("data"));

        // Simulando alguns dados
        ObservableList<LogEntry> logs = FXCollections.observableArrayList(
                new LogEntry("Operador 1", "Login", "01/05/2025 08:00"),
                new LogEntry("Operador 2", "Cadastro", "01/05/2025 09:15")
        );

        tableLogs.setItems(logs);
    }

    @FXML
    public void handleRelatorio() {
        // Lógica de geração de relatório
        System.out.println("Gerar relatório..." );
    }

    @FXML
    public void handleSair() {
        // Lógica de encerramento da tela
        System.out.println("Fechar tela Log do Sistema...");
    }

    // Classe auxiliar para representar os dados do log
    public static class LogEntry {
        private String operador;
        private String operacao;
        private String data;

        public LogEntry(String operador, String operacao, String data) {
            this.operador = operador;
            this.operacao = operacao;
            this.data = data;
        }

        public String getOperador() {
            return operador;
        }

        public String getOperacao() {
            return operacao;
        }

        public String getData() {
            return data;
        }
    }
}
