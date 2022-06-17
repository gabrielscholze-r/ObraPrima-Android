package com.example.meuapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.meuapp.R;
import com.example.meuapp.data.Profissional;

import java.util.ArrayList;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder> {
    private ArrayList<Profissional> profissionais;
    private RecyclerViewClickListener listener;

    public RecycleAdapter(ArrayList<Profissional> profissionais, RecyclerViewClickListener listener) {
        this.profissionais = profissionais;
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
    public RecycleAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_pro, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleAdapter.MyViewHolder holder, int position) {

        String text = profissionais.get(position).getNome() + " " + profissionais.get(position).getRamo() + " " + profissionais.get(position).getRating();
        holder.nameText.setText(text);

    }

    @Override
    public int getItemCount() {
        return profissionais.size();
    }

    public interface RecyclerViewClickListener{
        void onClick(View v, int position);
    }
}
