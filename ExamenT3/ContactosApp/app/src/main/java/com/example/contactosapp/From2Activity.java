package com.example.contactosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

public class From2Activity extends AppCompatActivity {

    private  static  String url = "https://webhook.site/94dfdcf0-2c98-49fd-98c1-939789f8398e";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from2);

        Button btn = findViewById(R.id.btnEnviar);
        final EditText text = findViewById(R.id.campo_text);

        final Contacto contacto = new Contacto();
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                contacto.nombre = text.getText().toString();
                String jsonString = new Gson().toJson(contacto);

                RequestQueue queue = Volley.newRequestQueue(From2Activity.this);
                try {
                    JSONObject objJson = new JSONObject(jsonString);
                    //objJson.put("Anderson",text.getText().toString());
                    JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, objJson, new Response.Listener<JSONObject>(){
                        @Override
                        public void onResponse(JSONObject response) {
                            Log.d("Todo","ok");
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
            }
        });
    }
}
