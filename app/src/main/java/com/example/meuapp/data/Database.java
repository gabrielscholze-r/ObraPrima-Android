package com.example.meuapp.data;

import android.util.Log;

import java.util.ArrayList;

import com.example.meuapp.data.Profissional;

public class Database {

    public static ArrayList<Profissional> profissionais = new ArrayList<>();
    public static ArrayList<Cliente> clientes = new ArrayList<>();


    public static void loadDatabase() {
        Profissional encanador = new Profissional("Antonio", "41988888888", "1234567891", "Encanador", 0.0, "antonio@gmail.com","1234","Antonio Encanador");
        Profissional pedreiro = new Profissional("Luis", "41977777777", "1234567891", "Pedreiro", 0.0,"luis@gmail.com","1234","Luis Encanador");
        Profissional eletricista = new Profissional("Rogerio", "4199999999", "1234567891", "Eletricista", 0.0,"rogerio@gmail.com","1234","Rogerio Encanador");

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

        pedidosEncanador.add(new Pedidos(10, 6, "Visita tecnica","Encanamento", "Sergio", "Antonio", "Visita técnica para encontrar fonte de um vazamento na casa!",0));
        pedidosEncanador.add(new Pedidos(20, 6, "Visita tecnica","Encanamento", "Claudio", "Antonio", "Visita técnica para encontrar fonte de um vazamento na casa!",0));
        pedidosEncanador.add(new Pedidos(10, 7, "Visita tecnica","Encanamento", "Roberto", "Antonio", "Visita técnica para encontrar fonte de um vazamento na casa!",0));
        pedidosEncanador.add(new Pedidos(20, 7, "Visita tecnica","Encanamento", "Sergio", "Antonio", "Visita técnica para encontrar fonte de um vazamento na casa!",0));

        encanador.setPedidos(pedidosEncanador);

        ArrayList<Pedidos> historicoEncanador = encanador.getHistorico();

        historicoEncanador.add(new Pedidos(10, 6, "Visita tecnica feito","Encanamento", "Sergio", "Antonio", "Visita técnica feito para encontrar fonte de um vazamento na casa!",1));
        historicoEncanador.add(new Pedidos(20, 6, "Visita tecnica feito","Encanamento", "Claudio", "Antonio", "Visita técnica feito para encontrar fonte de um vazamento na casa!",1));
        historicoEncanador.add(new Pedidos(10, 7, "Visita tecnica feito","Encanamento", "Roberto", "Antonio", "Visita técnica feito para encontrar fonte de um vazamento na casa!",1));
        historicoEncanador.add(new Pedidos(20, 7, "Visita tecnica feito","Encanamento", "Sergio", "Antonio", "Visita técnica feito para encontrar fonte de um vazamento na casa!",1));

        encanador.setHistorico(historicoEncanador);

        ArrayList<Pedidos> pedidosPedreiro = pedreiro.getPedidos();

        pedidosPedreiro.add(new Pedidos(10, 6, "Visita tecnica","Construção", "Sergio","Luis","Contrução de parede",0));
        pedidosPedreiro.add(new Pedidos(20, 6, "Visita tecnica","Construção", "Claudio","Luis","Construção de muro em volta da casa",0));
        pedidosPedreiro.add(new Pedidos(10, 7, "Visita tecnica","Construção", "Roberto","Luis","Contrução de casinha de bonecas em tamanho real",0));
        pedidosPedreiro.add(new Pedidos(20, 7, "Visita tecnica","Construção", "Sergio","Luis", "Construção de muro",0));

        pedreiro.setPedidos(pedidosPedreiro);

        ArrayList<Pedidos> pedidosEletricista = eletricista.getPedidos();

        pedidosEletricista.add(new Pedidos(10, 6, "Visita tecnica","Eletricidade", "Roberto","Rogerio","Conserto de fiação da casa",0));
        pedidosEletricista.add(new Pedidos(20, 6, "Visita tecnica","Eletricidade", "Sergio","Rogerio","Conserto de tomadas da casa",0));
        pedidosEletricista.add(new Pedidos(10, 7, "Visita tecnica","Eletricidade", "Claudio","Rogerio", "Instalação de chuveiro elétrico",0));
        pedidosEletricista.add(new Pedidos(20, 7, "Visita tecnica","Eletricidade", "Sergio","Rogerio", "Instalaçào de fiação de apartamento",0));

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

    public static void updateRating(String name){
        double count=0;
        double soma=0;
        Profissional p = findProfissionalByName(name);
        for (Pedidos p2 : p.getHistorico()){
            if(p2.getRating()!=-1.0){
                count++;
                soma+=p2.getRating();
            }
        }
        if(soma>0){
            p.setRating(soma/count);
        }else{
            p.setRating(0.0);
        }

    }
}
