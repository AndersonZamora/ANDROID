package com.example.recyclerview.Entidades;

import java.io.Serializable;

public class Album implements Serializable {

    private String nombre;
    private String artista;
    private String  numeroCanion;

    public Album(String nombre, String artista, String numeroCanion) {
        this.nombre = nombre;
        this.artista = artista;
        this.numeroCanion = numeroCanion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getNumeroCanion() {
        return numeroCanion;
    }

    public void setNumeroCanion(String numeroCanion) {
        this.numeroCanion = numeroCanion;
    }

}
