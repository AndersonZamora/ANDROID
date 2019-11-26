package com.example.contactosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.contactosapp.Entidades.Contacto;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

public class Agregar extends AppCompatActivity {

    private EditText nombre;
    private EditText telefono;
    private EditText correo;
    private Button guardar;

    private String nombreC;
    private String telefonC;
    private String correoC;
    private static String url = "https://webhook.site/94dfdcf0-2c98-49fd-98c1-939789f8398e";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);
        ObtenerID();
        final Contacto contacto = new Contacto();
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ObtenerInfofacionCrud();

                contacto.nombre = nombreC;
                contacto.phone = telefonC;
                contacto.email = correoC;

                String jsonString = new Gson().toJson(contacto);

                Log.e("Formato",jsonString);

                RequestQueue queue = Volley.newRequestQueue(Agregar.this);
                try {
                    JSONObject objJson = new JSONObject(jsonString);
                    JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, objJson, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            Log.e("Todo","Ok");

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            error.getMessage();
                        }
                    });
                    queue.add(request);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Toast.makeText(getApplicationContext(),"Se Guardo "+nombreC,Toast.LENGTH_SHORT).show();
            }

        });
    }
    private void ObtenerID(){
        nombre = findViewById(R.id.posNombre);
        telefono = findViewById(R.id.posTelefono);
        correo = findViewById(R.id.posEmail);
        guardar = findViewById(R.id.btnGuardar);
    }
    private  void ObtenerInfofacionCrud(){

        nombreC = nombre.getText().toString();
        telefonC = telefono.getText().toString();
        correoC = correo.getText().toString();

        Log.e("Nombre",nombreC);
        Log.e("Telefon",telefonC);
        Log.e("Correo",correoC);
    }
}
