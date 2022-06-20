package com.example.meuapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pedidos_profissional);
        IniciarComponentes();
        getSupportActionBar().hide();
        LoginAtual l = Database.getLoginAtual();
        profissional = l.getProfissional();
        recyclerView = findViewById(R.id.recycler_services);
        setAdapter();

        bt_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaServicosProfissional.this, TelaPrincipalProfissional.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }

        } );

    }


    private void setAdapter() {
        setOnClickListener();
        RecycleAdapterPedidos adapter = new RecycleAdapterPedidos(profissional.getPedidos(), listener);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }
    private void setOnClickListener() {
        listener = new RecycleAdapterPedidos.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Perfil.setPedido(profissional.getPedidos().get(position));
                Intent intent = new Intent(TelaServicosProfissional.this,TelaPedido.class);
                Perfil.setId(0);
                startActivity(intent);
                finish();
            }
        };

    }
    private void IniciarComponentes(){
        bt_home = findViewById(R.id.button_back2);
    }

}