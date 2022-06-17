package com.example.meuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

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
    private int x,y,z;
    private ListView listView;
    private String ClienteNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal_cliente);
        x = 0;
        y = 0;
        z = 0;

        getSupportActionBar().hide();
        IniciarComponentes();
        ArrayList<Profissional> profissionais = Database.getProfissionais();
        LoginAtual loginAtual = Database.getLoginAtual();
        ClienteNome = loginAtual.getCliente().getNome();
        ArrayList<String> views = new ArrayList<>();
        listView = findViewById(R.id.listPro);
        listView.setBackgroundResource(R.drawable.custom_shape);

        listView.setOnTouchListener(new ListView.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        // Disallow ScrollView to intercept touch events.
                        v.getParent().requestDisallowInterceptTouchEvent(true);
                        break;

                    case MotionEvent.ACTION_UP:
                        // Allow ScrollView to intercept touch events.
                        v.getParent().requestDisallowInterceptTouchEvent(false);
                        break;
                }

                // Handle ListView touch events.
                v.onTouchEvent(event);
                return true;
            }
        });

        for (Profissional p : profissionais){
            String n = p.getNome() + " - "+p.getRamo() + " - " + p.getRating();
            views.add(n);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_pro,views);
        listView.setAdapter(adapter);


        TextView titulo = findViewById(R.id.textTitulo);
        titulo.setText("Bem vindo\n"+loginAtual.getCliente().getNome()+"!");

        bt_deslogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaPrincipalCliente.this, FormLogin.class);
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
                startActivity(intent);
                finish();
            }

        });


//        bt_contratar1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                if(x < 1){
////                    ArrayList<Pedidos> pedidos =  profissionais.get(0).getPedidos();
////                    pedidos.add(new Pedidos("18","05","Visita tecnica", loginAtual.getCliente().getNome()));
////                    et1.setText("Pedido Feito!");
////                    x++;
////                }
//            }
//
//        });

//        bt_contratar2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                if(y < 1){
////                    ArrayList<Pedidos> pedidos =  profissionais.get(1).getPedidos();
////                    pedidos.add(new Pedidos("18","05","Visita tecnica", loginAtual.getCliente().getNome()));
////                    et3.setText("Pedido Feito!");
////                    y++;
////                }
//            }
//
//        });

//        bt_contratar3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(z < 1){
//                    ArrayList<Pedidos> pedidos =  profissionais.get(2).getPedidos();
//                    pedidos.add(new Pedidos("18","05","Visita tecnica", loginAtual.getCliente().getNome()));
//                    et2.setText("Pedido Feito!");
//                    z++;
//                }
//            }
//
//        });
    }


    public void adicionarPedido(TextView v){
        LocalDate date = LocalDate.now();
        ArrayList<Profissional> profissionais = Database.getProfissionais();
        String t = v.getText().toString();
        String[] splitted = t.split(" ");
        for (Profissional p : profissionais){
            if(p.getNome().equals(splitted[0])){
                ArrayList<Pedidos> p2 = p.getPedidos();
                p2.add(new Pedidos(date.getDayOfMonth(),date.getMonth().toString(),"Visita Tecnica",ClienteNome));
            }
        }
    }
    private void IniciarComponentes(){
        bt_deslogar = findViewById(R.id.bt_deslogar);
        bt_historico = findViewById(R.id.bt_historico);
//        bt_contratar1 = findViewById(R.id.bt_Contratar1);
//        bt_contratar2 = findViewById(R.id.bt_Contratar2);
//        bt_contratar3 = findViewById(R.id.bt_Contratar3);
    }
}