package com.example.meuapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.meuapp.adapter.RecycleAdapter;
import com.example.meuapp.adapter.RecycleAdapterPro;
import com.example.meuapp.data.Database;
import com.example.meuapp.data.LoginAtual;
import com.example.meuapp.data.Pedidos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TelaPrincipalProfissional extends AppCompatActivity {

    private Button bt_deslogar;
    private ArrayList<Pedidos> p;
    private RecyclerView recyclerView;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LoginAtual loginAtual = Database.getLoginAtual();
        p = loginAtual.getProfissional().getPedidos();
        setContentView(R.layout.activity_tela_principal_profissional);
        getSupportActionBar().hide();
        IniciarComponentes();
        recyclerView = findViewById(R.id.recyclerView2);
        Collections.sort(p, new Comparator<Pedidos>(){
            public int compare(Pedidos s1, Pedidos s2){
                return s1.getNomeCliente().compareTo(s2.getNomeCliente());
            }
        });
        setAdapter();
        TextView titulo = findViewById(R.id.textTituloPro);
        titulo.setText("Bem vindo "+loginAtual.getProfissional().getNome()+"!");

        bt_deslogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaPrincipalProfissional.this, FormLogin.class);
                LoginAtual l = new LoginAtual();
                Database.setLoginAtual(l);
                startActivity(intent);
                finish();
            }

        });

    }

    private void setAdapter() {
        RecycleAdapterPro adapter = new RecycleAdapterPro(p);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void IniciarComponentes(){
        bt_deslogar = findViewById(R.id.bt_deslogar);
    }
}