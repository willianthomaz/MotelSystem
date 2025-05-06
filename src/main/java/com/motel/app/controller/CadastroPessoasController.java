package com.motel.app.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class CadastroPessoasController {

    @FXML
    private TextField txtUsuario;

    @FXML
    private TextField txtNomeCompleto;

    @FXML
    private TextField txtCargo;

    @FXML
    private PasswordField txtSenha;

    @FXML
    private Button btnSair;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnExcluir;

    @FXML
    private Button btnAlterar;

    @FXML
    private Button btnIncluir;

    @FXML
    private void onSairClick() {
        // lógica para fechar a tela
        System.out.println("Saindo...");
    }

    @FXML
    private void onCancelarClick() {
        limparCampos();
    }

    @FXML
    private void onExcluirClick() {
        // lógica para excluir funcionário
        System.out.println("Excluindo funcionário...");
    }

    @FXML
    private void onAlterarClick() {
        // lógica para alterar dados do funcionário
        System.out.println("Alterando funcionário...");
    }

    @FXML
    private void onIncluirClick() {
        // lógica para incluir novo funcionário
        System.out.println("Incluindo novo funcionário...");
    }

    private void limparCampos() {
        txtUsuario.clear();
        txtNomeCompleto.clear();
        txtCargo.clear();
        txtSenha.clear();
    }
}
