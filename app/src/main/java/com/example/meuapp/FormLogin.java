package com.example.meuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FormLogin extends AppCompatActivity {

    private TextView text_cadastro_profissional;
    private TextView text_cadastro_cliente;
    private Button bt_entrar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_login);

        getSupportActionBar().hide();
        IniciarComponentes();


        bt_entrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Para testar a outra tela mudar o "TelaServicosCliente.class" por "TelaPrincipalCliente.class"
                Intent intent = new Intent(FormLogin.this, TelaServicosCliente.class);
                startActivity(intent);

            }
        });


        text_cadastro_cliente.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(FormLogin.this, FormCadastroCliente.class);
                startActivity(intent);

            }
        });

        text_cadastro_profissional.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent intent = new Intent(FormLogin.this, FormCadastroProfissional.class);
                startActivity(intent);

            }
        });
    }

    private void IniciarComponentes(){
        text_cadastro_profissional = findViewById(R.id.cadastro_profissional);
        text_cadastro_cliente = findViewById(R.id.cadastro_cliente);
        bt_entrar = findViewById(R.id.bt_entrar);


    }
}