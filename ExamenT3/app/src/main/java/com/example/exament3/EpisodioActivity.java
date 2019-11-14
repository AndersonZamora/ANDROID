package com.example.exament3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.exament3.adapters.EpisodioAdapter;
import com.example.exament3.data.Data;
import com.example.exament3.entities.Episodio;
import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

public class EpisodioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_episodio);

           int positon = getIntent().getIntExtra("POSITION",0);
           String url = getIntent().getStringExtra("url");
           final RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
           final  RecyclerView recyclerView = findViewById(R.id.carIdEpi);
           RequestQueue queue = Volley.newRequestQueue(this);
          //  String url = "http://www.mocky.io/v2/5dcd56242e00006700729dfa";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                List<Episodio> episodios = Arrays.asList(gson.fromJson(response,Episodio[].class));
                        //Data.getAnimes().get(positon).episodios;
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setHasFixedSize(true);
                recyclerView.setAdapter(new EpisodioAdapter(episodios));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(stringRequest);
        //  List<Episodio> episodios = Data.getAnimes().get(positon).episodios;
    }
}
