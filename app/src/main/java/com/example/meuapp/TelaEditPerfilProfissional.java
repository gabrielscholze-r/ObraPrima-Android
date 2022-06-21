package com.example.meuapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.meuapp.data.Database;
import com.example.meuapp.data.LoginAtual;
import com.example.meuapp.data.Profissional;

import java.util.ArrayList;

public class TelaEditPerfilProfissional extends AppCompatActivity {
    private Profissional profissional;
    private Profissional novoProfissional;
    private String novoNome;
    private String novoEmail;
    private String novoCPF;
    private String NovoTelefone;
    private String novaBio;
    private String SenhaAtual;
    private String novaSenha;
    private String confirmaNovaSenha;
    private String ramo;
    private TextView error;
    private Spinner dropbox;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_perfil_profissional);
        dropbox = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.ramos_array, R.layout.spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropbox.setAdapter(adapter);
        getSupportActionBar().hide();
        profissional = Database.getLoginAtual().getProfissional();
        novoProfissional = profissional;
        TextView nome = findViewById(R.id.nome_profissional2);
        TextView email = findViewById(R.id.email_profissional2);
        TextView CPF = findViewById(R.id.CPF_profissional);
        TextView telefone = findViewById(R.id.phone_profissional);
        TextView description = findViewById(R.id.desc_profissional);
        nome.setText(profissional.getNome());
        email.setText(profissional.getEmail());
        CPF.setText(profissional.getCpf());
        telefone.setText(profissional.getTelefone());
        description.setText(profissional.getBio());
        error = findViewById(R.id.error_message2);
        System.out.println(profissional.getRamo());
        if (profissional.getRamo().equals("Eletricista")) {
            dropbox.setSelection(0);
        } else if (profissional.getRamo().equals("Pedreiro")) {
            dropbox.setSelection(1);
        } else {
            dropbox.setSelection(2);
        }
        Button apply = findViewById(R.id.bt_attdados);
        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFormInfo();
                validar();
            }
        });
        ImageView bt_voltar = findViewById(R.id.button_voltar);
        bt_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaEditPerfilProfissional.this, TelaPrincipalProfissional.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void getFormInfo() {
        EditText nNome = (EditText) findViewById(R.id.novo_nome_profissional);
        EditText nEmail = (EditText) findViewById(R.id.novo_email_prof);
        EditText nCPF = (EditText) findViewById(R.id.edit_cpf_prof);
        EditText nPhone = (EditText) findViewById(R.id.novo_phone_prof);
        EditText nDesc = (EditText) findViewById(R.id.nova_bio_prof);
        EditText nSenhaAtual = (EditText) findViewById(R.id.senha_atual_profissional2);
        EditText nNovaSenha = (EditText) findViewById(R.id.nova_senha_profissional);
        EditText nConfirmaSenha = (EditText) findViewById(R.id.confirmar_senha_profissional);

        ramo = dropbox.getSelectedItem().toString();
        novoNome = nNome.getText().toString();
        novoEmail = nEmail.getText().toString();
        novoCPF = nCPF.getText().toString();
        NovoTelefone = nPhone.getText().toString();
        novaBio = nDesc.getText().toString();
        SenhaAtual = nSenhaAtual.getText().toString();
        confirmaNovaSenha = nConfirmaSenha.getText().toString();
        novaSenha = nNovaSenha.getText().toString();
    }

    private void validar() {
        boolean erro = false;
        int index = Database.profissionais.indexOf(profissional);
        if (novoNome.isEmpty() && novoEmail.isEmpty() && novoCPF.isEmpty() && NovoTelefone.isEmpty() &&
                novaSenha.isEmpty() && profissional.getRamo()==ramo) {
            erro = true;
            error.setText("Modifique algum campo!");
        }
        if (!novoNome.isEmpty()) {
            novoProfissional.setNome(novoNome);
        }
        if (!novoEmail.isEmpty()) {
            novoProfissional.setEmail(novoEmail);
        }
        if (!novoCPF.isEmpty()) {
            novoProfissional.setCpf(novoCPF);
        }
        if (!NovoTelefone.isEmpty()) {
            novoProfissional.setTelefone(NovoTelefone);
        }
        if(!novaBio.isEmpty()){

        }
        if (!novaSenha.isEmpty()) {
            if (SenhaAtual.equals(novoProfissional.getSenha())) {
                if (novaSenha.equals(confirmaNovaSenha)) {
                    novoProfissional.setSenha(novaSenha);
                } else {
                    error.setText("Novas senhas devem ser iguais!");
                    erro = true;
                }
            } else {
                error.setText("Senha atual incorreta");
                erro = true;
            }
        }
        if(profissional.getRamo()!=ramo){
            novoProfissional.setRamo(ramo);
        }
        if (!erro) {
            ArrayList<Profissional> profissionais = Database.getProfissionais();
            profissionais.add(index, novoProfissional);
            Database.setProfissionais(profissionais);
            Intent intent = new Intent(TelaEditPerfilProfissional.this, TelaPrincipalProfissional.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            LoginAtual.setProfissional(novoProfissional);
            Toast.makeText(getApplicationContext(), "Dados Alterados!", Toast.LENGTH_SHORT).show();
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        Intent intent = new Intent(TelaEditPerfilProfissional.this, TelaPrincipalProfissional.class);
        startActivity(intent);
        finish();
    }
}
