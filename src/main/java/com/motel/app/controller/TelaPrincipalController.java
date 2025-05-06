package com.motel.app.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TelaPrincipalController {

    private void abrirTela(String caminhoFXML) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(caminhoFXML));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML public void abrirTelaEntrada(ActionEvent event) { abrirTela("/com/motel/app/entrada.fxml"); }
    @FXML public void abrirTelaPedidos(ActionEvent event) { abrirTela("/com/motel/app/pedidos.fxml"); }
    @FXML public void abrirTelaSaida(ActionEvent event) { abrirTela("/com/motel/app/saida.fxml"); }
    @FXML public void abrirTelaLiberar(ActionEvent event) { abrirTela("/com/motel/app/liberar.fxml"); }
    @FXML public void abrirTelaFazerLimpeza(ActionEvent event) { abrirTela("/com/motel/app/fazer_limpeza.fxml"); }
    @FXML public void abrirTelaManutencao(ActionEvent event) { abrirTela("/com/motel/app/manutencao.fxml"); }
    @FXML public void abrirTelaPgtoAntecipado(ActionEvent event) { abrirTela("/com/motel/app/pgto_antecipado.fxml"); }

    @FXML public void abrirTelaCancelaEntrada(ActionEvent event) { abrirTela("/com/motel/app/cancela_entrada.fxml"); }
    @FXML public void abrirTelaCancelaSaida(ActionEvent event) { abrirTela("/com/motel/app/cancela_saida.fxml"); }
    @FXML public void abrirTelaReposicao(ActionEvent event) { abrirTela("/com/motel/app/reposicao.fxml"); }
    @FXML public void abrirTelaFechaTurno(ActionEvent event) { abrirTela("/com/motel/app/fecha_turno.fxml"); }
    @FXML public void abrirTelaDespertador(ActionEvent event) { abrirTela("/com/motel/app/despertador.fxml"); }
    @FXML public void abrirTelaOrganizaArquivos(ActionEvent event) { abrirTela("/com/motel/app/organiza_arquivos.fxml"); }

    @FXML public void abrirTelaProdutosBar(ActionEvent event) { abrirTela("/com/motel/app/produtos_bar.fxml"); }
    @FXML public void abrirTelaTipoApto(ActionEvent event) { abrirTela("/com/motel/app/tipo_apto.fxml"); }
    @FXML public void abrirTelaTabelaPrecos(ActionEvent event) { abrirTela("/com/motel/app/tabela_precos.fxml"); }
    @FXML public void abrirTelaCorrecaoCaixa(ActionEvent event) { abrirTela("/com/motel/app/correcao_saldo.fxml"); }
    @FXML public void abrirTelaCaixaDia(ActionEvent event) { abrirTela("/com/motel/app/caixa_dia.fxml"); }
    @FXML public void abrirTelaFechaDia(ActionEvent event) { abrirTela("/com/motel/app/fecha_dia.fxml"); }

    @FXML public void abrirTelaCadastroPessoas(ActionEvent event) { abrirTela("/com/motel/app/cadastro_pessoas.fxml"); }
    @FXML public void abrirTelaSituacao(ActionEvent event) { abrirTela("/com/motel/app/situacao.fxml"); }
    @FXML public void abrirTelaCaixaTurno(ActionEvent event) { abrirTela("/com/motel/app/caixa_turno.fxml"); }
    @FXML public void abrirTelaOperador(ActionEvent event) { abrirTela("/com/motel/app/operador.fxml"); }
    @FXML public void abrirTelaLogSistema(ActionEvent event) { abrirTela("/com/motel/app/log_sistema.fxml"); }

    @FXML public void sairAplicacao(ActionEvent event) {
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}
