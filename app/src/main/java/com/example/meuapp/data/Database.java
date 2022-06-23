package com.example.meuapp.data;

import android.util.Log;

import java.util.ArrayList;

import com.example.meuapp.data.Profissional;

public class Database {

    public static ArrayList<Profissional> profissionais = new ArrayList<>();
    public static ArrayList<Cliente> clientes = new ArrayList<>();


    public static void loadDatabase() {

        Profissional encanador = new Profissional("Antonio", "41988888888", "1234567891", "Encanador", 0.0, "antonio@gmail.com","1234","Encanador há 20 anos, conheço todos os tipos de encanamento e consigo consertar cobrando um preço justo.", 50);
        ArrayList<Pedidos> pedidosEncanador = encanador.getPedidos();
        Pedidos p1 = new Pedidos(10, 6, "Visita técnica","Encanamento", "Sergio", "Antonio", "Visita técnica para encontrar fonte de um vazamento na casa!",0, 50,"sergio123@gmail.com","antonio@gmail.com");
        Pedidos p2 = new Pedidos(20, 6, "Visita técnica","Encanamento", "Claudio", "Antonio", "Visita técnica para encontrar fonte de um vazamento na casa!",0,50,"claudio123@gmail.com","antonio@gmail.com");
        Pedidos p3 = new Pedidos(10, 7, "Visita técnica","Encanamento", "Roberto", "Antonio", "Visita técnica para encontrar fonte de um vazamento na casa!",0,50,"roberto123@gmail.com","antonio@gmail.com");
        Pedidos p4 = new Pedidos(20, 7, "Visita técnica","Encanamento", "Sergio", "Antonio", "Visita técnica para encontrar fonte de um vazamento na casa!",0,50,"sergio123@gmail.com","antonio@gmail.com");
        ArrayList<Pedidos> historicoEncanador = encanador.getHistorico();
        Pedidos h1 = new Pedidos(10, 6, "Visita técnica","Encanamento", "Sergio", "Antonio", "Visita técnica feito para encontrar fonte de um vazamento na casa!",1, 50,"sergio123@gmail.com","antonio@gmail.com");
        Pedidos h2 = new Pedidos(20, 6, "Visita técnica","Encanamento", "Claudio", "Antonio", "Visita técnica feito para encontrar fonte de um vazamento na casa!",1,50,"claudio123@gmail.com","antonio@gmail.com");
        Pedidos h3 = new Pedidos(10, 7, "Visita técnica","Encanamento", "Roberto", "Antonio", "Visita técnica feito para encontrar fonte de um vazamento na casa!",1, 50,"roberto123@gmail.com","antonio@gmail.com");
        Pedidos h4 = new Pedidos(20, 7, "Visita técnica","Encanamento", "Sergio", "Antonio", "Visita técnica feito para encontrar fonte de um vazamento na casa!",1,50,"sergio123@gmail.com","antonio@gmail.com");
        if(!verificarEmail(encanador.getEmail())){
            profissionais.add(encanador);
            pedidosEncanador.add(p1);
            pedidosEncanador.add(p2);
            pedidosEncanador.add(p3);
            pedidosEncanador.add(p4);
            historicoEncanador.add(h1);
            historicoEncanador.add(h2);
            historicoEncanador.add(h3);
            historicoEncanador.add(h4);
            encanador.setPedidos(pedidosEncanador);
            encanador.setHistorico(historicoEncanador);
        }

        Profissional pedreiro = new Profissional("Luis", "41977777777", "1234567891", "Pedreiro", 0.0,"luis@gmail.com","1234","Luis",100);
        ArrayList<Pedidos> pedidosPedreiro = pedreiro.getPedidos();
        p1 = new Pedidos(10, 6, "Visita técnica","Construção", "Sergio","Luis","Contrução de parede",0,100,"sergio123@gmail.com","luis@gmail.com");
        p2 = new Pedidos(20, 6, "Visita técnica","Construção", "Claudio","Luis","Construção de muro em volta da casa",0,100,"claudio123@gmail.com","luis@gmail.com");
        p3 = new Pedidos(10, 7, "Visita técnica","Construção", "Roberto","Luis","Contrução de casinha de bonecas em tamanho real",0,100,"roberto123@gmail.com","luis@gmail.com");
        p4 = new Pedidos(20, 7, "Visita técnica","Construção", "Sergio","Luis", "Construção de muro",0,100,"sergio123@gmail.com","luis@gmail.com");
        if(!verificarEmail(pedreiro.getEmail())){
            profissionais.add(pedreiro);
            pedidosPedreiro.add(p1);
            pedidosPedreiro.add(p2);
            pedidosPedreiro.add(p3);
            pedidosPedreiro.add(p4);
            pedreiro.setPedidos(pedidosPedreiro);
        }

        Profissional eletricista = new Profissional("Rogerio", "4199999999", "1234567891", "Eletricista", 0.0,"rogerio@gmail.com","1234","Rogerio Encanador", 60);
        ArrayList<Pedidos> pedidosEletricista = eletricista.getPedidos();
        p1 = new Pedidos(10, 6, "Visita técnica","Eletricidade", "Roberto","Rogerio","Conserto de fiação da casa",0, 60,"sergio123@gmail.com","rogerio@gmail.com");
        p2 = new Pedidos(20, 6, "Visita técnica","Eletricidade", "Sergio","Rogerio","Conserto de tomadas da casa",0,60,"claudio123@gmail.com","rogerio@gmail.com");
        p3 = new Pedidos(10, 7, "Visita técnica","Eletricidade", "Claudio","Rogerio", "Instalação de chuveiro elétrico",0,60,"roberto123@gmail.com","rogerio@gmail.com");
        p4 = new Pedidos(20, 7, "Visita técnica","Eletricidade", "Sergio","Rogerio", "Instalaçào de fiação de apartamento",0,60,"sergio123@gmail.com","rogerio@gmail.com");
        if(!verificarEmail(eletricista.getEmail())){
            profissionais.add(eletricista);
            pedidosEletricista.add(p1);
            pedidosEletricista.add(p2);
            pedidosEletricista.add(p3);
            pedidosEletricista.add(p4);
            eletricista.setPedidos(pedidosEletricista);
        }

        Cliente cliente1 = new Cliente("Sergio", "sergio123@gmail.com", "12345678912", "999999999", "1234");
        if(!verificarEmail(cliente1.getEmail())){
            clientes.add(cliente1);
        }
        Cliente cliente2 = new Cliente("Claudio", "claudio123@gmail.com", "12345678912", "999999999", "1234");
        if(!verificarEmail(cliente2.getEmail())){
            clientes.add(cliente2);
        }
        Cliente cliente3 = new Cliente("Roberto", "roberto123@gmail.com", "12345678912", "999999999", "1234");
        if(!verificarEmail(cliente3.getEmail())){
            clientes.add(cliente3);
        }
    }

    public static boolean verificarEmail(String email){
        for(Profissional p : profissionais){
            if(p.getEmail().equals(email)){
                return true;
            }
        }
        for(Cliente c : clientes){
            if(c.getEmail().equals(email)){
                return true;
            }
        }
        return false;
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

    public static Profissional findProfissionalByEmail(String email){
        for(Profissional p : profissionais){
            if(p.getEmail().equals(email)){
                return p;
            }
        }
        return null;
    }

    public static void removeProfissionalByEmail(String email){
        for (Profissional p : profissionais){
            if(p.getEmail().equals(email)){
                profissionais.remove(p);
            }
        }
    }

    public static void updateRating(String email){
        double count=0;
        double soma=0;
        Profissional p = findProfissionalByEmail(email);
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
