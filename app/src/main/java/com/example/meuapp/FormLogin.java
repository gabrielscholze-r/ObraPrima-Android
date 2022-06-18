package com.example.meuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.meuapp.data.Cliente;
import com.example.meuapp.data.Database;
import com.example.meuapp.data.LoginAtual;
import com.example.meuapp.data.Profissional;

import java.util.ArrayList;
import java.util.Locale;

public class FormLogin extends AppCompatActivity {

    private TextView text_cadastro_profissional;
    private TextView text_cadastro_cliente;
    private Button bt_entrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        Database.loadDatabase();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_login);

        getSupportActionBar().hide();
        IniciarComponentes();

        ArrayList<Profissional> profissionais = Database.getProfissionais();
        ArrayList<Cliente> clientes = Database.getClientes();
        LoginAtual loginAtual = Database.getLoginAtual();

        bt_entrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText login = (EditText) findViewById(R.id.edit_email);
                EditText password = (EditText) findViewById(R.id.password);
                boolean logged = false;
                for (Cliente cliente : clientes) {
                    if (login.getText().toString().equals(cliente.getEmail())) {
                        if (password.getText().toString().equals(cliente.getSenha())) {
                            loginAtual.setCliente(cliente);
                            Intent intent = new Intent(FormLogin.this, TelaPrincipalCliente.class);
                            startActivity(intent);
                            logged = true;
                            break;
                        } else {
                            TextView error = findViewById(R.id.errorMessage);
                            error.setText("Email ou senha incorretos");
                        }


                    }
                }
                for (Profissional profissional : profissionais) {
                    if (login.getText().toString().equals(profissional.getEmail())) {
                        if (password.getText().toString().equals(profissional.getEmail())) {
                            loginAtual.setProfissional(profissional);
                            Intent intent = new Intent(FormLogin.this, TelaPrincipalProfissional.class);
                            startActivity(intent);
                            logged = true;
                            break;
                        } else {
                            TextView error = findViewById(R.id.errorMessage);
                            error.setText("Email ou senha incorretos");
                        }

                    }
                }
                if(!logged){
                    TextView error = findViewById(R.id.errorMessage);
                    error.setText("Email não encontrado");
                }

            }
        });


        text_cadastro_cliente.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(FormLogin.this, FormCadastroCliente.class);
                startActivity(intent);

            }
        });

        text_cadastro_profissional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(FormLogin.this, FormCadastroProfissional.class);
                startActivity(intent);

            }
        });
    }

    private void IniciarComponentes() {
        text_cadastro_profissional = findViewById(R.id.cadastro_profissional);
        text_cadastro_cliente = findViewById(R.id.cadastro_cliente);
        bt_entrar = findViewById(R.id.bt_entrar);


    }
}