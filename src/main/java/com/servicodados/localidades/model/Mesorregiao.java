package com.servicodados.localidades.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Mesorregiao implements Serializable {
    private int id;
    private String nome;
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
