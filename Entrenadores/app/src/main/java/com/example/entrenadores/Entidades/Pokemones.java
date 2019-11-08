package com.example.entrenadores.Entidades;

public class Pokemones {
    private String nombre;
    private String clase;
    private int imageView;
    private int imageView2;
    private int imagePokemon;

    public Pokemones(String nombre, String clase, int imageView,int imageView2,int imagePokemon) {
        this.nombre = nombre;
        this.clase = clase;
        this.imageView = imageView;
        this.imageView2 = imageView2;
        this.imagePokemon = imagePokemon;
    }

    public int getImagePokemon() {
        return imagePokemon;
    }

    public void setImagePokemon(int imagePokemon) {
        this.imagePokemon = imagePokemon;
    }

    public int getImageView2() {
        return imageView2;
    }

    public void setImageView2(int imageView2) {
        this.imageView2 = imageView2;
    }

    public int getImageView() {
        return imageView;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }
}
