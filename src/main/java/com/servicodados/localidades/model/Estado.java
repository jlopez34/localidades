package com.servicodados.localidades.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(description = "Clase Estado")
public class Estado implements Serializable {

    @ApiModelProperty(notes = "campo id - Estado")
    private int id;
    @ApiModelProperty(notes = "campo sigla - Estado")
    private String sigla;
    @ApiModelProperty(notes = "campo nome - Estado")
    private String nome;
    @ApiModelProperty(notes = "campo regiao - Regiao associada ao Estado")
    private Regiao regiao;

    public Estado(){
    }

    public Estado(int id, String sigla, String nome, Regiao regiao) {
        this.id = id;
        this.sigla = sigla;
        this.nome = nome;
        this.regiao = regiao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Regiao getRegiao() {
        return regiao;
    }

    public void setRegiao(Regiao regiao) {
        this.regiao = regiao;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "id=" + id +
                ", sigla='" + sigla + '\'' +
                ", nome='" + nome + '\'' +
                ", regiao=" + regiao +
                '}';
    }
}
