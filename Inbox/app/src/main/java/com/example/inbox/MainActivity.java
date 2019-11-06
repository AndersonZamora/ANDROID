package com.example.inbox;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.inbox.Adapter.AdapterImbox;
import com.example.inbox.Entidades.Mensajes;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerViewImbox = findViewById(R.id.imboxId);
        recyclerViewImbox.setHasFixedSize(true);

        LinearLayoutManager linerManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewImbox.setLayoutManager(linerManager);

        //LISTA DE MENSAJES
        List<Mensajes> data = ListaMensaje();

        AdapterImbox adapterImbox = new AdapterImbox(data);

        recyclerViewImbox.setAdapter(adapterImbox);
    }
    private List<Mensajes> ListaMensaje(){

        List<Mensajes> mensajes = new ArrayList<>();

        Mensajes mensajes1 = new Mensajes("Anderson","Hola Como estas");
        Mensajes mensajes2 = new Mensajes("Flor","Hola que haces");

        mensajes.add(mensajes1);
        mensajes.add(mensajes2);

        return mensajes;
    }
}
