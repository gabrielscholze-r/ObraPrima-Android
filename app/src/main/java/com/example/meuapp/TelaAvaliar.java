package com.example.meuapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.meuapp.data.Database;
import com.example.meuapp.data.Pedidos;
import com.example.meuapp.data.Perfil;

import java.util.Queue;

public class TelaAvaliar extends AppCompatActivity {
    private Pedidos p;
    private Spinner dropbox;
    private Button avaliar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitvity_avaliar_pedido);
        getSupportActionBar().hide();

        TextView titulo = findViewById(R.id.titulo_pedido2);
        TextView tipo_pedido = findViewById(R.id.tipo_pedido2);
        TextView nome_profissional = findViewById(R.id.nome_profissional3);
        TextView data = findViewById(R.id.data_pedido2);
        TextView description = findViewById(R.id.desc_pedido2);
        dropbox = (Spinner) findViewById(R.id.spinner_nota);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.evaluate_array, R.layout.spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropbox.setAdapter(adapter);
        avaliar = findViewById(R.id.bt_enviar_avaliacao);
        ImageView button_voltar_avaliar = findViewById(R.id.button_voltar_avaliar);

        p = Perfil.getPedido();
        titulo.setText(p.getTituloPedido());

        nome_profissional.setText("Profissional: "+Database.findProfissionalByEmail(p.getEmailProfissional()).getNome());
        tipo_pedido.setText(p.getTipoServiço());
        data.setText("Data Prevista: "+p.getDia() + "/" + p.getMes());
        description.setText(p.getDescricao());

        button_voltar_avaliar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaAvaliar.this,TelaServicosCliente.class);
                startActivity(intent);
                finish();
            }
        });


        avaliar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double nota = Double.parseDouble(dropbox.getSelectedItem().toString());
                p.setRating(nota);
                Toast.makeText(getApplicationContext(), "PEDIDO AVALIADO!", Toast.LENGTH_SHORT).show();
                Database.updateRating(p.getEmailProfissional());
                Intent intent = new Intent(TelaAvaliar.this,TelaServicosCliente.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(TelaAvaliar.this,TelaServicosCliente.class);
        startActivity(intent);
        finish();
    }
}
