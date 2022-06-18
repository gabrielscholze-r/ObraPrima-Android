package com.example.meuapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.meuapp.adapter.RecycleAdapter;
import com.example.meuapp.adapter.RecycleAdapterPedidos;
import com.example.meuapp.data.Database;
import com.example.meuapp.data.LoginAtual;
import com.example.meuapp.data.Pedidos;
import com.example.meuapp.data.Profissional;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

public class TelaServicosCliente extends AppCompatActivity {

    private Button bt_deslogar;
    private Button bt_home;
    private RecyclerView recyclerView;
    private RecycleAdapterPedidos.RecyclerViewClickListener listener;
    private ArrayList<Profissional> profissionais;
    private ArrayList<Pedidos> pd;
    private String nomeCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_servicos_cliente);
        IniciarComponentes();
        LoginAtual l = Database.getLoginAtual();
        pd = new ArrayList<>();
        nomeCliente = l.getCliente().getNome();
        profissionais = Database.getProfissionais();
        recyclerView = findViewById(R.id.recyclerView);
        TextView t = findViewById(R.id.textTitulo2);
        t.setText("Bem vindo " + l.getCliente().getNome()+"!");
        setAdapter();


        bt_deslogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaServicosCliente.this, FormLogin.class);
                LoginAtual l = new LoginAtual();
                Database.setLoginAtual(l);
                startActivity(intent);
                finish();
            }

        });
        bt_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaServicosCliente.this, TelaPrincipalCliente.class);
                startActivity(intent);
                finish();
            }

        } );

    }


    private void setAdapter() {
        setOnClickListener();
        ArrayList<Pedidos> pedidos = new ArrayList<>();
        for (Profissional p : profissionais){
            for(Pedidos p2 : p.getPedidos()){
                if(p2.getNomeCliente()==nomeCliente){
                    pedidos.add(p2);
                }
            }
        }
        pd = pedidos;
        RecycleAdapterPedidos adapter = new RecycleAdapterPedidos(pedidos, listener);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }
    private void setOnClickListener() {
        listener = new RecycleAdapterPedidos.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Pedidos pedido = pd.get(position);
                for (Profissional p : profissionais){
                    if(p.getNome()==pedido.getNomeProfissional()){
                        ArrayList<Pedidos> lp = p.getPedidos();
                        lp.remove(pedido);
                        p.setPedidos(lp);
                        break;
                    }
                }
                Database.setProfissionais(profissionais);
                Toast.makeText(getApplicationContext(),"PEDIDO EXCLUÍDO!",Toast.LENGTH_SHORT).show();
                setAdapter();
            }
        };

    }
    private void IniciarComponentes(){
        bt_deslogar = findViewById(R.id.bt_deslogar);
        bt_home = findViewById(R.id.button_home);
    }
}