package com.example.contactos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.contactos.Adaptar.NameAdapter;
import com.example.contactos.Entidades.Persona;

import java.util.ArrayList;
import java.util.List;

public class Contactos extends AppCompatActivity {

    private static final int Nombre = 1;
    private static final int Numero = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactos);

        RecyclerView recyclerViewNames = findViewById(R.id.rvNames);
        recyclerViewNames.setHasFixedSize(true);

        LinearLayoutManager linearManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewNames.setLayoutManager(linearManager);



        List<Persona> datos = listaContactos();

        NameAdapter nameAdapter = new NameAdapter(datos);
        recyclerViewNames.setAdapter(nameAdapter);

    }

    private  List<Persona> listaContactos(){

        List<Persona> personas = new ArrayList<Persona>();

        Persona persona = new Persona("Anderson","940047330" );


        Persona pesona2 = new Persona("Flor","927052857");

        Persona pesona3 = new Persona("Sandra","944387615");

        Persona pesona4 = new Persona("Rudaz","982700866");

        Persona pesona5 = new Persona("Cecilia","993793120");


        personas.add(persona);
        personas.add(pesona2);
        personas.add(pesona3);
        personas.add(pesona4);
        personas.add(pesona5);


        return personas;
    }
      /*
    private List<String> GetNombres(){
        List<String> name = new ArrayList<>();

        name.add("Anderson");
        name.add("Coral");
        name.add("Zamora");
        name.add("Flor");
        name.add("Villanueva");

        return name;
    }*/
}
