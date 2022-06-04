package com.example.meuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.meuapp.data.Database;
import com.example.meuapp.data.Pedidos;

import java.util.ArrayList;

public class TelaPrincipalCliente extends AppCompatActivity {

    private Button bt_deslogar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal_cliente);

        getSupportActionBar().hide();
        IniciarComponentes();


        EditText et1 = (EditText) findViewById(R.id.historico3);
        ArrayList<Pedidos> pedidos = Database.getPedidos();
        et1.setText(pedidos.get(0).getTituloPedido() + "           "+ pedidos.get(0).getDia()+"/"+pedidos.get(0).getMes());

        EditText et2 = (EditText) findViewById(R.id.historico2);
        et2.setText(pedidos.get(2).getTituloPedido() + "           "+ pedidos.get(2).getDia()+"/"+pedidos.get(2).getMes());

        EditText et3 = (EditText) findViewById(R.id.historico);
        et3.setText(pedidos.get(1).getTituloPedido() + "           "+ pedidos.get(1).getDia()+"/"+pedidos.get(1).getMes());

        bt_deslogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaPrincipalCliente.this, FormLogin.class);
                startActivity(intent);
                finish();
            }

        });

    }



    private void IniciarComponentes(){
        bt_deslogar = findViewById(R.id.bt_deslogar);
    }
}