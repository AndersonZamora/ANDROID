package com.example.exament3.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exament3.AnimeActivity;
import com.example.exament3.EpisodioActivity;
import com.example.exament3.R;
import com.example.exament3.entities.Anime;
import com.example.exament3.entities.Episodio;

import java.util.List;

public class EpisodioAdapter extends RecyclerView.Adapter<EpisodioAdapter.AnimeViewHolder> {

    List<Episodio> data;

    public EpisodioAdapter(List<Episodio> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public AnimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.custom_view2,parent,false);

        AnimeViewHolder viewHolder = new AnimeViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AnimeViewHolder holder, int position) {

        TextView tvName = holder.itemView.findViewById(R.id.tvName);
        TextView tvDescripcion = holder.itemView.findViewById(R.id.tvDescripcion);
        ImageView imageView2 = holder.itemView.findViewById(R.id.imageView2);


        Episodio episodio = data.get(position);

        tvName.setText(episodio.titulo);
        tvDescripcion.setText(episodio.descripcion);
        imageView2.setImageResource(episodio.imagen);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class AnimeViewHolder extends RecyclerView.ViewHolder{

        public AnimeViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
