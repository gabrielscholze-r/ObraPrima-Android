package com.example.meuapp.data;

import java.util.ArrayList;
import  com.example.meuapp.data.Profissional;
public class Database {

    public static ArrayList<Profissional> profissionais = new ArrayList<>();
    public static ArrayList<Pedidos> pedidos = new ArrayList<Pedidos>();


    public static void loadDatabase(){
        Profissional encanador = new Profissional("Antônio Augusto Moraes Liberato","41988888888",1234567891,"Encanador");
        Profissional pedreiro = new Profissional("Luis Felipe Scolari","41977777777",1234567891,"Pedreiro");
        Profissional eletricista = new Profissional("Rogerio Ceni","4199999999",1234567891,"Eletricista");

        profissionais.add(encanador);
        profissionais.add(pedreiro);
        profissionais.add(eletricista);

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
}
