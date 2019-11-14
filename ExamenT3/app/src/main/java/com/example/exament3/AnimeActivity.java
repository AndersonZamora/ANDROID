package com.example.exament3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.exament3.adapters.AnimeAdapter;
import com.example.exament3.data.Data;
import com.example.exament3.entities.Anime;
import com.google.gson.Gson;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnimeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime);
        final RecyclerView recyclerViewNames = findViewById(R.id.carId);


        final LinearLayoutManager linearManager = new LinearLayoutManager(this);
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://www.mocky.io/v2/5dcd56242e00006700729dfa";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("Main",response); //Aqui ya tengo los datos (url)

                Gson gson = new Gson();
               // gson.fromJson(response,Anime.class);

                List<Anime> animes = Arrays.asList(gson.fromJson(response, Anime[].class));

               // List<Anime> animes = Data.getAnimes();

                recyclerViewNames.setLayoutManager(linearManager);
                recyclerViewNames.setHasFixedSize(true);
                recyclerViewNames.setAdapter(new AnimeAdapter(animes,AnimeActivity.this));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(stringRequest);


    }
}
