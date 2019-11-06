package com.example.contactos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Pricipal extends AppCompatActivity {

    private int permisoLlamar = 1;
    private int permisoEnviar = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pricipal);

        Button btLlamar = findViewById(R.id.btLlamar);
        Button btMensaje = findViewById(R.id.btMensaje);
        Button btContac = findViewById(R.id.btContactos);



        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.CALL_PHONE}, permisoLlamar);

        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.SEND_SMS}, permisoLlamar);

        setupLlamar(btLlamar);///METODO PARA HACER UNA LLAMADA
        setupMensaje(btMensaje); ///METODO PARA ENVIAR MENSAJE
        setupContactos(btContac); ///METODO PARA VER LISTA DE CONTACTOS

    }

    private void setupLlamar(Button btLlmar) {
        btLlmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "940047330"));
                if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    Activity#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for Activity#requestPermissions for more details.
                    ActivityCompat.requestPermissions(null,
                            new String[]{Manifest.permission.CALL_PHONE}, permisoLlamar);
                    return;
                }
                startActivity(intent);
            }
        });
    }
    private void  setupMensaje(Button btMensaje){

        btMensaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(intent.EXTRA_TEXT, "Hola Mundo");
                intent.setType("text/plain");

                Intent sahreIntet = Intent.createChooser(intent,null);
                startActivity(sahreIntet);
            }
        });
    }
    private void setupContactos(Button btContac){
        btContac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Contactos.class);
                startActivity(intent);
            }
        });
    }
}
