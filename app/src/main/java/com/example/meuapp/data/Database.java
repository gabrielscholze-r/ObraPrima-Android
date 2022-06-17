package com.example.meuapp.data;

import android.util.Log;

import java.util.ArrayList;

import com.example.meuapp.data.Profissional;

public class Database {

    public static ArrayList<Profissional> profissionais = new ArrayList<>();
    public static ArrayList<Cliente> clientes = new ArrayList<>();
    public static LoginAtual loginAtual = new LoginAtual();


    public static void loadDatabase() {
        Profissional encanador = new Profissional("Antonio", "41988888888", "1234567891", "Encanador", 4.5);
        Profissional pedreiro = new Profissional("Luis", "41977777777", "1234567891", "Pedreiro", 3.0);
        Profissional eletricista = new Profissional("Rogerio", "4199999999", "1234567891", "Eletricista", 5.0);

        Profissional encanador2 = new Profissional("Antonio2", "41988888888", "1234567891", "Encanador", 4.5);
        Profissional pedreiro2 = new Profissional("Luis2", "41977777777", "1234567891", "Pedreiro", 3.0);
        Profissional eletricista2 = new Profissional("Rogerio2", "4199999999", "1234567891", "Eletricista", 5.0);
        Profissional encanador3 = new Profissional("Antonio3", "41988888888", "1234567891", "Encanador", 4.5);
        Profissional pedreiro3 = new Profissional("Luis3", "41977777777", "1234567891", "Pedreiro", 3.0);
        Profissional eletricista3 = new Profissional("Rogerio3", "4199999999", "1234567891", "Eletricista", 5.0);
        Cliente cliente1 = new Cliente("Sergio", "sergio123@gmail.com", "12345678912", "999999999", "1234");
        Cliente cliente2 = new Cliente("Claudio", "claudio123@gmail.com", "12345678912", "999999999", "1234");
        Cliente cliente3 = new Cliente("Roberto", "roberto123@gmail.com", "12345678912", "999999999", "1234");

        profissionais.add(encanador);
        profissionais.add(pedreiro);
        profissionais.add(eletricista);
        profissionais.add(encanador2);
        profissionais.add(pedreiro2);
        profissionais.add(eletricista2);
        profissionais.add(encanador3);
        profissionais.add(pedreiro3);
        profissionais.add(eletricista3);
        profissionais.add(encanador3);
        profissionais.add(pedreiro3);
        profissionais.add(eletricista3);


        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

        ArrayList<Pedidos> pedidosEncanador = encanador.getPedidos();

        pedidosEncanador.add(new Pedidos(10, "06", "Visita tecnica", "Sergio", "Antonio"));
        pedidosEncanador.add(new Pedidos(20, "06", "Visita tecnica", "Claudio", "Antonio"));
        pedidosEncanador.add(new Pedidos(10, "07", "Visita tecnica", "Roberto", "Antonio"));
        pedidosEncanador.add(new Pedidos(20, "07", "Visita tecnica", "Sergio", "Antonio"));

        encanador.setPedidos(pedidosEncanador);

        ArrayList<Pedidos> pedidosPedreiro = pedreiro.getPedidos();

        pedidosPedreiro.add(new Pedidos(10, "06", "Visita tecnica", "Sergio","Luis"));
        pedidosPedreiro.add(new Pedidos(20, "06", "Visita tecnica", "Claudio","Luis"));
        pedidosPedreiro.add(new Pedidos(10, "07", "Visita tecnica", "Roberto","Luis"));
        pedidosPedreiro.add(new Pedidos(20, "07", "Visita tecnica", "Sergio","Luis"));

        pedreiro.setPedidos(pedidosPedreiro);

        ArrayList<Pedidos> pedidosEletricista = eletricista.getPedidos();

        pedidosEletricista.add(new Pedidos(10, "06", "Visita tecnica", "Roberto","Rogerio"));
        pedidosEletricista.add(new Pedidos(20, "06", "Visita tecnica", "Sergio","Rogerio"));
        pedidosEletricista.add(new Pedidos(10, "07", "Visita tecnica", "Claudio","Rogerio"));
        pedidosEletricista.add(new Pedidos(20, "07", "Visita tecnica", "Sergio","Rogerio"));

        eletricista.setPedidos(pedidosEletricista);
    }

    public static ArrayList<Profissional> getProfissionais() {
        return profissionais;
    }

    public static void setProfissionais(ArrayList<Profissional> profissionais) {
        Database.profissionais = profissionais;
    }

    public static ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public static void setClientes(ArrayList<Cliente> clientes) {
        Database.clientes = clientes;
    }

    public static LoginAtual getLoginAtual() {
        return loginAtual;
    }

    public static void setLoginAtual(LoginAtual loginAtual) {
        Database.loginAtual = loginAtual;
    }
}
