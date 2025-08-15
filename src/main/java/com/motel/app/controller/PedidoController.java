package com.motel.app.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class PedidoController {

    @FXML private ComboBox<String> cboApto;
    @FXML private ComboBox<String> cboCod;
    @FXML private TextField txtPreco;
    @FXML private TextField txtQtd;
    @FXML private TextField txtValorTotalCasa;

    @FXML private ListView<String> lstPedidos;
    @FXML private ListView<String> lstPAnterior;

    @FXML private RadioButton optTicketSim;
    @FXML private RadioButton optTicketNao;
    @FXML private ToggleGroup grpTicket;

    @FXML private Button btnSair;
    @FXML private Button btnCancela;
    @FXML private Button btnOk;

    private final ObservableList<String> pedidos = FXCollections.observableArrayList();
    private final ObservableList<String> pedidosAnteriores = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Inicializa ComboBoxes
        cboApto.setItems(FXCollections.observableArrayList("01", "02", "03", "04"));
        cboCod.setItems(FXCollections.observableArrayList("101 - Cerveja", "102 - Refrigerante", "103 - Água", "104 - Champanhe"));

        // Inicializa listas
        lstPedidos.setItems(pedidos);
        lstPAnterior.setItems(pedidosAnteriores);

        // Inicializa grupo de toggle
        grpTicket = new ToggleGroup();
        optTicketSim.setToggleGroup(grpTicket);
        optTicketNao.setToggleGroup(grpTicket);
        optTicketNao.setSelected(true);  // Valor padrão
    }

    @FXML
    public void onBtnOkClick(ActionEvent event) {
        String produto = cboCod.getValue();
        String qtd = txtQtd.getText();
        String preco = txtPreco.getText();

        if (produto != null && !qtd.isEmpty() && !preco.isEmpty()) {
            String pedido = String.format("%-5s%-30s%-8s%-10s", produto.substring(0, 3), produto.substring(6), qtd, preco);
            pedidos.add(pedido);
            calcularTotal();
            txtQtd.clear();
            txtPreco.clear();
        } else {
            showAlert("Preencha todos os campos para adicionar o pedido.");
        }
    }

    @FXML
    public void onBtnCancelaClick(ActionEvent event) {
        txtQtd.clear();
        txtPreco.clear();
        cboCod.getSelectionModel().clearSelection();
    }

    @FXML
    public void onBtnSairClick(ActionEvent event) {
        // Código para fechar a tela, dependendo de como está estruturada sua aplicação
        System.exit(0);
    }

    private void calcularTotal() {
        double total = 0.0;
        for (String item : pedidos) {
            try {
                String[] partes = item.trim().split("\\s+");
                int qtd = Integer.parseInt(partes[partes.length - 2]);
                double preco = Double.parseDouble(partes[partes.length - 1].replace(",", "."));
                total += qtd * preco;
            } catch (Exception e) {
                // Ignora erros de parse
            }
        }
        txtValorTotalCasa.setText(String.format("%.2f", total));
    }

    private void showAlert(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Atenção");
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
