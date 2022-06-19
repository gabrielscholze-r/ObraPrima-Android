package com.example.meuapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.meuapp.adapter.RecycleAdapter;
import com.example.meuapp.data.Database;
import com.example.meuapp.data.LoginAtual;
import com.example.meuapp.data.Pedidos;
import com.example.meuapp.data.Profissional;

import org.w3c.dom.Text;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class TelaPrincipalCliente extends AppCompatActivity {

    private Button bt_deslogar;
    private Button bt_historico;
    private Button bt_contratar1;
    private Button bt_contratar2;
    private Button bt_contratar3;
    private Button bt_lista_pro;
    private int x,y,z;
    private String ClienteNome;
    private ArrayList<Profissional> profissionais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal_cliente);
        getSupportActionBar().hide();
        IniciarComponentes();
        profissionais = Database.getProfissionais();
        LoginAtual loginAtual = Database.getLoginAtual();
        ArrayList<String> views = new ArrayList<>();
        TextView titulo = findViewById(R.id.textTitulo);
        titulo.setText("Bem vindo "+loginAtual.getCliente().getNome()+"!");

        bt_deslogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaPrincipalCliente.this, FormLogin.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                LoginAtual l = new LoginAtual();
                Database.setLoginAtual(l);
                startActivity(intent);
                finish();
            }

        });
        bt_historico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaPrincipalCliente.this, TelaServicosCliente.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
                startActivity(intent);
            }

        });
        bt_lista_pro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaPrincipalCliente.this, TelaListaProfissionais.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
                startActivity(intent);
            }
        });
    }



    private void IniciarComponentes(){
        bt_deslogar = findViewById(R.id.bt_deslogar);
        bt_historico = findViewById(R.id.bt_historico2);
        bt_lista_pro = findViewById(R.id.bt_lista_pro);
//        bt_contratar1 = findViewById(R.id.bt_Contratar1);
//        bt_contratar2 = findViewById(R.id.bt_Contratar2);
//        bt_contratar3 = findViewById(R.id.bt_Contratar3);
    }
}