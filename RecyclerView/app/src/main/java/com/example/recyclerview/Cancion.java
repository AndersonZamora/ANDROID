package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recyclerview.Adapter.CarApdaterD;
import com.example.recyclerview.Entidades.Episodio;

import java.util.ArrayList;
import java.util.List;

public class Cancion extends AppCompatActivity {
    private ArrayList<Episodio> listaepisodios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancion);

        RecyclerView recyclerViewNames = findViewById(R.id.carId2);
        recyclerViewNames.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewNames.setLayoutManager(layoutManager);

        String dato = getIntent().getStringExtra("Nombre");
       // String img = getIntent().getStringExtra("img");
        String episo = getIntent().getStringExtra("episo");

        int receivedImage = getIntent().getIntExtra("image",0);

        List<String> datos = new  ArrayList();

        datos.add(dato);

        String Cancion = TextUtils.join(" -  ",datos);
        List<Episodio> data = listaEpisodios();
        CarApdaterD carApdaterD = new CarApdaterD(Cancion,data);

        recyclerViewNames.setAdapter(carApdaterD);
    }
    public List<Episodio> listaEpisodios(){
        listaepisodios = new ArrayList<>();
        listaepisodios.add(new Episodio("Episodio1","MUERTE DE TOBI"));
        listaepisodios.add(new Episodio("Episodio2","MUERTE DE TOBI PARTE 2"));

        return  listaepisodios;
    }

}
