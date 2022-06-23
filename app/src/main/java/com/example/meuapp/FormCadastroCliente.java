package com.example.meuapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

            private ArrayList<Cliente> clientes = Database.getClientes();
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
                if(Database.verificarEmail(emailString)){
                    TextView error = findViewById(R.id.errorMessage3);
                    error.setText("Email já cadastrado.");
                }else if(senhaString.equals(confirmarSenhaString)){
                    if(nomeString.equals("") || emailString.equals("") || cpfString.equals("") || telefoneString.equals("") ||
                            senhaString.equals("") || confirmarSenhaString.equals("")){//caso algum dos dados esteja em branco
                        TextView error = findViewById(R.id.errorMessage3);
                        error.setText("Informações faltando");
                    } else{
                        Cliente cliente = new Cliente(nomeString,emailString,cpfString,telefoneString,senhaString);
                        clientes.add(cliente);
                        Database.setClientes(clientes);
                        Intent intent = new Intent(FormCadastroCliente.this, FormLogin.class);
                        startActivity(intent);
                    }
                }else{//caso as senhas sejam diferentes
                    TextView error = findViewById(R.id.errorMessage3);
                    error.setText("Senhas devem ser iguais");
                }
            }
        });

    }

    private void IniciarComponentes() {
        bt_cadastrar = findViewById(R.id.bt_cadastrar);
    }
}