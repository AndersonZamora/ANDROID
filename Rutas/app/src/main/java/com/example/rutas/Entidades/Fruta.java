package com.example.rutas.Entidades;

import java.util.List;

public class Fruta {
    private String nombre;
    private String vitaminas;

    public Fruta(String nombre, String vitaminas) {
        this.nombre = nombre;
        this.vitaminas = vitaminas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getVitaminas() {
        return vitaminas;
    }

    public void setVitaminas(String vitaminas) {
        this.vitaminas = vitaminas;
    }
}
