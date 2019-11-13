package com.example.exament3.data;

import android.media.Image;

import com.example.exament3.R;
import com.example.exament3.entities.Anime;
import com.example.exament3.entities.Episodio;

import java.util.ArrayList;
import java.util.List;

public class Data {



    public  static List<Anime> getAnimes(){
        int [] anime = {
                R.drawable.ic_launcher_1,
                R.drawable.ic_launcher_2,
                R.drawable.ic_launcher_3,
                R.drawable.ic_launcher_4,
                R.drawable.ic_launcher_5,
                R.drawable.ic_launcher_6
        };


        List<Anime> animes = new ArrayList<>();

        Anime anime1 = new Anime();
        anime1.nombre = "Anime 1";
        anime1.imagen = anime[0];
        anime1.estado = false;
        anime1.episodios = getEpisodiosAnime1();

        Anime anime2 = new Anime();
        anime2.nombre = "Anime 2";
        anime2.imagen = anime[1];
        anime2.estado = false;
        anime2.episodios = getEpisodiosAnime2();

        Anime anime3 = new Anime();
        anime3.nombre = "Anime 3";
        anime3.estado = false;
        anime3.imagen = anime[2];
        anime3.episodios = getEpisodiosAnime1();

        Anime anime4 = new Anime();
        anime4.nombre = "Anime 4";
        anime4.imagen = anime[3];
        anime4.estado = false;
        anime4.episodios = getEpisodiosAnime2();

        Anime anime5 = new Anime();
        anime5.nombre = "Anime 5";
        anime5.imagen = anime[4];
        anime5.estado = false;
        anime5.episodios = getEpisodiosAnime1();

        Anime anime6 = new Anime();
        anime6.nombre = "Anime 6";
        anime6.imagen = anime[5];
        anime6.estado = false;
        anime6.episodios = getEpisodiosAnime3();

        animes.add(anime1);
        animes.add(anime2);
        animes.add(anime3);
        animes.add(anime4);
        animes.add(anime5);
        animes.add(anime6);
        return animes;
    }


    public  static List<Episodio> getEpisodiosAnime1(){
        int [] anime = {
                R.drawable.ic_launcher_1,
                R.drawable.ic_launcher_2,
                R.drawable.ic_launcher_3,
                R.drawable.ic_launcher_4,
                R.drawable.ic_launcher_5,
                R.drawable.ic_launcher_6
        };


        List<Episodio> episodios = new ArrayList<>();
        episodios.add(new Episodio("episodio 1","descripcion 1",anime[0]));
        episodios.add(new Episodio("episodio 2","descripcion 2",anime[1]));

        return  episodios;
    }
    public  static List<Episodio> getEpisodiosAnime3(){
        int [] anime = {
                R.drawable.ic_launcher_1,
                R.drawable.ic_launcher_2,
                R.drawable.ic_launcher_3,
                R.drawable.ic_launcher_4,
                R.drawable.ic_launcher_5,
                R.drawable.ic_launcher_6
        };

        List<Episodio> episodios = new ArrayList<>();
        episodios.add(new Episodio("episodio 1","descripcion 1",anime[2]));
        episodios.add(new Episodio("episodio 2","descripcion 2",anime[3]));
        episodios.add(new Episodio("episodio 3","descripcion 3",anime[4]));
        return  episodios;
    }
    public  static List<Episodio> getEpisodiosAnime2(){
        int [] anime = {
                R.drawable.ic_launcher_1,
                R.drawable.ic_launcher_2,
                R.drawable.ic_launcher_3,
                R.drawable.ic_launcher_4,
                R.drawable.ic_launcher_5,
                R.drawable.ic_launcher_6
        };

        List<Episodio> episodios = new ArrayList<>();
        episodios.add(new Episodio("episodio 1","descripcion 1",anime[5]));

        return  episodios;
    }
}
