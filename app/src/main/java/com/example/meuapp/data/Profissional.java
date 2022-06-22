package com.example.meuapp.data;

import java.util.ArrayList;

public class Profissional {
    private String Nome;
    private String telefone;
    private String cpf;
    private String ramo;
    private String email;
    private String senha;
    private double rating;
    private String bio;
    private ArrayList<Pedidos> pedidos;
    private ArrayList<Pedidos> historico;
    private int TipoPedido;
    private double price;

    public Profissional(String nome, String telefone, String cpf, String ramo, double rating,String email,String senha, String bio, double price) {
        this.Nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.ramo = ramo;
        this.rating = rating;
        this.pedidos = new ArrayList<>();
        this.historico = new ArrayList<>();
        this.email = email;
        this.senha = senha;
        this.bio = bio;
        this.TipoPedido = 0;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTipoPedido() {
        return TipoPedido;
    }

    public void setTipoPedido(int tipoPedido) {
        TipoPedido = tipoPedido;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public ArrayList<Pedidos> getHistorico() {
        return historico;
    }

    public void setHistorico(ArrayList<Pedidos> historico) {
        this.historico = historico;
    }
}

