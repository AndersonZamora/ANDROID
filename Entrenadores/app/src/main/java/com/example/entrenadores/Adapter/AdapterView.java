package com.example.entrenadores.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.entrenadores.Entidades.Entrenadores;
import com.example.entrenadores.ListaPokemon;
import com.example.entrenadores.R;

import java.util.List;


public class AdapterView extends RecyclerView.Adapter<AdapterView.NameViewHolder>
        implements View.OnClickListener{

    private List<Entrenadores> data;

    public AdapterView(List<Entrenadores> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.lista1,parent,false);

        NameViewHolder viewHolder1 = new NameViewHolder(view);

        view.setOnClickListener(this);

        return viewHolder1;
    }

    @Override
    public void onBindViewHolder(@NonNull NameViewHolder holder, int position) {
        TextView nombre  = holder.itemView.findViewById(R.id.textNombre);
        TextView medalla = holder.itemView.findViewById(R.id.textMedalla);
        TextView pokemon = holder.itemView.findViewById(R.id.textPokemon);

        Button btnPokemon = holder.itemView.findViewById(R.id.btnPokemon);

        Entrenadores valor =data.get(position);

        nombre.setText(valor.getNombre());
        medalla.setText(valor.getMedallas());
        pokemon.setText(valor.getPokemones());

        btnPokemon.setOnClickListener(this);


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onClick(View view) {

        Context context = view.getContext();
        Intent intent;
        switch (view.getId()){

            case R.id.btnPokemon:
                    intent = new Intent(context, ListaPokemon.class);
                    context.startActivity(intent);
            break;
        }
    }

    public class NameViewHolder extends RecyclerView.ViewHolder {
        public NameViewHolder(@NonNull View itemView) {
            super(itemView);
        }

    }
}
