package com.servicodados.localidades.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(description = "Clase Regiao")
public class Regiao implements Serializable {
    @ApiModelProperty(notes = "campo id - Regiao")
    private int id;
    @ApiModelProperty(notes = "campo sigla - Regiao")
    private String sigla;
    @ApiModelProperty(notes = "campo nome - Regiao")
    private String nome;

    private Regiao(){
    }

    public Regiao(int id, String sigla, String nome) {
        this.id = id;
        this.sigla = sigla;
        this.nome = nome;
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

    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", sigla='" + sigla + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
