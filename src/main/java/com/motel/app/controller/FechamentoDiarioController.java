package com.motel.app.controller;

import com.motel.app.model.CamareiraResumo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.control.cell.PropertyValueFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class FechamentoDiarioController implements Initializable {

    private static final Logger logger = LoggerFactory.getLogger(FechamentoDiarioController.class);

    @FXML private Label labelSaldoInicial;
    @FXML private Label labelTotalEstadias;
    @FXML private Label labelTotalPedidos;
    @FXML private Label labelRetiradas;
    @FXML private Label labelSaldoAtual;

    @FXML private TableView<CamareiraResumo> tabelaCamareiras;
    @FXML private TableColumn<CamareiraResumo, String> colCamareira;
    @FXML private TableColumn<CamareiraResumo, Integer> colA;
    @FXML private TableColumn<CamareiraResumo, Integer> colB;
    @FXML private TableColumn<CamareiraResumo, Integer> colC;
    @FXML private TableColumn<CamareiraResumo, Integer> colD;
    @FXML private TableColumn<CamareiraResumo, Integer> colE;
    @FXML private TableColumn<CamareiraResumo, Integer> colQtd;
    @FXML private TableColumn<CamareiraResumo, Double> colTpMed;

    @FXML private RadioButton radioMovimentoSim;
    @FXML private RadioButton radioMovimentoNao;
    @FXML private RadioButton radioFecharSim;
    @FXML private RadioButton radioFecharNao;

    private ToggleGroup grupoMovimento;
    private ToggleGroup grupoFechar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        grupoMovimento = new ToggleGroup();
        radioMovimentoSim.setToggleGroup(grupoMovimento);
        radioMovimentoNao.setToggleGroup(grupoMovimento);

        grupoFechar = new ToggleGroup();
        radioFecharSim.setToggleGroup(grupoFechar);
        radioFecharNao.setToggleGroup(grupoFechar);

        configurarTabela();
        carregarDadosMock();
    }

    private void configurarTabela() {
        colCamareira.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colA.setCellValueFactory(new PropertyValueFactory<>("tipoA"));
        colB.setCellValueFactory(new PropertyValueFactory<>("tipoB"));
        colC.setCellValueFactory(new PropertyValueFactory<>("tipoC"));
        colD.setCellValueFactory(new PropertyValueFactory<>("tipoD"));
        colE.setCellValueFactory(new PropertyValueFactory<>("tipoE"));
        colQtd.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        colTpMed.setCellValueFactory(new PropertyValueFactory<>("tempoMedio"));
    }

    private void carregarDadosMock() {
        ObservableList<CamareiraResumo> dados = FXCollections.observableArrayList(
                new CamareiraResumo("Ana", 1, 2, 1, 0, 1, 5, 12.5),
                new CamareiraResumo("Bruna", 0, 1, 2, 1, 0, 4, 15.2),
                new CamareiraResumo("Clara", 2, 0, 0, 2, 1, 5, 10.8)
        );
        tabelaCamareiras.setItems(dados);
    }

    @FXML
    private void handleSair() {
        Stage stage = (Stage) labelSaldoInicial.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void handleOk() {
        boolean listarMovimento = radioMovimentoSim.isSelected();
        boolean fecharPeriodo = radioFecharSim.isSelected();
        logger.debug("Listar Movimento: {}", listarMovimento);
        logger.debug("Fechar Período: {}", fecharPeriodo);
    }
}
