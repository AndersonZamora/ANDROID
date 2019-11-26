package com.example.contactosapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.contactosapp.Adapter.Adapter;
import com.example.contactosapp.Entidades.Contacto;
import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private int permisoLlamar =  1;
    private int permisomensaje =  2;
    private ImageButton agregar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerViewNames = findViewById(R.id.carId); //Final No cambiar
        final LinearLayoutManager linearManager = new LinearLayoutManager(this);

        RequestQueue queue = Volley.newRequestQueue(this);

        String url = "http://www.mocky.io/v2/5dd53cde3300006e00f37fa7";
       // PermisoLlamar();
      //  PermisoMensaje();
        ObetnerId();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                Log.d("Main",response);

                List<Contacto> contactos = Arrays.asList(gson.fromJson(response,Contacto[].class));
                recyclerViewNames.setLayoutManager(linearManager);
                recyclerViewNames.setHasFixedSize(true);
                recyclerViewNames.setAdapter(new Adapter(contactos));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(stringRequest);
        MetodoAgregar();
    }
    private void PermisoLlamar(){
        ActivityCompat.requestPermissions(MainActivity.this,
                new String[]{Manifest.permission.CALL_PHONE},permisoLlamar);
    }
    private void PermisoMensaje(){
        ActivityCompat.requestPermissions(MainActivity.this,
                new String[]{Manifest.permission.SEND_SMS},permisomensaje);
    }
    public  void MetodoAgregar(){
        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("Clic","Boton Agregar");
                startActivity(new Intent(MainActivity.this,Agregar.class));
            }
        });
    }
    public void ObetnerId(){
        agregar = findViewById(R.id.btnAgregar);
    }
}
