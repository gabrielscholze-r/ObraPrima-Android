package com.example.meuapp.data;

public class Pedidos {
    private String dia;
    private String mes;
    private String tituloPedido;
    private String nomeCliente;

    public Pedidos(String dia, String mes, String tituloPedido, String nomeCliente) {
        this.dia = dia;
        this.mes = mes;
        this.tituloPedido = tituloPedido;
        this.nomeCliente = nomeCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
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