package com.example.meuapp.data;

public class LoginAtual {
    public static Cliente cliente;
    public static Profissional profissional;

    public LoginAtual() {
        this.cliente = null;
        this.profissional = null;
    }

    public static Cliente getCliente() {
        return cliente;
    }

    public static void setCliente(Cliente cliente) {
        LoginAtual.cliente = cliente;
    }

    public static Profissional getProfissional() {
        return profissional;
    }

    public static void setProfissional(Profissional profissional) {
        LoginAtual.profissional = profissional;
    }
}
