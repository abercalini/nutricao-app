package com.br.nutricaoaplicativo.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class ConsultaResponse implements Serializable {

    private Long codigo;

    private String objetivo;

    private Date dataConsulta;

    private Integer atualizacaoUsuario;

    private Integer atualizacaoDono;

    private CardapioResponse cardapio = new CardapioResponse();

    private ClienteResponse cliente = new ClienteResponse();

    public CardapioResponse getCardapio() {
        return cardapio;
    }

    public Date getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public void setCardapio(CardapioResponse cardapio) {
        this.cardapio = cardapio;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public Integer getAtualizacaoUsuario() {
        return atualizacaoUsuario;
    }

    public void setAtualizacaoUsuario(Integer atualizacaoUsuario) {
        this.atualizacaoUsuario = atualizacaoUsuario;
    }

    public Integer getAtualizacaoDono() {
        return atualizacaoDono;
    }

    public void setAtualizacaoDono(Integer atualizacaoDono) {
        this.atualizacaoDono = atualizacaoDono;
    }

    public ClienteResponse getCliente() {
        return cliente;
    }

    public void setCliente(ClienteResponse cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "ConsultaResponse{" +
                "codigo=" + codigo +
                ", objetivo='" + objetivo + '\'' +
                ", dataConsulta=" + dataConsulta +
                ", atualizacaoUsuario=" + atualizacaoUsuario +
                ", atualizacaoDono=" + atualizacaoDono +
                ", cardapio=" + cardapio +
                ", cliente=" + cliente +
                '}';
    }
}
