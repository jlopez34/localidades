package com.servicodados.localidades.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Clase Localidade resultado da busqueda de municipios, estados e cidades")
public class Localidade {
    @ApiModelProperty(notes = "campo idEstado - Localidade")
    private int idEstado;
    @ApiModelProperty(notes = "campo siglaEstado - Localidade")
    private String siglaEstado;
    @ApiModelProperty(notes = "campo regiaoNome - Localidade")
    private String regiaoNome;
    @ApiModelProperty(notes = "campo nomeCidade - Localidade")
    private String nomeCidade;
    @ApiModelProperty(notes = "campo nomeMesorregiao - Localidade")
    private String nomeMesorregiao;
    @ApiModelProperty(notes = "campo nomeFormatado - Localidade {cidade / UF}")
    private String nomeFormatado;

    public Localidade(){

    }

    public Localidade(int idEstado, String siglaEstado, String regiaoNome, String nomeCidade, String nomeMesorregiao, String nomeFormatado) {
        this.idEstado = idEstado;
        this.siglaEstado = siglaEstado;
        this.regiaoNome = regiaoNome;
        this.nomeCidade = nomeCidade;
        this.nomeMesorregiao = nomeMesorregiao;
        this.nomeFormatado = nomeFormatado;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getSiglaEstado() {
        return siglaEstado;
    }

    public void setSiglaEstado(String siglaEstado) {
        this.siglaEstado = siglaEstado;
    }

    public String getRegiaoNome() {
        return regiaoNome;
    }

    public void setRegiaoNome(String regiaoNome) {
        this.regiaoNome = regiaoNome;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public String getNomeMesorregiao() {
        return nomeMesorregiao;
    }

    public void setNomeMesorregiao(String nomeMesorregiao) {
        this.nomeMesorregiao = nomeMesorregiao;
    }

    public String getNomeFormatado() {
        return nomeFormatado;
    }

    public void setNomeFormatado(String nomeFormatado) {
        this.nomeFormatado = nomeFormatado;
    }

    @Override
    public String toString() {
        return "Localidade{" +
                "idEstado=" + idEstado +
                ", siglaEstado='" + siglaEstado + '\'' +
                ", regiaoNome='" + regiaoNome + '\'' +
                ", nomeCidade='" + nomeCidade + '\'' +
                ", nomeMesorregiao='" + nomeMesorregiao + '\'' +
                ", nomeFormatado='" + nomeFormatado + '\'' +
                '}';
    }
}
