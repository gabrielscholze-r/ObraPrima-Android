package com.example.meuapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.meuapp.adapter.RecycleAdapter;
import com.example.meuapp.data.Database;
import com.example.meuapp.data.Perfil;
import com.example.meuapp.data.Profissional;

import java.util.ArrayList;

public class TelaListaProfissionais extends AppCompatActivity {

    private RecyclerView RView;
    private ArrayList<Profissional> profissionais;
    private ImageView bt_voltar;
    private RecycleAdapter.RecyclerViewClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_profissionais);
        getSupportActionBar().hide();
        iniciarComponentes();

        profissionais = Database.getProfissionais();
        RView = findViewById(R.id.lista_profissionais);
        setAdapter();


        bt_voltar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(TelaListaProfissionais.this, TelaPrincipalCliente.class);
                startActivity(intent);
                finish();
            }
        });
    }
    private void setAdapter() {
        setOnClickListener();
        RecycleAdapter adapter = new RecycleAdapter(profissionais, listener);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        RView.setLayoutManager(layoutManager);
        RView.setItemAnimator(new DefaultItemAnimator());
        RView.setAdapter(adapter);
    }
    private void setOnClickListener() {
        listener = new RecycleAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(TelaListaProfissionais.this, TelaPerfilProfissional.class);
//                intent.putExtra("nomeProfissional", profissionais.get(position).getNome());
                Perfil.setProfissional(profissionais.get(position));
                startActivity(intent);
                finish();

            }
        };
    }

    @Override
    public void onBackPressed() {
//
            Intent intent = new Intent(TelaListaProfissionais.this,TelaPrincipalCliente.class);
            startActivity(intent);
            finish();

    }

    public void iniciarComponentes(){
        bt_voltar = findViewById(R.id.bt_voltar);
    }
}
