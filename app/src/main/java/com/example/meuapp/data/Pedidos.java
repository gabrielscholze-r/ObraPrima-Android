package com.example.meuapp.data;

public class Pedidos {
    private String dia;
    private String mes;
    private String tituloPedido;

    public Pedidos(String dia, String mes, String tituloPedido) {
        this.dia = dia;
        this.mes = mes;
        this.tituloPedido = tituloPedido;

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
