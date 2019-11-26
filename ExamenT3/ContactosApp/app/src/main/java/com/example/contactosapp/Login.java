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
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.contactosapp.Entidades.Usuario;
import com.google.gson.Gson;

public class Login extends AppCompatActivity {

    private EditText usuarioF;
    private EditText contraseniaaF;
    private Button ingresar;
    private Usuario usuario;
    private  String user;
    private  String pass;
    private RequestQueue queue;
    private StringRequest stringRequest;
    private static String url = "http://www.mocky.io/v2/5ddc1c6f3400004f00eae178";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ObenerId();
        obetnerDatosGET();
    }
    public void obetnerDatosGET(){
        queue = Volley.newRequestQueue(this);
        stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                usuario = gson.fromJson(response, Usuario.class);
                Logeo(usuario);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(stringRequest);
    }
    public void Logeo(final Usuario usuario){

        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Contenido();
                    boolean estado = Validacion();
                    if (estado == true)
                        startActivity(new Intent(Login.this,MainActivity.class));
            }
        });
    }
    public  void ObenerId(){
        usuarioF = findViewById(R.id.usuario);
        contraseniaaF = findViewById(R.id.contrasenia);
        ingresar = findViewById(R.id.btnIngresar);
    }
    public void Contenido(){
        user = usuarioF.getText().toString();
        pass = contraseniaaF.getText().toString();
        Log.e("Usuario Obtenido",user);
        Log.e("Contraseña Obtenida",pass);
    }
    public boolean Validacion(){
        if (user.equals(usuario.usuario) && pass.equals(usuario.contrasenia)){
            Toast.makeText(getApplicationContext(),"Vienvenido "+usuario.usuario,Toast.LENGTH_SHORT).show();
            return true;
        }else
            Toast.makeText(getApplicationContext(),"Usuario o Contraseña Incorrecta",Toast.LENGTH_SHORT).show();
        return false;
    }
}
