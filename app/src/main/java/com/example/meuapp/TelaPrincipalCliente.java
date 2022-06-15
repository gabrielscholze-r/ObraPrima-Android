package com.example.meuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.meuapp.data.Database;
import com.example.meuapp.data.Pedidos;
import com.example.meuapp.data.Profissional;

import java.util.ArrayList;

public class TelaPrincipalCliente extends AppCompatActivity {

    private Button bt_deslogar;
    private Button bt_historico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal_cliente);

        getSupportActionBar().hide();
        IniciarComponentes();


        TextView et1 = (TextView) findViewById(R.id.historico3);
        ArrayList<Profissional> profissionais = Database.getProfissionais();
        et1.setText(profissionais.get(0).getNome()+"      "+profissionais.get(0).getRamo()+"      "+profissionais.get(0).getRating());

        TextView et2 = (TextView) findViewById(R.id.historico2);
        et2.setText(profissionais.get(1).getNome()+"      "+profissionais.get(1).getRamo()+"      "+profissionais.get(1).getRating());

        TextView et3 = (TextView) findViewById(R.id.historico);
        et3.setText(profissionais.get(2).getNome()+"      "+profissionais.get(2).getRamo()+"      "+profissionais.get(2).getRating());

        bt_deslogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaPrincipalCliente.this, FormLogin.class);
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

    }



    private void IniciarComponentes(){
        bt_deslogar = findViewById(R.id.bt_deslogar);
        bt_historico = findViewById(R.id.bt_historico);
    }
}