package com.example.meuapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.meuapp.adapter.RecycleAdapter;
import com.example.meuapp.adapter.RecycleAdapterPedidos;
import com.example.meuapp.adapter.RecycleAdapterPro;
import com.example.meuapp.data.Database;
import com.example.meuapp.data.LoginAtual;
import com.example.meuapp.data.Pedidos;
import com.example.meuapp.data.Profissional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TelaPrincipalProfissional extends AppCompatActivity {
    private RecycleAdapterPro.RecyclerViewClickListener listener;
    private Button bt_deslogar;
    private ArrayList<Pedidos> p;
    private RecyclerView recyclerView;
    private LoginAtual loginAtual;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginAtual = Database.getLoginAtual();
        p = loginAtual.getProfissional().getPedidos();
        setContentView(R.layout.activity_tela_principal_profissional);
        getSupportActionBar().hide();
        IniciarComponentes();
        recyclerView = findViewById(R.id.recyclerView2);
        Collections.sort(p, new Comparator<Pedidos>() {
            public int compare(Pedidos s1, Pedidos s2) {
                return s1.getNomeCliente().compareTo(s2.getNomeCliente());
            }
        });
        setAdapter();
        TextView titulo = findViewById(R.id.textTituloPro);
        titulo.setText("Bem vindo " + loginAtual.getProfissional().getNome() + "!");

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
        setOnClickListener();
        RecycleAdapterPro adapter = new RecycleAdapterPro(p, listener);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setOnClickListener() {
        listener = new RecycleAdapterPro.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Pedidos pd = p.get(position);
                ArrayList<Profissional> prolist  = Database.getProfissionais();
                for (Profissional pf : prolist){
                    if(pf.getNome()==pd.getNomeProfissional()){
                        p.remove(pd);
                        pf.setPedidos(p);
                    }
                }
                Database.setProfissionais(prolist);
                Toast.makeText(getApplicationContext(),"PEDIDO EXCLUÍDO!",Toast.LENGTH_SHORT).show();
                setAdapter();
            }

        };

    }

    private void IniciarComponentes() {
        bt_deslogar = findViewById(R.id.bt_deslogar);
    }
}