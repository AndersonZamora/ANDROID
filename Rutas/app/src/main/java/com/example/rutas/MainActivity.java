package com.example.rutas;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.LinearLayout;

import com.example.rutas.Adapter.NameAdapter;
import com.example.rutas.Entidades.Fruta;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerViewNames = findViewById(R.id.tvFrutas);
        recyclerViewNames.setHasFixedSize(true);

        LinearLayoutManager linearManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewNames.setLayoutManager(linearManager);


        List<Fruta> futa = ListaFrutas();

        NameAdapter nameAdapter = new NameAdapter(futa);
        recyclerViewNames.setAdapter(nameAdapter);

    }

    private List<Fruta> ListaFrutas() {

        List<Fruta> frutas = new ArrayList<Fruta>();

        List<String> vitaminas1 = new ArrayList<>();
        vitaminas1.add("Vitamina C");
        vitaminas1.add("Vitanmina B1");

        List<String> vitaminas2 = new ArrayList<>();
        vitaminas2.add("Vitamina A");
        vitaminas2.add("Vitanmina B1");
        vitaminas2.add("Vitanmina B2");
        vitaminas2.add("Vitanmina B3");

        String vit1 = TextUtils.join(" ",vitaminas1);
        String vit2 = TextUtils.join(" ",vitaminas2);


        Fruta fruta1 = new Fruta("Manzana",vit1);
        Fruta fruta2 = new Fruta("Pera",vit2);


        frutas.add(fruta1);
        frutas.add(fruta2);
        return frutas;
    }
}
     /*

        */
