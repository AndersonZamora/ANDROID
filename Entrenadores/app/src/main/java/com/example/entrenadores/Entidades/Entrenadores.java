package com.example.entrenadores.Entidades;

import android.widget.ImageView;

public class Entrenadores {
    private String nombre;
    private String medallas;
    private String pokemones;


    public Entrenadores(String nombre, String medallas, String pokemones) {
        this.nombre = nombre;
        this.medallas = medallas;
        this.pokemones = pokemones;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMedallas() {
        return medallas;
    }

    public void setMedallas(String medallas) {
        this.medallas = medallas;
    }

    public String getPokemones() {
        return pokemones;
    }

    public void setPokemones(String pokemones) {
        pokemones = pokemones;
    }

}
