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
    private RecyclerView recyclerView;
    private RecycleAdapterPedidos.RecyclerViewClickListener listener;
    private ArrayList<Profissional> profissionais;
    private ArrayList<Pedidos> pd;
    private String nomeCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_servicos_cliente);
        IniciarComponentes();
        getSupportActionBar().hide();
        LoginAtual l = new LoginAtual();
        pd = new ArrayList<>();
        nomeCliente = l.getCliente().getNome();
        profissionais = Database.getProfissionais();
        recyclerView = findViewById(R.id.recycler_services);
        setAdapter();

        bt_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaServicosCliente.this, TelaPrincipalCliente.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }

        } );

    }


    private void setAdapter() {
        setOnClickListener();
        ArrayList<Pedidos> pedidos = new ArrayList<>();
        for (Profissional p : profissionais){
            for(Pedidos p2 : p.getPedidos()){
                if(p2.getNomeCliente()==nomeCliente){
                    pedidos.add(p2);
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
                Intent intent = new Intent(TelaServicosCliente.this,TelaPedido.class);
                Perfil.setId(1);
                startActivity(intent);
                finish();
            }
        };

    }
    private void IniciarComponentes(){
        bt_home = findViewById(R.id.button_voltar);
    }

}