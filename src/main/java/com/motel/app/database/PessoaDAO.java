package com.motel.app.database;

public interface PessoaDAO {
    void inserir(String usuario, String nomeCompleto, String cargo, String senha);
    void alterar(String usuario, String nomeCompleto, String cargo, String senha);
    void excluir(String usuario);
}
