package com.servicodados.localidades.model;

import java.io.Serializable;

public class Microrregiao implements Serializable {
    private int id;
    private String nome;
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
