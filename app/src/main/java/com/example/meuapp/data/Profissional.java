package com.example.meuapp.data;

import java.util.ArrayList;

public class Profissional {
    private String Nome;
    private String telefone;
    private String cpf;
    private String ramo;
    private double rating;
    private ArrayList<Pedidos> pedidos;

    public Profissional(String nome, String telefone, String cpf, String ramo, double rating) {
        this.Nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.ramo = ramo;
        this.rating = rating;
        this.pedidos = new ArrayList<>();
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRamo() {
        return ramo;
    }

    public void setRamo(String ramo) {
        this.ramo = ramo;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public ArrayList<Pedidos> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedidos> pedidos) {
        this.pedidos = pedidos;
    }
}

