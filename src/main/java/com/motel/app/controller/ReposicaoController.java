package com.motel.app.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ReposicaoController {

    @FXML
    private TextField txtProduto;

    @FXML
    private TextField txtQuantidade;

    @FXML
    private TableView<ReposicaoItem> tabelaItens;

    @FXML
    private TableColumn<ReposicaoItem, String> colProduto;

    @FXML
    private TableColumn<ReposicaoItem, Integer> colQuantidade;

    private final ObservableList<ReposicaoItem> itens = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        colProduto.setCellValueFactory(new PropertyValueFactory<>("produto"));
        colQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        tabelaItens.setItems(itens);
    }

    @FXML
    private void adicionarItem() {
        String produto = txtProduto.getText();
        int quantidade;
        try {
            quantidade = Integer.parseInt(txtQuantidade.getText());
        } catch (NumberFormatException e) {
            return;
        }
        if (produto == null || produto.isBlank()) {
            return;
        }
        itens.add(new ReposicaoItem(produto, quantidade));
        txtProduto.clear();
        txtQuantidade.clear();
    }

    public static class ReposicaoItem {
        private final SimpleStringProperty produto;
        private final SimpleIntegerProperty quantidade;

        public ReposicaoItem(String produto, int quantidade) {
            this.produto = new SimpleStringProperty(produto);
            this.quantidade = new SimpleIntegerProperty(quantidade);
        }

        public String getProduto() {
            return produto.get();
        }

        public Integer getQuantidade() {
            return quantidade.get();
        }
    }
}

