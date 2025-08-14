package com.motel.app.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import org.kordamp.ikonli.javafx.FontIcon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CancelaEntradaController {

    @FXML private ComboBox<String> cboApto;
    @FXML private Button btnOk, btnCancela, btnSair;

    private static final Logger logger = LoggerFactory.getLogger(CancelaEntradaController.class);

    @FXML
    public void initialize() {
        Platform.runLater(() -> btnOk.requestFocus());
    }

    @FXML private void onOkClick() {
        logger.debug("OK clicado");
    }

    @FXML private void onCancelaClick() {
        logger.debug("Cancelado");
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
