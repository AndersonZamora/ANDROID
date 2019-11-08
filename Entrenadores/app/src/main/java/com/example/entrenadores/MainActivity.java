package com.example.entrenadores;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.entrenadores.Adapter.AdapterView;
import com.example.entrenadores.Entidades.Entrenadores;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerViewNames = findViewById(R.id.carId);
        recyclerViewNames.setHasFixedSize(true);

        LinearLayoutManager linearManager = new  LinearLayoutManager(getApplicationContext());
        recyclerViewNames.setLayoutManager(linearManager);

        List<Entrenadores> datos = ListaEntrenadores();

        AdapterView adapterView = new AdapterView(datos);

        recyclerViewNames.setAdapter(adapterView);
    }
    public List<Entrenadores> ListaEntrenadores(){

            List<Entrenadores> entrenadores = new ArrayList<>();

            Entrenadores entrenadores1 =new Entrenadores("Entreandor1","Medallas: 5","Pokemones 7");
            Entrenadores entrenadores2 =new Entrenadores("Entreandor2","Medallas 3","Pokemones 7");
            Entrenadores entrenadores3 =new Entrenadores("Entreandor3","Medallas 5","Pokemones 7");
            Entrenadores entrenadores4 =new Entrenadores("Entreandor4","Medallas 5","Pokemones 7");
            Entrenadores entrenadores5 =new Entrenadores("Entreandor5","Medallas 5","Pokemones 7");
            Entrenadores entrenadores6 =new Entrenadores("Entreandor6","Medallas 5","Pokemones 7");
            Entrenadores entrenadores7 =new Entrenadores("Entreandor7","Medallas 5","Pokemones 7");
            Entrenadores entrenadores8 =new Entrenadores("Entreandor8","Medallas 5","Pokemones 7");
            Entrenadores entrenadores9 =new Entrenadores("Entreandor9","Medallas 5","Pokemones 7");
            Entrenadores entrenadores10 =new Entrenadores("Entreandor19","Medallas 5","Pokemones 7");

            entrenadores.add(entrenadores1);
            entrenadores.add(entrenadores2);
            entrenadores.add(entrenadores3);
            entrenadores.add(entrenadores4);
            entrenadores.add(entrenadores5);
            entrenadores.add(entrenadores6);
            entrenadores.add(entrenadores7);
            entrenadores.add(entrenadores8);
            entrenadores.add(entrenadores9);
            entrenadores.add(entrenadores10);

            return entrenadores;
    }
}
