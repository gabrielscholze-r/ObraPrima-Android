package com.example.meuapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.meuapp.adapter.RecycleAdapter;
import com.example.meuapp.data.Database;
import com.example.meuapp.data.LoginAtual;
import com.example.meuapp.data.Pedidos;
import com.example.meuapp.data.Profissional;

import org.w3c.dom.Text;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class TelaPrincipalCliente extends AppCompatActivity {

    private Button bt_deslogar;
    private Button bt_historico;
    private Button bt_contratar1;
    private Button bt_contratar2;
    private Button bt_contratar3;
    private Button bt_lista_pro;
    private int x,y,z;
    private RecyclerView RView;
    private String ClienteNome;
    private ArrayList<Profissional> profissionais;
    private RecycleAdapter.RecyclerViewClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tela_principal_cliente);
        x = 0;
        y = 0;
        z = 0;

        getSupportActionBar().hide();
        IniciarComponentes();
        profissionais = Database.getProfissionais();
        RView = findViewById(R.id.recyclerView);
        setAdapter();
        LoginAtual loginAtual = Database.getLoginAtual();
        ClienteNome = loginAtual.getCliente().getNome();
        ArrayList<String> views = new ArrayList<>();
        TextView titulo = findViewById(R.id.textTitulo);
        titulo.setText("Bem vindo\n"+loginAtual.getCliente().getNome()+"!");

        bt_deslogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaPrincipalCliente.this, FormLogin.class);
                LoginAtual l = new LoginAtual();
                Database.setLoginAtual(l);
                startActivity(intent);
                finish();
            }

        });

        bt_historico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaPrincipalCliente.this, TelaServicosCliente.class);
                startActivity(intent);
                finish();
            }

        });
        bt_lista_pro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaPrincipalCliente.this, TelaListaProfissionais.class);
                startActivity(intent);
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
                LocalDate d = LocalDate.now();
                ArrayList<Pedidos> pedidos = profissionais.get(position).getPedidos();
                pedidos.add(new Pedidos(d.getDayOfMonth(),d.getMonth().toString(),"Visita Tecnica", ClienteNome, profissionais.get(position).getNome()));
                profissionais.get(position).setPedidos(pedidos);
                Database.setProfissionais(profissionais);
                Toast.makeText(getApplicationContext(),"Pedido feito!",Toast.LENGTH_SHORT).show();
            }
        };
    }


    private void IniciarComponentes(){
        bt_deslogar = findViewById(R.id.bt_deslogar);
        bt_historico = findViewById(R.id.bt_historico2);
        bt_lista_pro = findViewById(R.id.bt_lista_pro);
//        bt_contratar1 = findViewById(R.id.bt_Contratar1);
//        bt_contratar2 = findViewById(R.id.bt_Contratar2);
//        bt_contratar3 = findViewById(R.id.bt_Contratar3);
    }
}