package com.example.meuapp;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
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
        loginAtual = new LoginAtual();
        profissionais = Database.getProfissionais();
        profissional = Perfil.getProfissional();

        Spinner day = (Spinner) findViewById(R.id.spinner_day);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.day_array, R.layout.spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        day.setAdapter(adapter);

        Spinner month = (Spinner) findViewById(R.id.spinner_month);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.month_array, R.layout.spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        month.setAdapter(adapter2);

        TextView pro_phone = findViewById(R.id.pro_phone);
        pro_phone.setText("Telefone: "+profissional.getTelefone());
        EditText edit_desc_job = (EditText) findViewById(R.id.edit_desc_job);
        TextView nome_pro = findViewById(R.id.nome_pro);
        nome_pro.setText(profissional.getNome());
        TextView text_price = findViewById(R.id.text_price);
        text_price.setText("Preço: R$"+profissional.getPrice());

        TextView profissao = findViewById(R.id.profissao_pro);
        profissao.setText(profissional.getRamo());
        TextView error_text = findViewById(R.id.error_text);
        TextView bio = findViewById(R.id.pro_bio);
        bio.setText(profissional.getBio());

        TextView rating = findViewById(R.id.pro_rating);
        rating.setText(profissional.getRating()+"");

        ImageView bt_voltar = findViewById(R.id.bt_voltar5);
        Button bt_contratar = findViewById(R.id.bt_contratar);
        bt_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaPerfilProfissional.this,TelaListaProfissionais.class);
                startActivity(intent);
                finish();
            }
        });

        bt_contratar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int dia = Integer.parseInt(day.getSelectedItem().toString());
                int mes = Integer.parseInt(month.getSelectedItem().toString());
                if(edit_desc_job.getText().length()==0){
                    error_text.setText("INSIRA UMA DESCRIÇÃO");
                }else{
                    error_text.setText("");
                    LocalDate d = LocalDate.now();
                    if((mes>d.getMonth().getValue()) || (mes==d.getMonth().getValue() && dia>=d.getDayOfMonth())){
                        profissional.getPedidos().add(new Pedidos(dia, mes, "Visita Tecnica",profissional.getRamo(), loginAtual.getCliente().getNome()
                                , profissional.getNome(), edit_desc_job.getText().toString(), 0, profissional.getPrice(),loginAtual.getCliente().getEmail(),profissional.getEmail()));
                    }
                    else{
                        profissional.getPedidos().add(new Pedidos(d.getDayOfMonth(), d.getMonth().getValue(), "Visita Tecnica",profissional.getRamo(), loginAtual.getCliente().getNome()
                                , profissional.getNome(), edit_desc_job.getText().toString(), 0,profissional.getPrice(),loginAtual.getCliente().getEmail(),profissional.getEmail()));
                    }
                    Intent intent = new Intent(TelaPerfilProfissional.this, TelaPrincipalCliente.class);

                    Toast.makeText(getApplicationContext(),"PEDIDO REALIZADO!",Toast.LENGTH_LONG).show();
                    startActivity(intent);
                    finish();
                }


            }
        });
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        Intent intent = new Intent(TelaPerfilProfissional.this, TelaListaProfissionais.class);
        startActivity(intent);
        finish();
    }
}
