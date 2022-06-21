package com.example.meuapp.data;

public class Pedidos {
    private int dia;
    private String mes;
    private String tituloPedido;
    private String nomeCliente;
    private String nomeProfissional;
    private String tipoServiço;
    private String descricao;
    private double rating;

    public Pedidos(int dia, String mes, String tituloPedido, String tipoServico,String nomeCliente, String nomeProfissional, String descricao) {
        this.dia = dia;
        this.mes = mes;
        this.tipoServiço = tipoServico;
        this.nomeCliente = nomeCliente;
        this.nomeProfissional = nomeProfissional;
        this.descricao = descricao;
        this.tituloPedido = tituloPedido;
        this.rating = -1;
    }

    public String getTipoServiço() {
        return tipoServiço;
    }

    public void setTipoServiço(String tipoServiço) {
        this.tipoServiço = tipoServiço;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}