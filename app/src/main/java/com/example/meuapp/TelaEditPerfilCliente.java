package com.example.meuapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.meuapp.data.Cliente;
import com.example.meuapp.data.Database;
import com.example.meuapp.data.LoginAtual;

import java.util.ArrayList;

public class TelaEditPerfilCliente extends AppCompatActivity {
    private Cliente cliente;
    private Cliente novoCliente;
    private String SenhaAtual;
    private String NovoNome;
    private String NovoEmail;
    private String NovoCPF;
    private String NovoPhone;
    private String NovaSenha;
    private String ConfirmaNovaSenha;
    private TextView error;


    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_editar_perfil_cliente);
        getSupportActionBar().hide();
        cliente = new LoginAtual().getCliente();
        novoCliente = cliente;
        TextView name =  findViewById(R.id.user_name);
        name.setText(cliente.getNome());
        TextView email = findViewById(R.id.user_email);
        email.setText(cliente.getEmail());
        TextView cpf = findViewById(R.id.user_cpf);
        cpf.setText(cliente.getCpf());
        TextView telefone = findViewById(R.id.user_phone);
        telefone.setText(cliente.getTelefone());
        error = findViewById(R.id.error_message2);

        Button bt_aplicar = findViewById(R.id.bt_attdados3);
        bt_aplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFormInfo();
                ValidarDados();
            }
        });

        ImageView bt_home = findViewById(R.id.button_voltar);

        bt_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaEditPerfilCliente.this, TelaPrincipalCliente.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }

        } );
    }
    private void getFormInfo(){
//        error.setText("");
        EditText novonome = (EditText) findViewById(R.id.edit_nome);
        EditText novoemail = (EditText) findViewById(R.id.edit_useremail);
        EditText novocpf = (EditText) findViewById(R.id.edit_CPF);
        EditText novophone = (EditText) findViewById(R.id.edit_phone);
        EditText novasenha = (EditText) findViewById(R.id.edit_senha);
        EditText cnovasenha = (EditText) findViewById(R.id.edit_senha2);
        EditText senhaatual = (EditText) findViewById(R.id.edit_senhaatual);
        NovoNome = novonome.getText().toString();
        NovoEmail = novoemail.getText().toString();
        NovoCPF = novocpf.getText().toString();
        NovoPhone = novophone.getText().toString();
        NovaSenha = novasenha.getText().toString();
        ConfirmaNovaSenha = cnovasenha.getText().toString();
        SenhaAtual = senhaatual.getText().toString();
    }
    private void ValidarDados(){
        boolean erro = false;
        int index = Database.clientes.indexOf(cliente);
        if(NovoNome.isEmpty() && NovoEmail.isEmpty() && NovoCPF.isEmpty() && NovoPhone.isEmpty() &&
                NovaSenha.isEmpty()){
            erro = true;
        }
        if(!NovoNome.isEmpty()){
            novoCliente.setNome(NovoNome);
        }if(!NovoEmail.isEmpty()){
            novoCliente.setEmail(NovoEmail);
        }if(!NovoCPF.isEmpty()){
            novoCliente.setCpf(NovoCPF);
        }
        if(!NovoPhone.isEmpty()){
            novoCliente.setTelefone(NovoPhone);
        }if(!NovaSenha.isEmpty()){
            if(SenhaAtual.equals(novoCliente.getSenha())){
                if(NovaSenha.equals(ConfirmaNovaSenha)){
                    novoCliente.setSenha(NovaSenha);
                }
                else{
                    error.setText("Novas senhas devem ser iguais!");
                    erro = true;
                }
            }
            else{
                error.setText("Senha atual incorreta");
                erro = true;
            }
        }
        if(!erro){
            ArrayList<Cliente> clientes = Database.getClientes();
            clientes.add(index, novoCliente);
            Database.setClientes(clientes);
            Intent intent = new Intent(TelaEditPerfilCliente.this, TelaPrincipalCliente.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            LoginAtual.setCliente(novoCliente);
            Toast.makeText(getApplicationContext(),"Dados Alterados!",Toast.LENGTH_SHORT).show();
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(TelaEditPerfilCliente.this, TelaPrincipalCliente.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }
}
