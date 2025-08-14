package com.motel.app.controller;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class DespertadorController {

    @FXML
    private TextField txtNumeroQuarto;

    @FXML
    private TextField txtHorario;

    @FXML
    private Label lblStatus;

    private PauseTransition pause;

    @FXML
    private void iniciarAlarme() {
        if (pause != null) {
            pause.stop();
        }
        try {
            String numeroQuarto = txtNumeroQuarto.getText();
            LocalTime horario = LocalTime.parse(txtHorario.getText());
            long delay = java.time.Duration.between(LocalTime.now(), horario).getSeconds();
            if (delay < 0) {
                delay += 24 * 60 * 60;
            }
            pause = new PauseTransition(Duration.seconds(delay));
            pause.setOnFinished(e -> {
                lblStatus.setText("Alarme disparado para o quarto " + numeroQuarto + "!");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Alarme");
                alert.setHeaderText(null);
                alert.setContentText("Alarme para o quarto " + numeroQuarto + " às " + horario + "!");
                alert.showAndWait();
            });
            pause.play();
            lblStatus.setText("Alarme do quarto " + numeroQuarto + " definido para " + horario + ".");
        } catch (DateTimeParseException e) {
            lblStatus.setText("Informe um horário válido (HH:mm).");
        }
    }
}
