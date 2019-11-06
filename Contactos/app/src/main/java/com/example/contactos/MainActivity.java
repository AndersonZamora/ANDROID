package com.example.contactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ///BOTONES
        Button btIniciar = findViewById(R.id.btIniciar); //Boton Secion
        ///
        setupIniciar(btIniciar);

    }
    ///METODO PARA CAMBIAR DE PANTALLA
    private void setupIniciar(Button btIniciar){
        btIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Pricipal.class);
                startActivity(intent);
            }
        });
    }
}
