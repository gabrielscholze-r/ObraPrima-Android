package com.example.meuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.meuapp.data.Cliente;
import com.example.meuapp.data.Database;

import java.util.ArrayList;

public class FormCadastroCliente extends AppCompatActivity {

    private Button bt_cadastrar;
    //pegar todas as variaveis de cadastro

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_cadastro_cliente);

        getSupportActionBar().hide();
        IniciarComponentes();



        bt_cadastrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FormCadastroCliente.this, TelaPrincipalCliente.class);
                startActivity(intent);
            }
        });

    }

    private boolean addClient(String nome, String email, String cpf, String telefone, String password){
        ArrayList<Cliente> clientes = Database.getClientes();


        return true;
    }



    private void IniciarComponentes(){
        bt_cadastrar = findViewById(R.id.bt_cadastrar);
    }
}