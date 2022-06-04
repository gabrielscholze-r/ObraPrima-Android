package com.example.meuapp.data;

public class Profissional {
    private String Nome;
    private String telefone;
    private long cpf;
    private String ramo;

    public Profissional(String nome, String telefone, long cpf, String ramo) {
        Nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.ramo = ramo;
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
}
