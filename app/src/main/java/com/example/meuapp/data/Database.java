package com.example.meuapp.data;

import java.util.ArrayList;
import  com.example.meuapp.data.Profissional;
public class Database {

    public static ArrayList<Profissional> profissionais = new ArrayList<>();
    public static ArrayList<Pedidos> pedidos = new ArrayList<>();
    public static ArrayList<Cliente> clientes = new ArrayList<>();


    public static void loadDatabase(){
        Profissional encanador = new Profissional("Antônio","Augusto Moraes Liberato","41988888888",1234567891,"Encanador",4.5);
        Profissional pedreiro = new Profissional("Luis","Felipe Scolari","41977777777",1234567891,"Pedreiro",3.0);
        Profissional eletricista = new Profissional("Rogerio","Ceni","4199999999",1234567891,"Eletricista",5.0);

        Cliente cliente1 = new Cliente("Sergio", "sergio123@gmail.com","12345678912","999999999","1234");
        Cliente cliente2 = new Cliente("Claudio", "claudio123@gmail.com","12345678912","999999999","1234");
        Cliente cliente3 = new Cliente("Roberto", "roberto123@gmail.com","12345678912","999999999","1234");

        profissionais.add(encanador);
        profissionais.add(pedreiro);
        profissionais.add(eletricista);

        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

        pedidos.add(new Pedidos("05","06","Encanamento Pia", encanador));
        pedidos.add(new Pedidos("10","06","Muro", pedreiro));
        pedidos.add(new Pedidos("20","06","Fiação Chuveiro", eletricista));

    }

    public static ArrayList<Profissional> getProfissionais() {
        return profissionais;
    }

    public static ArrayList<Pedidos> getPedidos() {
        return pedidos;
    }

    public static void setProfissionais(ArrayList<Profissional> profissionais) {
        Database.profissionais = profissionais;
    }

    public static void setPedidos(ArrayList<Pedidos> pedidos) {
        Database.pedidos = pedidos;
    }

    public static ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public static void setClientes(ArrayList<Cliente> clientes) {
        Database.clientes = clientes;
    }
}
