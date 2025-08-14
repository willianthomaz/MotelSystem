package com.motel.app.controller;

import com.motel.app.database.PessoaDAO;
import com.motel.app.database.PessoaDAOImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    private final PessoaDAO pessoaDAO = new PessoaDAOImpl();

    private static final Logger logger = LoggerFactory.getLogger(CadastroPessoasController.class);

    @FXML
    private void onSairClick() {
        // lógica para fechar a tela
        logger.info("Saindo...");
    }

    @FXML
    private void onCancelarClick() {
        limparCampos();
    }

    @FXML
    private void onExcluirClick() {
        pessoaDAO.excluir(txtUsuario.getText());
        limparCampos();
    }

    @FXML
    private void onAlterarClick() {
        pessoaDAO.alterar(txtUsuario.getText(), txtNomeCompleto.getText(), txtCargo.getText(), txtSenha.getText());
        limparCampos();
    }

    @FXML
    private void onIncluirClick() {
        pessoaDAO.inserir(txtUsuario.getText(), txtNomeCompleto.getText(), txtCargo.getText(), txtSenha.getText());
        limparCampos();
    }

    private void limparCampos() {
        txtUsuario.clear();
        txtNomeCompleto.clear();
        txtCargo.clear();
        txtSenha.clear();
    }
}
