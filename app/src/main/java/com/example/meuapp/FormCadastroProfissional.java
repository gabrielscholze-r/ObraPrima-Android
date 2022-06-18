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
import com.example.meuapp.data.Profissional;

import java.util.ArrayList;

public class FormCadastroProfissional extends AppCompatActivity {

    private Button bt_cadastrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_cadastro_profissional);

        getSupportActionBar().hide();
        IniciarComponentes();

        bt_cadastrar.setOnClickListener(new View.OnClickListener() {

            private ArrayList<Profissional> profissionais = Database.getProfissionais();
            @Override
            public void onClick(View view) {
                EditText nome = (EditText)findViewById(R.id.editPersonName);
                String nomeString = nome.getText().toString();
                EditText email = (EditText)findViewById(R.id.editTextEmailAddress);
                String emailString = email.getText().toString();
                EditText cpf = (EditText)findViewById(R.id.editTextCPF);
                String cpfString = cpf.getText().toString();
                EditText telefone = (EditText)findViewById(R.id.editTextPhone);
                String telefoneString = telefone.getText().toString();
                EditText senha = (EditText)findViewById(R.id.createPassword);
                String senhaString = senha.getText().toString();
                EditText confirmarSenha = (EditText)findViewById(R.id.confirmPassword);
                String confirmarSenhaString = confirmarSenha.getText().toString();
                EditText ramoServico = (EditText)findViewById(R.id.ramodoservico);
                String ramoServicoString = ramoServico.getText().toString();
                EditText bio = (EditText) findViewById(R.id.editBio);
                String bioString = bio.getText().toString();
                if(senhaString.equals(confirmarSenhaString)){
                    if(nomeString.equals("") || emailString.equals("") || cpfString.equals("") || telefoneString.equals("") ||
                            senhaString.equals("") || confirmarSenhaString.equals("") || ramoServicoString.equals("")){
                        TextView error = findViewById(R.id.errorMessage2);
                        error.setText("Informações faltando");
                    } else{
                        Profissional profissional = new Profissional(nomeString,telefoneString,cpfString,ramoServicoString,0.0,emailString, senhaString,bioString);
                        profissionais.add(profissional);
                        Database.setProfissionais(profissionais);
                        Intent intent = new Intent(FormCadastroProfissional.this, FormLogin.class);
                        startActivity(intent);
                    }
                }else{//caso as senhas sejam diferentes
                    TextView error = findViewById(R.id.errorMessage2);
                    error.setText("Senhas devem ser iguais");
                }
            }
        });

    }

    private void IniciarComponentes(){
        bt_cadastrar = findViewById(R.id.bt_cadastrar);
    }
}