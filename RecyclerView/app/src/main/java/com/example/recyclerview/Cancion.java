package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import com.example.recyclerview.Adapter.CarApdaterD;

import java.util.ArrayList;
import java.util.List;

public class Cancion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancion);

        RecyclerView recyclerViewNames = findViewById(R.id.carId2);
        recyclerViewNames.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewNames.setLayoutManager(layoutManager);

        String dato = getIntent().getStringExtra("Nombre");

        String dato2 = getIntent().getStringExtra("Artista");

        String dato3 = getIntent().getStringExtra("Numero");

        List<String> datos = new  ArrayList();

        datos.add(dato + dato2 + dato3);

        String Cancion = TextUtils.join(" -  ",datos);

        CarApdaterD carApdaterD = new CarApdaterD(Cancion);

        recyclerViewNames.setAdapter(carApdaterD);
    }

}
