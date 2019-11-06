package com.example.contactos.Adaptar;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.view.LayoutInflaterCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactos.Contactos;
import com.example.contactos.Entidades.Persona;
import com.example.contactos.Pricipal;
import com.example.contactos.R;

import java.util.ArrayList;
import java.util.List;

public class NameAdapter extends RecyclerView.Adapter<NameAdapter.NameViewHolder> {


    List<Persona> datos;

    public NameAdapter(List<Persona> datos){
        this.datos = datos;

    }

    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());


        View view2 = inflater.inflate(R.layout.contactos, parent, false);
        NameViewHolder viewHolder1  = new NameViewHolder(view2);

        return viewHolder1;

    }
    @Override
    public void onBindViewHolder(@NonNull NameViewHolder holder, int position) {

        TextView tvName = holder.itemView.findViewById(R.id.tvName);
        TextView tvNumero = holder.itemView.findViewById(R.id.tvNumero);

        Persona valor = datos.get(position);
        tvName.setText(valor.getNombre());
        tvNumero.setText(valor.getNumero());
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public static class NameViewHolder extends RecyclerView.ViewHolder{

        public NameViewHolder(@NonNull View itemView) {
            super(itemView);
        }

    }

}
