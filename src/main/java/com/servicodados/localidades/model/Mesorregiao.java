package com.servicodados.localidades.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(description = "Clase Mesorregiao")
public class Mesorregiao implements Serializable {
    @ApiModelProperty(notes = "campo id - Mesorregiao")
    private int id;
    @ApiModelProperty(notes = "campo nome - Mesorregiao")
    private String nome;
    @ApiModelProperty(notes = "campo uf - UF associado ao Mesorregiao")
    private UF uf;

    public Mesorregiao() {

    }

    public Mesorregiao(int id, String nome, com.servicodados.localidades.model.UF uf) {
        this.id = id;
        this.nome = nome;
        this.uf = uf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @JsonProperty("UF")
    public UF getUf() {
        return uf;
    }

    public void setUf(UF uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
        return "Mesorregiao{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", UF=" + uf +
                '}';
    }
}
