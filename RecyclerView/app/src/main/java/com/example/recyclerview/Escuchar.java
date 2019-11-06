package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import com.example.recyclerview.Entidades.Album;

import java.util.Collections;
import java.util.List;

public class Escuchar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escuchar);
        TextView hola = findViewById(R.id.textView);

        String dato = getIntent().getStringExtra("link");

        hola.setText("Hola " + dato);

    }
}
