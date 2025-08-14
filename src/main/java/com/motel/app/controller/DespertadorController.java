package com.motel.app.controller;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;

public class DespertadorController {

    @FXML
    private TextField txtSegundos;

    @FXML
    private Label lblStatus;

    private PauseTransition pause;

    @FXML
    private void iniciarAlarme() {
        if (pause != null) {
            pause.stop();
        }
        try {
            int segundos = Integer.parseInt(txtSegundos.getText());
            pause = new PauseTransition(Duration.seconds(segundos));
            pause.setOnFinished(e -> {
                lblStatus.setText("Alarme disparado!");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Alarme");
                alert.setHeaderText(null);
                alert.setContentText("O alarme disparou!");
                alert.showAndWait();
            });
            pause.play();
            lblStatus.setText("Alarme definido para " + segundos + " segundos.");
        } catch (NumberFormatException e) {
            lblStatus.setText("Informe um número válido.");
        }
    }
}
