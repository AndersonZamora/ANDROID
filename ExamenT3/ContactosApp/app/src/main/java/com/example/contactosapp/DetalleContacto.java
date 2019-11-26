package com.example.contactosapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.contactosapp.Entidades.Contacto;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

public class DetalleContacto extends AppCompatActivity {

    private TextView textView;
    private Contacto contacto;
    private ImageView img;
    private TextView textNumero;
    private TextView textEmail;
    private ImageButton btnLlmar1;
    private ImageButton imageButton8;
    private  ImageButton imageButton9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);
        String url = getIntent().getStringExtra("url");

        ObtenerId();

        RequestQueue que = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();

                Log.d("Main", response);

                contacto = gson.fromJson(response, Contacto.class);

                Log.d("Nombre", contacto.nombre);
                Log.d("Email", contacto.email);
                Log.d("Phone", contacto.phone);
                Log.d("URL", contacto.imagen);
                LlenarContacto();

                btnLlmar1.setOnClickListener(new View.OnClickListener() {
                    @SuppressLint("MissingPermission")
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + contacto.phone));

                        startActivity(intent);
                    }
                });
                imageButton9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_SEND);
                        intent.putExtra(intent.EXTRA_TEXT,"Holi");
                        intent.setType("text/plain");
                        Intent sahreIntet = Intent.createChooser(intent,null);
                        startActivity(sahreIntet);
                    }
                });
                imageButton8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto",contacto.email, null));
                        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Enviado desde Mi app");
                        startActivity(emailIntent);
                    }
                });
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        que.add(stringRequest);
    }

    private void LlenarContacto() {
        textView.setText(contacto.nombre);
        Picasso.get().load(contacto.imagen)
                .into(img);
        textNumero.setText(contacto.phone);
        textEmail.setText(contacto.email);
    }

    private void ObtenerId() {
        textView = findViewById(R.id.textView2);
        img = findViewById(R.id.imageView);
        textNumero = findViewById(R.id.textNumero);
        textEmail = findViewById(R.id.textEmail);
        btnLlmar1 = findViewById(R.id.btnLlmar1);
        imageButton8 = findViewById(R.id.imageButton8);
        imageButton9 = findViewById(R.id.imageButton9);
    }
}
