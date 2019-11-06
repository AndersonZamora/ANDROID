package com.example.recyclerview;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.icu.text.StringPrepParseException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.recyclerview.Adapter.CarAdapter;
import com.example.recyclerview.Entidades.Album;
import com.example.recyclerview.Entidades.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    public MainActivity() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView recyclerViewNames = findViewById(R.id.carId);
        recyclerViewNames.setHasFixedSize(true);

        LinearLayoutManager linearManager = new  LinearLayoutManager(getApplicationContext());
        recyclerViewNames.setLayoutManager(linearManager);

        List<Album> data = ListaDeCanciones();

        CarAdapter carAdapter = new CarAdapter(data);

        /*
        carAdapter.setOnclickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),Cancion.class);

                startActivity(intent);
            }
        });

         */

        recyclerViewNames.setAdapter(carAdapter);

    }
    private List<Pelicula> ListaPeliculas(){

        List<Pelicula> peliculas = new ArrayList<>();

        Pelicula pelicula1 = new Pelicula("Avengers","La tetralogía de Los Vengadores es una franquicia de cuatro películas que se inició en el año 2012 con la película The Avengers y finalizó con Avengers");

        Pelicula pelicula2 = new Pelicula("Transformers","Transformers es una película de acción y ciencia ficción estadounidense de 2007 basada en la línea de juguetes de Transformers.");

        peliculas.add(pelicula1);
        peliculas.add(pelicula2);

        return  peliculas;
    }
    private List<Album> ListaDeCanciones(){
        List<Album> albums = new ArrayList<>();

        Album album1 = new Album("Sing For The Moment","Eminem","1");
        Album album2 = new Album("Love Me Again","John Newman","2");
        Album album3 = new Album("Kygo ft. Parson James","Stole The Show","3");
        Album album4 = new Album("White Flag","Dido","4");
        Album album5 = new Album("Julian Casablancas","Daft Punk ft","5");


        albums.add(album1);
        albums.add(album2);
        albums.add(album3);
        albums.add(album4);
        albums.add(album5);
        return  albums;
    }

    private void setupIniciar(Button btIniciar){
        btIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),Cancion.class);

                startActivity(intent);
            }
        });
    }
}
