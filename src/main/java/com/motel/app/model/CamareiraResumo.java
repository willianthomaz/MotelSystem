package com.motel.app.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CamareiraResumo)) return false;
        CamareiraResumo that = (CamareiraResumo) o;
        return tipoA == that.tipoA &&
                tipoB == that.tipoB &&
                tipoC == that.tipoC &&
                tipoD == that.tipoD &&
                tipoE == that.tipoE &&
                quantidade == that.quantidade &&
                Double.compare(that.tempoMedio, tempoMedio) == 0 &&
                Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, tipoA, tipoB, tipoC, tipoD, tipoE, quantidade, tempoMedio);
    }

    @Override
    public String toString() {
        return "CamareiraResumo{" +
                "nome='" + nome + '\'' +
                ", tipoA=" + tipoA +
                ", tipoB=" + tipoB +
                ", tipoC=" + tipoC +
                ", tipoD=" + tipoD +
                ", tipoE=" + tipoE +
                ", quantidade=" + quantidade +
                ", tempoMedio=" + tempoMedio +
                '}';
    }
}
