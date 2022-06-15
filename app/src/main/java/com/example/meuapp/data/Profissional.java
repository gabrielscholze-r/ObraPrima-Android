package com.example.meuapp.data;

public class Profissional {
    private String Nome;
    private String Sobrenome;
    private String telefone;
    private long cpf;
    private String ramo;
    private double rating;

    public Profissional(String nome, String sobrenome, String telefone, long cpf, String ramo, double rating) {
        this.Nome = nome;
        this.Sobrenome = sobrenome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.ramo = ramo;
        this.rating = rating;
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

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
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

    public String getSobrenome() {
        return Sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        Sobrenome = sobrenome;
    }
}
