package com.example.contactosapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactosapp.DetalleContacto;
import com.example.contactosapp.Entidades.Contacto;
import com.example.contactosapp.MainActivity;
import com.example.contactosapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.contactoViewHolder> {

    List<Contacto> data;
    private View view;
    public Adapter(List<Contacto> data) {
        this.data = data;
    }
    private  ImageView picaso;
    @NonNull
    @Override
    public contactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        view = inflater.inflate(R.layout.custom_view,parent,false);
        contactoViewHolder contactoViewHolder = new contactoViewHolder(view);
        return contactoViewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull contactoViewHolder holder, int position) {
        TextView tvNombre = holder.itemView.findViewById(R.id.tvName);
        picaso = holder.itemView.findViewById(R.id.profile_image2);

        final Contacto contacto =data.get(position);

        tvNombre.setText(contacto.nombre);
        Picasso.get().load(contacto.imagen)
                .resize(200,200)
                .centerInside()
                .onlyScaleDown()
                .into(picaso);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context =view.getContext();

                Intent intent = new Intent(context, DetalleContacto.class);
                intent.putExtra("url",contacto.url);
                context.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class contactoViewHolder extends RecyclerView.ViewHolder{

        public contactoViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
