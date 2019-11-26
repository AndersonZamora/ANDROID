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

import java.util.List;

public class AnimeAdapter extends RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder> {

    List<Anime> data;
    int count = 0;

    private AnimeActivity activity;

    public AnimeAdapter(List<Anime> data, AnimeActivity activity) {
        this.data = data;
        this.activity = activity;
    }

    @NonNull
    @Override
    public AnimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.custom_view,parent,false);

        AnimeViewHolder viewHolder = new AnimeViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AnimeViewHolder holder,final int position) {

        TextView tvName = holder.itemView.findViewById(R.id.tvName);
        TextView tvEpisodios = holder.itemView.findViewById(R.id.tvEpisodios);
        ImageView imageView = holder.itemView.findViewById(R.id.imageView2);

        Button btnIr = holder.itemView.findViewById(R.id.btnIr);

        final ImageView star = holder.itemView.findViewById(R.id.imageViewStar);
        final Anime anime = data.get(position);

        tvName.setText(anime.nombre);
        tvEpisodios.setText(String.valueOf(anime.episodios.size()));
        imageView.setImageResource(anime.imagen);

        if (anime.estado)
            star.setImageResource(R.drawable.ic_launcher_estrella2);//Golden
        else
            star.setImageResource(R.drawable.ic_launcher_estrella1);// star

        star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (anime.estado){
                    count--;
                    star.setImageResource(R.drawable.ic_launcher_estrella1);
                    anime.estado = false;
                }
                else if (!anime.estado && count < 5){
                    count++;
                    star.setImageResource(R.drawable.ic_launcher_estrella2);
                    anime.estado = true;
                }
            }
        });
        btnIr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();

                Intent intent = new Intent(context, EpisodioActivity.class);
                intent.putExtra("POSITION",position);
                intent.putExtra("url",anime.url);
                activity.startActivity(intent);
            }
        });
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
