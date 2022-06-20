package com.example.meuapp.data;

import android.util.Log;

import java.util.ArrayList;

import com.example.meuapp.data.Profissional;

public class Database {

    public static ArrayList<Profissional> profissionais = new ArrayList<>();
    public static ArrayList<Cliente> clientes = new ArrayList<>();
    public static LoginAtual loginAtual = new LoginAtual();


    public static void loadDatabase() {
        Profissional encanador = new Profissional("Antonio", "41988888888", "1234567891", "Encanamento", 4.5, "antonio@gmail.com","1234","Antonio Encanador");
        Profissional pedreiro = new Profissional("Luis", "41977777777", "1234567891", "Construção", 3.0,"luis@gmail.com","1234","Luis Encanador");
        Profissional eletricista = new Profissional("Rogerio", "4199999999", "1234567891", "Eletricidade", 5.0,"rogerio@gmail.com","1234","Rogerio Encanador");

        Cliente cliente1 = new Cliente("Sergio", "sergio123@gmail.com", "12345678912", "999999999", "1234");
        Cliente cliente2 = new Cliente("Claudio", "claudio123@gmail.com", "12345678912", "999999999", "1234");
        Cliente cliente3 = new Cliente("Roberto", "roberto123@gmail.com", "12345678912", "999999999", "1234");

        profissionais.add(encanador);
        profissionais.add(pedreiro);
        profissionais.add(eletricista);


        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

        ArrayList<Pedidos> pedidosEncanador = encanador.getPedidos();

        pedidosEncanador.add(new Pedidos(10, "06", "Visita tecnica","Encanamento", "Sergio", "Antonio", "Visita técnica para encontrar fonte de um vazamento na casa!"));
        pedidosEncanador.add(new Pedidos(20, "06", "Visita tecnica","Encanamento", "Claudio", "Antonio", "Visita técnica para encontrar fonte de um vazamento na casa!"));
        pedidosEncanador.add(new Pedidos(10, "07", "Visita tecnica","Encanamento", "Roberto", "Antonio", "Visita técnica para encontrar fonte de um vazamento na casa!"));
        pedidosEncanador.add(new Pedidos(20, "07", "Visita tecnica","Encanamento", "Sergio", "Antonio", "Visita técnica para encontrar fonte de um vazamento na casa!"));

        encanador.setPedidos(pedidosEncanador);

        ArrayList<Pedidos> pedidosPedreiro = pedreiro.getPedidos();

        pedidosPedreiro.add(new Pedidos(10, "06", "Visita tecnica","Construção", "Sergio","Luis","Contrução de parede"));
        pedidosPedreiro.add(new Pedidos(20, "06", "Visita tecnica","Construção", "Claudio","Luis","Construção de muro em volta da casa"));
        pedidosPedreiro.add(new Pedidos(10, "07", "Visita tecnica","Construção", "Roberto","Luis","Contrução de casinha de bonecas em tamanho real"));
        pedidosPedreiro.add(new Pedidos(20, "07", "Visita tecnica","Construção", "Sergio","Luis", "Construção de muro"));

        pedreiro.setPedidos(pedidosPedreiro);

        ArrayList<Pedidos> pedidosEletricista = eletricista.getPedidos();

        pedidosEletricista.add(new Pedidos(10, "06", "Visita tecnica","Eletricidade", "Roberto","Rogerio","Conserto de fiação da casa"));
        pedidosEletricista.add(new Pedidos(20, "06", "Visita tecnica","Eletricidade", "Sergio","Rogerio","Conserto de tomadas da casa"));
        pedidosEletricista.add(new Pedidos(10, "07", "Visita tecnica","Eletricidade", "Claudio","Rogerio", "Instalação de chuveiro elétrico"));
        pedidosEletricista.add(new Pedidos(20, "07", "Visita tecnica","Eletricidade", "Sergio","Rogerio", "Instalaçào de fiação de apartamento"));

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

    public static Profissional findProfissionalByName(String name){
        for(Profissional p : profissionais){
            if(p.getNome().equals(name)){
                return p;
            }
        }
        return null;
    }

    public static void removeProfissionalByName(String name){
        for (Profissional p : profissionais){
            if(p.getNome().equals(name)){
                profissionais.remove(p);
            }
        }
    }
}
