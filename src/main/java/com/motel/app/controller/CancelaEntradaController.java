package com.motel.app.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import org.kordamp.ikonli.javafx.FontIcon;

public class CancelaEntradaController {

    @FXML private ComboBox<String> cboApto;
    @FXML private Button btnOk, btnCancela, btnSair;

    @FXML
    public void initialize() {
        Platform.runLater(() -> btnOk.requestFocus());
    }

    @FXML private void onOkClick() {
        System.out.println("OK clicado");
    }

    @FXML private void onCancelaClick() {
        System.out.println("Cancelado");
    }

    @FXML private void onSairClick() {
        System.exit(0);
    }

    // Hover escuro com contraste
    @FXML private void hoverOnOk()       { btnOk.setStyle("-fx-background-color: #218838; -fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold; -fx-background-radius: 10;"); }
    @FXML private void hoverOffOk()      { btnOk.setStyle("-fx-background-color: #28a745; -fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold; -fx-background-radius: 10;"); }

    @FXML private void hoverOnCancela()  { btnCancela.setStyle("-fx-background-color: #c82333; -fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold; -fx-background-radius: 10;"); }
    @FXML private void hoverOffCancela() { btnCancela.setStyle("-fx-background-color: #dc3545; -fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold; -fx-background-radius: 10;"); }

    @FXML private void hoverOnSair()     { btnSair.setStyle("-fx-background-color: #495057; -fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold; -fx-background-radius: 10;"); }
    @FXML private void hoverOffSair()    { btnSair.setStyle("-fx-background-color: #6c757d; -fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold; -fx-background-radius: 10;"); }
}
