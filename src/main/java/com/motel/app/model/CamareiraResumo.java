package com.motel.app.model;

public class CamareiraResumo {
    private String nome;
    private int tipoA;
    private int tipoB;
    private int tipoC;
    private int tipoD;
    private int tipoE;
    private int quantidade;
    private double tempoMedio;

    public CamareiraResumo(String nome, int tipoA, int tipoB, int tipoC, int tipoD, int tipoE, int quantidade, double tempoMedio) {
        this.nome = nome;
        this.tipoA = tipoA;
        this.tipoB = tipoB;
        this.tipoC = tipoC;
        this.tipoD = tipoD;
        this.tipoE = tipoE;
        this.quantidade = quantidade;
        this.tempoMedio = tempoMedio;
    }

    public String getNome() { return nome; }
    public int getTipoA() { return tipoA; }
    public int getTipoB() { return tipoB; }
    public int getTipoC() { return tipoC; }
    public int getTipoD() { return tipoD; }
    public int getTipoE() { return tipoE; }
    public int getQuantidade() { return quantidade; }
    public double getTempoMedio() { return tempoMedio; }
}
