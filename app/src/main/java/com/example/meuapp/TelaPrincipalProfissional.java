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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.meuapp.adapter.RecycleAdapter;
import com.example.meuapp.adapter.RecycleAdapterPedidos;
import com.example.meuapp.adapter.RecycleAdapterPro;
import com.example.meuapp.data.Database;
import com.example.meuapp.data.LoginAtual;
import com.example.meuapp.data.Pedidos;
import com.example.meuapp.data.Perfil;
import com.example.meuapp.data.Profissional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TelaPrincipalProfissional extends AppCompatActivity {
    private Button bt_deslogar;
    private String nomeCliente;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LoginAtual l = Database.getLoginAtual();
        Perfil.setId(0);
        setContentView(R.layout.activity_tela_principal_profissional);
        getSupportActionBar().hide();
        IniciarComponentes();
        TextView titulo = findViewById(R.id.textTituloPro);
        titulo.setText("Bem vindo " + l.getProfissional().getNome() + "!");
        Button bt_verpedidos = findViewById(R.id.bt_verpedidos);

        bt_verpedidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaPrincipalProfissional.this, TelaServicosProfissional.class);
                startActivity(intent);
            }
        });

        ImageView bt_perfil = findViewById(R.id.containerIcon);

        bt_perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaPrincipalProfissional.this, TelaEditPerfilProfissional.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
                startActivity(intent);
                finish();
            }
        });


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

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
    }

    private void IniciarComponentes() {
        bt_deslogar = findViewById(R.id.bt_deslogar);
    }
}