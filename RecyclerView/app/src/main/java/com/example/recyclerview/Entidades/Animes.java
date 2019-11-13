package com.example.recyclerview.Entidades;

public class Animes {
    private String nombre;
    private String episodio;
    private int imagen;


    public Animes(String nombre, String episodio, int imagen) {
        this.nombre = nombre;
        this.episodio = episodio;
        this.imagen = imagen;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEpisodio() {
        return episodio;
    }

    public void setEpisodio(String episodio) {
        this.episodio = episodio;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
