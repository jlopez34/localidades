package com.servicodados.localidades.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;


@ApiModel(description = "Clase UF")
public class UF implements Serializable {
    @ApiModelProperty(notes = "campo id - UF")
    private int id;
    @ApiModelProperty(notes = "campo sigla - UF")
    private String sigla;
    @ApiModelProperty(notes = "campo nome - UF")
    private String nome;
    @ApiModelProperty(notes = "campo regiao - Regiao associado ao UF")
    private Regiao regiao;

    public UF() {

    }

    public UF(int id, String sigla, String nome, Regiao regiao) {
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
        return "UF{" +
                "id=" + id +
                ", sigla='" + sigla + '\'' +
                ", nome='" + nome + '\'' +
                ", regiao=" + regiao +
                '}';
    }
}
