package com.example.meuapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.meuapp.adapter.RecycleAdapterPedidos;
import com.example.meuapp.data.Database;
import com.example.meuapp.data.LoginAtual;
import com.example.meuapp.data.Pedidos;
import com.example.meuapp.data.Perfil;
import com.example.meuapp.data.Profissional;

import java.util.ArrayList;

public class TelaServicosCliente extends AppCompatActivity {

    private ImageView bt_home;
    private LoginAtual loginAtual;
    private RecyclerView recyclerView;
    private RecycleAdapterPedidos.RecyclerViewClickListener listener;
    private ArrayList<Profissional> profissionais;
    private ArrayList<Pedidos> pd;
    private String emailCliente;
    private String nomeCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //0 = meus pedidos pendentes
        //1 = pedidos ja concluidos
        //2 = pedidos concluidos que requerem avaliação
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_servicos_cliente);
        IniciarComponentes();
        getSupportActionBar().hide();
        loginAtual = new LoginAtual();
        pd = new ArrayList<>();
        nomeCliente = loginAtual.getCliente().getNome();
        emailCliente = loginAtual.getCliente().getEmail();
        profissionais = Database.getProfissionais();
        recyclerView = findViewById(R.id.recycler_services);
        setAdapter();

        bt_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaServicosCliente.this, TelaPrincipalCliente.class);
                startActivity(intent);
                finish();
            }

        } );

    }


    private void setAdapter() {
        setOnClickListener();
        ArrayList<Pedidos> pedidos = new ArrayList<>();
        if(loginAtual.getCliente().getTipoPedido()==0){
            for (Profissional p : profissionais){
                for(Pedidos p2 : p.getPedidos()){
                    if(p2.getEmailCliente()==emailCliente && p2.getTipoPedido()==0){
                        pedidos.add(p2);
                    }
                }
            }
        }
        else if(loginAtual.getCliente().getTipoPedido()==1){
            for (Profissional p : profissionais){
                for(Pedidos p2 : p.getHistorico()){
                    if(p2.getEmailCliente()==emailCliente && p2.getTipoPedido()==1){
                        pedidos.add(p2);
                    }
                }
            }
        }
        else{
            for (Profissional p : profissionais){
                for(Pedidos p2 : p.getHistorico()){
                    if(p2.getEmailCliente()==emailCliente && p2.getTipoPedido()==1 && p2.getRating()==-1.0){
                        pedidos.add(p2);
                    }
                }
            }
        }
        pd = pedidos;
        RecycleAdapterPedidos adapter = new RecycleAdapterPedidos(pedidos, listener);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }
    private void setOnClickListener() {
        listener = new RecycleAdapterPedidos.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Perfil.setPedido(pd.get(position));
                Perfil.setId(1);
                if(loginAtual.getCliente().getTipoPedido()==2){
                    Intent intent = new Intent(TelaServicosCliente.this,TelaAvaliar.class);
                    startActivity(intent);
                    finish();
                }else{
                    Intent intent = new Intent(TelaServicosCliente.this,TelaPedido.class);
                    startActivity(intent);
                    finish();
                }

            }
        };

    }
    private void IniciarComponentes(){
        bt_home = findViewById(R.id.button_voltar);
    }
    @Override
    public void onBackPressed() {
//
        Intent intent = new Intent(TelaServicosCliente.this,TelaPrincipalCliente.class);
        startActivity(intent);
        finish();
    }
}