package com.servicodados.localidades.model;

import java.io.Serializable;

public class Municipio implements Serializable {
    private int id;
    private String nome;
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
