package com.servicodados.localidades.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(description = "Clase Municipio")
public class Municipio implements Serializable {
    @ApiModelProperty(notes = "campo id - Municipio")
    private int id;
    @ApiModelProperty(notes = "campo nome - Municipio")
    private String nome;
    @ApiModelProperty(notes = "campo microrregiao - Microrregiao associado ao Municipio")
    private Microrregiao microrregiao;

    public Municipio() {
    }

    public Municipio(int id, String nome, Microrregiao microrregiao) {
        this.id = id;
        this.nome = nome;
        this.microrregiao = microrregiao;
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

    public Microrregiao getMicrorregiao() {
        return microrregiao;
    }

    public void setMicrorregiao(Microrregiao microrregiao) {
        this.microrregiao = microrregiao;
    }

    @Override
    public String toString() {
        return "Municipio{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", microrregiao=" + microrregiao +
                '}';
    }
}
