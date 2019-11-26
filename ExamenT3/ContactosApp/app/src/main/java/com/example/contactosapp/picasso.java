package com.example.contactosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

public class picasso extends AppCompatActivity {

    private static final String URL_INTERNET = "https://raw.githubusercontent.com/square/picasso/master/website/static/sample.png";
    private static final String URL_INTERNET_PICCASO = "https://square.github.io/picasso/static/debug.png";

    private ImageView img;
    private ImageView img2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso);

        SetUpView();
        loadImagenPicasso();
        //loadImagenPicassoCache();
        //loadImagenPicassoSinCache();
        loadImagenWithPlaceHoldeWithPicasso();
    }
    private void loadImagenPicasso() {
        Picasso.get().load(URL_INTERNET_PICCASO)
                .resize(2000,2000) //tamño de imagen
               // .centerCrop() // Para centrar la Imagen
               // .centerInside() //todo ancho que ocuapa
                .onlyScaleDown() //Si la imagen es mayor que 200x200 te la deja en 200 x 200
                .into(img);
       // Picasso.get().load(URL_INTERNET_PICCASO).into(img2);
    }
    private  void loadImagenPicassoCache(){

        Picasso.get()
                .load(URL_INTERNET_PICCASO)
                .networkPolicy(NetworkPolicy.OFFLINE)
                .into(img);
    }
    private  void loadImagenPicassoSinCache(){
        Picasso.get()
                .load(URL_INTERNET_PICCASO)
                .fetch(new Callback() {
                    @Override
                    public void onSuccess() {
                        Picasso.get()
                                .load(URL_INTERNET_PICCASO)
                                .networkPolicy(NetworkPolicy.NO_CACHE)
                                .memoryPolicy(MemoryPolicy.NO_CACHE)
                                .into(img);
                    }
                    @Override
                    public void onError(Exception e) {
                    }
                });
    }
    private void loadImagenWithPlaceHoldeWithPicasso(){

        Picasso.get()
                .load(URL_INTERNET)//Si el tiempo de respuesta demora
                .placeholder(R.mipmap.ic_launcher) // Mostrara esta imagen al Usuario
                .into(img2);
    }
    private void SetUpView() {
        img = findViewById(R.id.picasso);
        img2 = findViewById(R.id.picasso2);
    }
}
