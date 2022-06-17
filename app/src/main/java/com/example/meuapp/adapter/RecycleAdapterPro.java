package com.example.meuapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.meuapp.R;
import com.example.meuapp.data.Pedidos;
import com.example.meuapp.data.Profissional;

import java.util.ArrayList;

public class RecycleAdapterPro extends RecyclerView.Adapter<RecycleAdapterPro.MyViewHolder> {
    private ArrayList<Pedidos> pedidos;

    public RecycleAdapterPro(ArrayList<Pedidos> pedidos) {
        this.pedidos = pedidos;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView nameText;
        public MyViewHolder(final View view) {
            super(view);
            nameText = view.findViewById(R.id.profissional);
        }
    }

    @NonNull
    @Override
    public RecycleAdapterPro.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_pro, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleAdapterPro.MyViewHolder holder, int position) {
        String text = pedidos.get(position).getNomeCliente() + " - " + pedidos.get(position).getTituloPedido() + " - " + pedidos.get(position).getDia()+"/"+pedidos.get(position).getMes();
        holder.nameText.setText(text);

    }

    @Override
    public int getItemCount() {
        return pedidos.size();
    }

}
