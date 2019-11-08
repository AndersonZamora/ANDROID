package com.example.entrenadores.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.entrenadores.Entidades.Pokemones;
import com.example.entrenadores.R;

import java.util.List;

public class AdapterView2 extends RecyclerView.Adapter<AdapterView2.NameViewHolder>
        implements View.OnClickListener{

    List<Pokemones> data;

    public AdapterView2(List<Pokemones> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.lista2,parent,false);

        NameViewHolder nameViewHolder1 = new NameViewHolder(view);

       // view.OnClickListener(this);

        return  nameViewHolder1;


    }

    @Override
    public void onBindViewHolder(@NonNull NameViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public void onClick(View view) {

      //  Context context = new view.getContext();

    }

    public class NameViewHolder extends  RecyclerView.ViewHolder {
        public NameViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
