package com.example.meuapp.data;

public class Pedidos {
    private int dia;
    private int mes;
    private String tituloPedido;
    private String emailCliente;
    private String nomeCliente;
    private String nomeProfissional;
    private String tipoServiço;
    private String descricao;
    private double rating;
    private int TipoPedido;
    private double price;
    private String emailProfissional;

    public Pedidos(int dia, int mes, String tituloPedido, String tipoServico,String nomeCliente, String nomeProfissional, String descricao, int TipoPedido, double price, String emailCliente,String emailProfissional) {
        this.dia = dia;
        this.mes = mes;
        this.tipoServiço = tipoServico;
        this.nomeCliente = nomeCliente;
        this.nomeProfissional = nomeProfissional;
        this.descricao = descricao;
        this.tituloPedido = tituloPedido;
        this.rating = -1;
        this.TipoPedido = TipoPedido;
        this.price = price;
        this.emailCliente = emailCliente;
        this.emailProfissional = emailProfissional;
    }

    public String getEmailProfissional() {
        return emailProfissional;
    }

    public void setEmailProfissional(String emailProfissional) {
        this.emailProfissional = emailProfissional;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
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

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
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