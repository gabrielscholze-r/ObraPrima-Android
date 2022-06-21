package com.example.meuapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.meuapp.data.Database;
import com.example.meuapp.data.Pedidos;
import com.example.meuapp.data.Perfil;
import com.example.meuapp.data.Profissional;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class TelaPedido extends AppCompatActivity {
    private Pedidos p;
    private int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_pedido);
        getSupportActionBar().hide();
        id = Perfil.getId();
        ImageView bt_voltar3 = findViewById(R.id.button_back3);
        Button cancelar_pedido = findViewById(R.id.bt_cancelar);

        TextView titulo = findViewById(R.id.titulo_pedido);
        TextView tipo_pedido = findViewById(R.id.tipo_pedido);
        TextView nome_profissional = findViewById(R.id.nome_profissional);
        TextView data = findViewById(R.id.data_pedido);
        TextView description = findViewById(R.id.desc_pedido);

        p = Perfil.getPedido();
        titulo.setText(p.getTituloPedido());
        tipo_pedido.setText(p.getTipoServiço());
        if(Perfil.getId()==0){
            nome_profissional.setText("Cliente: " + p.getNomeCliente());
        }
        else{
            nome_profissional.setText("Profissional: " + p.getNomeProfissional());
        }

        data.setText("Data Prevista: "+p.getDia() + "/" + p.getMes());
        description.setText(p.getDescricao());


        bt_voltar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1= new Intent(TelaPedido.this, TelaServicosProfissional.class);
                Intent i2 = new Intent(TelaPedido.this,TelaServicosCliente.class);
                if(id==0){
                    startActivity(i1);
                    finish();
                }else{
                    startActivity(i2);
                    finish();
                }

            }
        });

        cancelar_pedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Profissional> profissionais = Database.getProfissionais();
                Profissional pro = Database.findProfissionalByName(p.getNomeProfissional());
                int index = profissionais.indexOf(pro);
                ArrayList<Pedidos> pedidos = pro.getPedidos();
                pedidos.remove(p);
                pro.setPedidos(pedidos);
//                profissionais.add(index, pro);
                Database.setProfissionais(profissionais);
                Toast.makeText(getApplicationContext(),"PEDIDO CANCELADO!",Toast.LENGTH_LONG).show();
                Intent i1= new Intent(TelaPedido.this, TelaServicosProfissional.class);
                Intent i2 = new Intent(TelaPedido.this,TelaServicosCliente.class);
                if(id==0){
                    startActivity(i1);

                }else{
                    startActivity(i2);
                }
                finish();
            }
        });


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(TelaPedido.this, TelaServicosProfissional.class);
        startActivity(intent);
        finish();
    }
}
