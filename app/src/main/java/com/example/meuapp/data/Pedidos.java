package com.example.meuapp.data;

public class Pedidos {
    private int dia;
    private String mes;
    private String tituloPedido;
    private String nomeCliente;
    private String nomeProfissional;

    public Pedidos(int dia, String mes, String tituloPedido, String nomeCliente, String nomeProfissional) {
        this.dia = dia;
        this.mes = mes;
        this.tituloPedido = tituloPedido;
        this.nomeCliente = nomeCliente;
        this.nomeProfissional = nomeProfissional;
    }

    public String getNomeProfissional() {
        return nomeProfissional;
    }

    public void setNomeProfissional(String nomeProfissional) {
        this.nomeProfissional = nomeProfissional;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getTituloPedido() {
        return tituloPedido;
    }

    public void setTituloPedido(String tituloPedido) {
        this.tituloPedido = tituloPedido;
    }
}