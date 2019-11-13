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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.recyclerview.Adapter.CarAdapter;
import com.example.recyclerview.Entidades.Album;
import com.example.recyclerview.Entidades.Animes;
import com.example.recyclerview.Entidades.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Animes> listaAnimes;
    int [] anime = {
        R.drawable.ic_launche_name1,
        R.drawable.ic_lauche_name2,
        R.drawable.ic_launche_name3

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RequestQueue queue = Volley.newRequestQueue(this); //
        String url = "http://www.mocky.io/v2/5dcc05ea54000054009c2070";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("Main",response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(stringRequest);


/*
        RecyclerView recyclerViewNames = findViewById(R.id.carId);
        recyclerViewNames.setHasFixedSize(true);

        LinearLayoutManager linearManager = new  LinearLayoutManager(getApplicationContext());
        recyclerViewNames.setLayoutManager(linearManager);

        List<Animes> data = Animes();

        CarAdapter carAdapter = new CarAdapter(data);

        recyclerViewNames.setAdapter(carAdapter);*/

    }
    public List<Animes> Animes(){
        listaAnimes = new ArrayList<>();
        listaAnimes.add(new Animes("Naturo","Espisodio: "+2,anime[0]));
        listaAnimes.add(new Animes("Pokemon","Espisodio: "+3,anime[1]));
        listaAnimes.add(new Animes("attack on titan","Espisodio: "+3,anime[2]));

        return  listaAnimes;
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
