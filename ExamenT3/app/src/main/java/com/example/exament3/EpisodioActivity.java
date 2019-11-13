package com.example.exament3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.exament3.adapters.EpisodioAdapter;
import com.example.exament3.data.Data;
import com.example.exament3.entities.Episodio;

import java.util.List;

public class EpisodioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_episodio);

            int positon = getIntent().getIntExtra("POSITION",0);

            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

            List<Episodio> episodios = Data.getAnimes().get(positon).episodios;

            RecyclerView recyclerView = findViewById(R.id.carIdEpi);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(new EpisodioAdapter(episodios));
    }
}
