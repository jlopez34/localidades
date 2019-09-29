package com.servicodados.localidades.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(description = "Clase Microrregiao")
public class Microrregiao implements Serializable {
    @ApiModelProperty(notes = "campo id - Microrregiao")
    private int id;
    @ApiModelProperty(notes = "campo id - Microrregiao")
    private String nome;
    @ApiModelProperty(notes = "campo id - Mesorregiao associado ao Microrregiao")
    private Mesorregiao mesorregiao;

    public Microrregiao() {

    }

    public Microrregiao(int id, String nome, Mesorregiao mesorregiao) {
        this.id = id;
        this.nome = nome;
        this.mesorregiao = mesorregiao;
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

    public Mesorregiao getMesorregiao() {
        return mesorregiao;
    }

    public void setMesorregiao(Mesorregiao mesorregiao) {
        this.mesorregiao = mesorregiao;
    }

    @Override
    public String toString() {
        return "Microrregiao{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", mesorregiao=" + mesorregiao +
                '}';
    }
}
