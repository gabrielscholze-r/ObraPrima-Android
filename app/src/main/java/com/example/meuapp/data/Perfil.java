package com.example.meuapp.data;

public class Perfil {
    
    private static Profissional profissional;
    private static Pedidos pedido;
    public Perfil() {
    }

    public static Profissional getProfissional() {
        return profissional;
    }

    public static void setProfissional(Profissional profissional) {
        Perfil.profissional = profissional;
    }

    public static Pedidos getPedido() {
        return pedido;
    }

    public static void setPedido(Pedidos pedido) {
        Perfil.pedido = pedido;
    }
}
