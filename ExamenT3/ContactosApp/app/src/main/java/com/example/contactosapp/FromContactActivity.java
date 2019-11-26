package com.example.contactosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.contactosapp.Entidades.Contacto;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class FromContactActivity extends AppCompatActivity {

    private  static  String url = "http://webhook.site/94dfdcf0-2c98-49fd-98c1-939789f8398e";
    private Button btnEnviar;
    private EditText texto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from_contact);

        Contacto contacto = new Contacto();
        contacto.nombre = "CORLA";
        contacto.phone = "940047330";
        ObtenerId();
        String jsonString = new Gson().toJson(contacto);


        //JSONObject datajon = new JSONObject(jsonString);

        final String data = "{\"name\": \"anderson\"}"; //String con formato jgon


        RequestQueue queue = Volley.newRequestQueue(this);
        Log.d("Data",data);
        try {
            JSONObject objJson = new JSONObject(jsonString);
            //objJson.put("Zamonra","Anderson");
            //objJson.put("Coral","Anderson");
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, objJson, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    Log.d("Todo","OK");
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }){
                @Override
                public Map<String,String> getHeaders() throws AuthFailureError{
                    Map<String,String> header = new HashMap<>();
                    header.put("Accept","aplication/json");
                    return header;
                }
            };
            queue.add(request);
        } catch (JSONException ex) {
            Log.e("Fallo",ex.getMessage());
        }
    }
    public  void ObtenerId(){
        btnEnviar = findViewById(R.id.btnEnviar);
        texto = findViewById(R.id.editText);
    }
}
