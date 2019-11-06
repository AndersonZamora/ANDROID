package com.example.inbox.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.inbox.Entidades.Mensajes;
import com.example.inbox.R;

import java.util.List;

public class AdapterImbox extends RecyclerView.Adapter<AdapterImbox.NameViewHolder> {

    private List<Mensajes> data;

    public AdapterImbox(List<Mensajes> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.item_imbox,parent,false);

        NameViewHolder viewHolder1 = new NameViewHolder(view);

        return viewHolder1;
    }

    @Override
    public void onBindViewHolder(@NonNull NameViewHolder holder, int position) {

        TextView textContacto = holder.itemView.findViewById(R.id.textContacto);
        TextView textDescripcion = holder.itemView.findViewById(R.id.textDescripcion);

        Mensajes datos = data.get(position);

         textContacto.setText(datos.getContacto());
         textDescripcion.setText(datos.getMensaje());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class NameViewHolder extends  RecyclerView.ViewHolder{

        public NameViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
