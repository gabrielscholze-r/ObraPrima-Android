package com.example.meuapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.meuapp.R;
import com.example.meuapp.data.Database;
import com.example.meuapp.data.Pedidos;
import com.example.meuapp.data.Perfil;
import com.example.meuapp.data.Profissional;

import java.util.ArrayList;

public class RecycleAdapterPedidos extends RecyclerView.Adapter<RecycleAdapterPedidos.MyViewHolder> {
    private ArrayList<Pedidos> pedidos;
    private RecyclerViewClickListener listener;

    public RecycleAdapterPedidos(ArrayList<Pedidos> pedidos, RecyclerViewClickListener listener) {
        this.pedidos = pedidos;
        this.listener = listener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView nameText;
        public MyViewHolder(final View view) {
            super(view);
            nameText = view.findViewById(R.id.profissional);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onClick(view, getAdapterPosition());
        }
    }

    @NonNull
    @Override
    public RecycleAdapterPedidos.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_pro, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleAdapterPedidos.MyViewHolder holder, int position) {

        String text = "";
        if(Perfil.getId()==0){
            text = pedidos.get(position).getNomeCliente() + " - " + pedidos.get(position).getTituloPedido() + " - " + pedidos.get(position).getDia()+"/"+pedidos.get(position).getMes();

        }
        else{
            text = pedidos.get(position).getNomeProfissional() + " - " + pedidos.get(position).getTituloPedido() + " - " + pedidos.get(position).getDia()+"/"+pedidos.get(position).getMes();

        }
        holder.nameText.setText(text);

    }

    @Override
    public int getItemCount() {
        return pedidos.size();
    }

    public interface RecyclerViewClickListener{
        void onClick(View v, int position);
    }
}
