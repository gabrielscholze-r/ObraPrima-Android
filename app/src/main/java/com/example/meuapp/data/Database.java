package com.example.meuapp.data;

import android.util.Log;

import java.util.ArrayList;

import com.example.meuapp.data.Profissional;

public class Database {

    public static ArrayList<Profissional> profissionais = new ArrayList<>();
    public static ArrayList<Cliente> clientes = new ArrayList<>();


    public static void loadDatabase() {
        Profissional encanador = new Profissional("Antonio", "41988888888", "1234567891", "Encanador", 0.0, "antonio@gmail.com","1234","Encanador há 20 anos, conheço todos os tipos de encanamento e consigo consertar cobrando um preço justo", 50);
        Profissional pedreiro = new Profissional("Luis", "41977777777", "1234567891", "Pedreiro", 0.0,"luis@gmail.com","1234","Luis",100);
        Profissional eletricista = new Profissional("Rogerio", "4199999999", "1234567891", "Eletricista", 0.0,"rogerio@gmail.com","1234","Rogerio Encanador", 60);

        Cliente cliente1 = new Cliente("Sergio", "sergio123@gmail.com", "12345678912", "999999999", "1234");
        Cliente cliente2 = new Cliente("Claudio", "claudio123@gmail.com", "12345678912", "999999999", "1234");
        Cliente cliente3 = new Cliente("Roberto", "roberto123@gmail.com", "12345678912", "999999999", "1234");

        if(!profissionais.contains(encanador)){
            profissionais.add(encanador);
        }
        if(!profissionais.contains(pedreiro)){
            profissionais.add(pedreiro);
        }
        if(!profissionais.contains(eletricista)){
            profissionais.add(eletricista);
        }


        if(!clientes.contains(cliente1)){
            clientes.add(cliente1);
        }
        if(!clientes.contains(cliente2)){
            clientes.add(cliente2);
        }
        if(!clientes.contains(cliente3)){
            clientes.add(cliente3);
        }

        ArrayList<Pedidos> pedidosEncanador = encanador.getPedidos();
        Pedidos p1 = new Pedidos(10, 6, "Visita tecnica","Encanamento", "Sergio", "Antonio", "Visita técnica para encontrar fonte de um vazamento na casa!",0, 50);
        Pedidos p2 = new Pedidos(20, 6, "Visita tecnica","Encanamento", "Claudio", "Antonio", "Visita técnica para encontrar fonte de um vazamento na casa!",0,50);
        Pedidos p3 = new Pedidos(10, 7, "Visita tecnica","Encanamento", "Roberto", "Antonio", "Visita técnica para encontrar fonte de um vazamento na casa!",0,50);
        Pedidos p4 = new Pedidos(20, 7, "Visita tecnica","Encanamento", "Sergio", "Antonio", "Visita técnica para encontrar fonte de um vazamento na casa!",0,50);


        if(!pedidosEncanador.contains(p1)){
            pedidosEncanador.add(p1);
        }
        if(!pedidosEncanador.contains(p2)){
            pedidosEncanador.add(p2);
        }
        if(!pedidosEncanador.contains(p3)){
            pedidosEncanador.add(p3);
        }
        if(!pedidosEncanador.contains(p4)){
            pedidosEncanador.add(p4);
        }
        encanador.setPedidos(pedidosEncanador);

        ArrayList<Pedidos> historicoEncanador = encanador.getHistorico();
        p1 = new Pedidos(10, 6, "Visita tecnica","Encanamento", "Sergio", "Antonio", "Visita técnica feito para encontrar fonte de um vazamento na casa!",1, 50);
        p2 = new Pedidos(20, 6, "Visita tecnica","Encanamento", "Claudio", "Antonio", "Visita técnica feito para encontrar fonte de um vazamento na casa!",1,50);
        p3 = new Pedidos(10, 7, "Visita tecnica","Encanamento", "Roberto", "Antonio", "Visita técnica feito para encontrar fonte de um vazamento na casa!",1, 50);
        p4 = new Pedidos(20, 7, "Visita tecnica","Encanamento", "Sergio", "Antonio", "Visita técnica feito para encontrar fonte de um vazamento na casa!",1,50);

        if(!historicoEncanador.contains(p1)){
            historicoEncanador.add(p1);
        }
        if(!historicoEncanador.contains(p2)){
            historicoEncanador.add(p2);
        }
        if(!historicoEncanador.contains(p3)){
            historicoEncanador.add(p3);
        }
        if(!historicoEncanador.contains(p4)){
            historicoEncanador.add(p4);
        }

        encanador.setHistorico(historicoEncanador);

        ArrayList<Pedidos> pedidosPedreiro = pedreiro.getPedidos();
        p1 = new Pedidos(10, 6, "Visita tecnica","Construção", "Sergio","Luis","Contrução de parede",0,100);
        p2 = new Pedidos(20, 6, "Visita tecnica","Construção", "Claudio","Luis","Construção de muro em volta da casa",0,100);
        p3 = new Pedidos(10, 7, "Visita tecnica","Construção", "Roberto","Luis","Contrução de casinha de bonecas em tamanho real",0,100);
        p4 = new Pedidos(20, 7, "Visita tecnica","Construção", "Sergio","Luis", "Construção de muro",0,100);

        if(!pedidosPedreiro.contains(p1)){
            pedidosPedreiro.add(p1);
        } if(!pedidosPedreiro.contains(p2)){
            pedidosPedreiro.add(p2);
        } if(!pedidosPedreiro.contains(p3)){
            pedidosPedreiro.add(p3);
        } if(!pedidosPedreiro.contains(p4)){
            pedidosPedreiro.add(p4);
        }




        pedreiro.setPedidos(pedidosPedreiro);

        ArrayList<Pedidos> pedidosEletricista = eletricista.getPedidos();
        p1 = new Pedidos(10, 6, "Visita tecnica","Eletricidade", "Roberto","Rogerio","Conserto de fiação da casa",0, 60);
        p2 = new Pedidos(20, 6, "Visita tecnica","Eletricidade", "Sergio","Rogerio","Conserto de tomadas da casa",0,60);
        p3 = new Pedidos(10, 7, "Visita tecnica","Eletricidade", "Claudio","Rogerio", "Instalação de chuveiro elétrico",0,60);
        p4 = new Pedidos(20, 7, "Visita tecnica","Eletricidade", "Sergio","Rogerio", "Instalaçào de fiação de apartamento",0,60);

        if(!pedidosEletricista.contains(p1)){
            pedidosEletricista.add(p1);
        }if(!pedidosEletricista.contains(p2)){
            pedidosEletricista.add(p2);
        }if(!pedidosEletricista.contains(p3)){
            pedidosEletricista.add(p3);
        }if(!pedidosEletricista.contains(p4)){
            pedidosEletricista.add(p4);
        }
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
