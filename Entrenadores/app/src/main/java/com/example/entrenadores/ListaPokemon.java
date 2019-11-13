package com.example.entrenadores;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.entrenadores.Adapter.AdapterView2;
import com.example.entrenadores.Adapter.AdapterView3;
import com.example.entrenadores.Entidades.Entrenadores;
import com.example.entrenadores.Entidades.Pokemones;

import java.util.ArrayList;
import java.util.List;

public class ListaPokemon extends AppCompatActivity {

    private ArrayList<Pokemones> listaPokemones;
    public void changeItem(int positon,int imagePoke){

    }

    String [] estrellas = {"Estrella1","Estrella2","Estrella3","Estrella1","Estrella5"};
    int [] etrellaImge = {
            R.drawable.ic_action_name,
    };
    int [] etrellaImge2 = {
            R.drawable.ic_action_name2,
    };
    int [] etrellaImge3 = {
            R.drawable.ic_action_name5,
            R.drawable.ic_action_name6,
            R.drawable.ic_action_name7,
            R.drawable.ic_action_name8,
            R.drawable.ic_action_name9,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pokemon);

        RecyclerView recyclerViewNames = findViewById(R.id.carId2);
        recyclerViewNames.setHasFixedSize(true);

        LinearLayoutManager linearManager = new  LinearLayoutManager(getApplicationContext());
        recyclerViewNames.setLayoutManager(linearManager);

        List<Pokemones> data = PokemonesLista();

        AdapterView3 adapterView3 = new AdapterView3(data);

        recyclerViewNames.setAdapter(adapterView3);

    }
    public List<Pokemones> PokemonesLista(){

        listaPokemones = new ArrayList<>();
        listaPokemones.add(new Pokemones("Pikachu","Electrico",etrellaImge[0],etrellaImge2[0],etrellaImge3[0]));
        listaPokemones.add(new Pokemones("Moltres","fuego/volador",etrellaImge[0],etrellaImge2[0],etrellaImge3[1]));
        listaPokemones.add(new Pokemones("Zapdos","eléctrico/volador",etrellaImge[0],etrellaImge2[0],etrellaImge3[2]));
        listaPokemones.add(new Pokemones("Squirtle","Agua",etrellaImge[0],etrellaImge2[0],etrellaImge3[3]));
        listaPokemones.add(new Pokemones("Nidoqueen","Taladro",etrellaImge[0],etrellaImge2[0],etrellaImge3[4]));
        return listaPokemones;
    }
}
