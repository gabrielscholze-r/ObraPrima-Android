package com.example.meuapp.data;

public class Perfil {
    
    private static Profissional profissional;
    private static Pedidos pedido;
    private static int id;
    public Perfil() {
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Perfil.id = id;
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
