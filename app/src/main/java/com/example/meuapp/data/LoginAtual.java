package com.example.meuapp.data;

public class LoginAtual {
    private static Cliente cliente;
    private static Profissional profissional;

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
