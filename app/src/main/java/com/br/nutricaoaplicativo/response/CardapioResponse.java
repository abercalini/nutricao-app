package com.br.nutricaoaplicativo.response;

import java.io.Serializable;

public class CardapioResponse implements Serializable {

    private Long codigo;

    private String refeicao1;

    private String duranteManha;

    private String refeicao2;

    private String refeicao3;

    private String refeicao4;

    private String refeicao5;

    private String refeicao6;

    private String preTreino;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getRefeicao1() {
        return refeicao1;
    }

    public void setRefeicao1(String refeicao1) {
        this.refeicao1 = refeicao1;
    }

    public String getDuranteManha() {
        return duranteManha;
    }

    public void setDuranteManha(String duranteManha) {
        this.duranteManha = duranteManha;
    }

    public String getRefeicao2() {
        return refeicao2;
    }

    public void setRefeicao2(String refeicao2) {
        this.refeicao2 = refeicao2;
    }

    public String getRefeicao3() {
        return refeicao3;
    }

    public void setRefeicao3(String refeicao3) {
        this.refeicao3 = refeicao3;
    }

    public String getRefeicao4() {
        return refeicao4;
    }

    public void setRefeicao4(String refeicao4) {
        this.refeicao4 = refeicao4;
    }

    public String getRefeicao5() {
        return refeicao5;
    }

    public void setRefeicao5(String refeicao5) {
        this.refeicao5 = refeicao5;
    }

    public String getRefeicao6() {
        return refeicao6;
    }

    public void setRefeicao6(String refeicao6) {
        this.refeicao6 = refeicao6;
    }

    public String getPreTreino() {
        return preTreino;
    }

    public void setPreTreino(String preTreino) {
        this.preTreino = preTreino;
    }
}
