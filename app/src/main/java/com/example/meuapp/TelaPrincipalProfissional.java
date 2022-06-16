package com.example.meuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.meuapp.data.Database;
import com.example.meuapp.data.LoginAtual;
import com.example.meuapp.data.Pedidos;

import java.util.ArrayList;

public class TelaPrincipalProfissional extends AppCompatActivity {

    private Button bt_deslogar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LoginAtual loginAtual = Database.getLoginAtual();
        ArrayList<Pedidos> pedidos = loginAtual.getProfissional().getPedidos();
        setContentView(R.layout.activity_tela_principal_profissional);


        TextView titulo = findViewById(R.id.textTituloPro);
        titulo.setText("Bem vindo\n"+loginAtual.getProfissional().getNome()+"!");

        TextView et1 = findViewById(R.id.jobView);
        et1.setText(pedidos.get(0).getTituloPedido()+":     "+pedidos.get(0).getDia()+"/"+pedidos.get(0).getMes());

        TextView et2 = findViewById(R.id.jobView2);
        et2.setText(pedidos.get(1).getTituloPedido()+":     "+pedidos.get(1).getDia()+"/"+pedidos.get(1).getMes());

        TextView et3 = findViewById(R.id.jobView3);
        et3.setText(pedidos.get(2).getTituloPedido()+":     "+pedidos.get(2).getDia()+"/"+pedidos.get(2).getMes());

        TextView et4 = findViewById(R.id.jobView4);
        et4.setText(pedidos.get(3).getTituloPedido()+":     "+pedidos.get(3).getDia()+"/"+pedidos.get(3).getMes());

        getSupportActionBar().hide();
        IniciarComponentes();

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



    private void IniciarComponentes(){
        bt_deslogar = findViewById(R.id.bt_deslogar);
    }
}