package com.example.meuapp;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.meuapp.data.Database;
import com.example.meuapp.data.LoginAtual;
import com.example.meuapp.data.Pedidos;
import com.example.meuapp.data.Perfil;
import com.example.meuapp.data.Profissional;

import java.time.LocalDate;
import java.util.ArrayList;

public class TelaPerfilProfissional extends AppCompatActivity {
    private LoginAtual loginAtual;
    private ArrayList<Profissional> profissionais;
    private Profissional profissional;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_perfil_profissional);
        getSupportActionBar().hide();
        loginAtual = Database.getLoginAtual();
        profissionais = Database.getProfissionais();
        profissional = Perfil.getProfissional();


        TextView nome_pro = findViewById(R.id.nome_pro);
        nome_pro.setText(profissional.getNome());

        TextView profissao = findViewById(R.id.profissao_pro);
        profissao.setText(profissional.getRamo());

        TextView bio = findViewById(R.id.pro_bio);
        bio.setText(profissional.getBio());

        TextView rating = findViewById(R.id.pro_rating);
        rating.setText(profissional.getRating()+"");

        ImageView bt_voltar = findViewById(R.id.bt_voltar5);
        Button bt_contratar = findViewById(R.id.bt_contratar);
        bt_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        bt_contratar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int index = Database.getProfissionais().indexOf(profissional);
                ArrayList<Pedidos> pedidos = profissional.getPedidos();
                LocalDate d = LocalDate.now();
                pedidos.add(new Pedidos(d.getDayOfMonth(), d.getMonth().toString(), "Visita Tecnica",profissional.getRamo(), loginAtual.getCliente().getNome()
                        , profissional.getNome(), "Realizar Orçamento"));
//                profissionais.remove(profissional);
                profissional.setPedidos(pedidos);
                profissionais.add(index, profissional);
                Database.setProfissionais(profissionais);
                Intent intent = new Intent(TelaPerfilProfissional.this, TelaPrincipalCliente.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                Toast.makeText(getApplicationContext(),"PEDIDO REALIZADO!",Toast.LENGTH_LONG).show();
                startActivity(intent);
                finish();

            }
        });
    }
}
