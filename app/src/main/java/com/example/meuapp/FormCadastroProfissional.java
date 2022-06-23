package com.example.meuapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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
        Spinner ramo = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.ramos_array, R.layout.spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ramo.setAdapter(adapter);
        bt_cadastrar.setOnClickListener(new View.OnClickListener() {
            private final ArrayList<Profissional> profissionais = Database.getProfissionais();
            @Override
            public void onClick(View view) {
                EditText price = (EditText) findViewById(R.id.edit_price);
                EditText nome = (EditText) findViewById(R.id.editPersonName);
                String nomeString = nome.getText().toString();
                EditText email = (EditText) findViewById(R.id.editTextEmailAddress);
                String emailString = email.getText().toString();
                EditText cpf = (EditText) findViewById(R.id.editTextCPF);
                String cpfString = cpf.getText().toString();
                EditText telefone = (EditText) findViewById(R.id.editTextPhone);
                String telefoneString = telefone.getText().toString();
                EditText senha = (EditText) findViewById(R.id.createPassword);
                String senhaString = senha.getText().toString();
                EditText confirmarSenha = (EditText) findViewById(R.id.confirmPassword);
                String confirmarSenhaString = confirmarSenha.getText().toString();
                String ramoServicoString = ramo.getSelectedItem().toString();
                EditText bio = (EditText) findViewById(R.id.editBio);
                String bioString = bio.getText().toString();
                if (Database.verificarEmail(emailString)) {
                    TextView error = findViewById(R.id.errorMessage2);
                    error.setText("Email já cadastrado");
                } else if (senhaString.equals(confirmarSenhaString)) {
                    if (nomeString.equals("") || emailString.equals("") || cpfString.equals("") || telefoneString.equals("") ||
                            senhaString.equals("") || confirmarSenhaString.equals("") || ramoServicoString.equals("") || price.equals("")) {
                        TextView error = findViewById(R.id.errorMessage2);
                        error.setText("Informações faltando");
                    } else {
                        Profissional profissional = new Profissional(nomeString, telefoneString, cpfString, ramoServicoString, 0.0, emailString, senhaString, bioString, Double.parseDouble(price.getText().toString()));
                        profissionais.add(profissional);
                        Database.setProfissionais(profissionais);
                        Intent intent = new Intent(FormCadastroProfissional.this, FormLogin.class);
                        startActivity(intent);
                    }
                } else {//caso as senhas sejam diferentes
                    TextView error = findViewById(R.id.errorMessage2);
                    error.setText("Senhas devem ser iguais");
                }
            }
        });

    }

    private void IniciarComponentes() {
        bt_cadastrar = findViewById(R.id.bt_cadastrar);
    }
}