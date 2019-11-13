package com.example.exament3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.exament3.adapters.AnimeAdapter;
import com.example.exament3.data.Data;
import com.example.exament3.entities.Anime;

import java.util.List;

public class AnimeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime);
        RecyclerView recyclerViewNames = findViewById(R.id.carId);
        recyclerViewNames.setHasFixedSize(true);

        LinearLayoutManager linearManager = new LinearLayoutManager(this);

        List<Anime> animes = Data.getAnimes();

        recyclerViewNames.setLayoutManager(linearManager);
        recyclerViewNames.setAdapter(new AnimeAdapter(animes,this));
    }
}
