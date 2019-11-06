package com.example.rutas.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rutas.Entidades.Fruta;
import com.example.rutas.R;

import java.util.List;

public class NameAdapter  extends RecyclerView.Adapter<NameAdapter.NameViewHolder> {

    List<Fruta> frutas;

    public  NameAdapter(List<Fruta> frutas){
        this.frutas = frutas;
    }

    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.frutas,parent,false);

        NameViewHolder viewHolder = new NameViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NameViewHolder holder, int position) {

        TextView tvNombre = holder.itemView.findViewById(R.id.tvNombre);
        TextView tvVitanminas = holder.itemView.findViewById(R.id.tvVitanminas);

        Fruta valor = frutas.get(position);

        tvNombre.setText(valor.getNombre());
        tvVitanminas.setText(valor.getVitaminas());
    }

    @Override
    public int getItemCount() {
        return frutas.size();
    }

    public static class NameViewHolder extends RecyclerView.ViewHolder {

        public NameViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }

}
