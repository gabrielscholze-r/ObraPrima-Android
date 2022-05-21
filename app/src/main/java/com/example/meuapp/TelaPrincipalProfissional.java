package com.example.meuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaPrincipalProfissional extends AppCompatActivity {

    private Button bt_deslogar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal_profissional);

        getSupportActionBar().hide();
        IniciarComponentes();

        bt_deslogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaPrincipalProfissional.this, FormLogin.class);
                startActivity(intent);
                finish();
            }

        });

    }



    private void IniciarComponentes(){
        bt_deslogar = findViewById(R.id.bt_deslogar);
    }
}