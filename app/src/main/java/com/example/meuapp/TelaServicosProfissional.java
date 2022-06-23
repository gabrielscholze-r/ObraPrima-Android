package com.example.meuapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.meuapp.adapter.RecycleAdapterPedidos;
import com.example.meuapp.data.Database;
import com.example.meuapp.data.LoginAtual;
import com.example.meuapp.data.Pedidos;
import com.example.meuapp.data.Perfil;
import com.example.meuapp.data.Profissional;

import java.util.ArrayList;

public class TelaServicosProfissional extends AppCompatActivity {

    private ImageView bt_home;
    private RecyclerView recyclerView;
    private RecycleAdapterPedidos.RecyclerViewClickListener listener;
    private Profissional profissional;
    ArrayList<Pedidos> pedidos;
    private TextView text_titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pedidos_profissional);
        IniciarComponentes();
        getSupportActionBar().hide();
        text_titulo = findViewById(R.id.text_titulo);

        LoginAtual l = new LoginAtual();
        profissional = l.getProfissional();
        recyclerView = findViewById(R.id.recycler_services);
        verify();

        setAdapter();

        bt_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaServicosProfissional.this, TelaPrincipalProfissional.class);
                startActivity(intent);
                finish();
            }

        });

    }


    private void setAdapter() {
        setOnClickListener();
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
                if (profissional.getTipoPedido() == 0) {
                    Perfil.setPedido(profissional.getPedidos().get(position));
                }else{
                    Perfil.setPedido(profissional.getHistorico().get(position));
                }
                Intent intent = new Intent(TelaServicosProfissional.this, TelaPedido.class);
                Perfil.setId(0);
                startActivity(intent);
                finish();
            }
        };

    }

    private void verify() {
        if (profissional.getTipoPedido() == 0) {
            text_titulo.setText("MEUS SERVIÇOS");
            pedidos = profissional.getPedidos();
        } else {
            text_titulo.setText("HISTÓRICO");
            pedidos = profissional.getHistorico();
        }
    }

    private void IniciarComponentes() {
        bt_home = findViewById(R.id.button_voltar);
    }

}