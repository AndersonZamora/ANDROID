package com.example.entrenadores.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.style.BackgroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.entrenadores.Entidades.Pokemones;
import com.example.entrenadores.R;
import java.util.List;
public class AdapterView3  extends RecyclerView.Adapter<AdapterView3.NameViewHolder>
        implements View.OnClickListener {



    private List<Pokemones> data;
    // Button btnPokemon;
    Pokemones valor;
    boolean a = true;
    ImageView estrellas;
    private int imageView2;

    int posicion2 = 0;

    public AdapterView3(List<Pokemones> data ) {
        this.data = data;

    }
    int contador = 0;
    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.lista3,parent,false);

        NameViewHolder viewHolder1 = new NameViewHolder(view);

        view.setOnClickListener(this);

        return viewHolder1;
    }
    @Override
    public void onBindViewHolder(@NonNull NameViewHolder holder, int position) {

        this.posicion2 = position;

        TextView nombre  = holder.itemView.findViewById(R.id.textNombre);
        TextView medalla = holder.itemView.findViewById(R.id.textMedalla);
        estrellas = holder.itemView.findViewById(R.id.imageId);
        ImageView imageView2 = holder.itemView.findViewById(R.id.imageView2);
     //   btnPokemon = holder.itemView.findViewById(R.id.btnPokemon);
        // img = holder.itemView.findViewById(R.id.btnPokemon);
         valor =data.get(position);



        nombre.setText(valor.getNombre());
        medalla.setText(valor.getClase());
        imageView2.setImageResource(valor.getImagePokemon());
        estrellas.setImageResource(valor.getImageView());
        estrellas.setOnClickListener(this);
        estrellas.setTag(position);
        nombre.setTag(position);
     //   btnPokemon.setOnClickListener(this);
      //  btnPokemon.setTag(position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    @Override
    public void onClick(View view)  {



        int count = data.size()+1;

        int postion = (int) view.getTag(); // Posicion

        //valor =data.get(postion);

        Pokemones objeto = data.get(posicion2);

        String contado = String.valueOf(postion);

        Context context = view.getContext();
             switch (view.getId()){
                 case R.id.imageId:
                       //  imageView2 = objeto.getImageView2();
                         estrellas.setImageResource(data.get(4).getImageView2());
                         Toast.makeText(context,"Pos: "+contado,Toast.LENGTH_SHORT).show();
                         /*
                         estrellas.setImageResource(objeto.getImageView());
                         Toast.makeText(context,"Pos: "+contado,Toast.LENGTH_SHORT).show();
                         a = true;*/

                     break;
                 default:
                    // estrellas.setImageResource(valor.getImageView());
             }
    }
    public void Fondo1(){
        estrellas.setBackgroundResource(R.drawable.ic_action_name2);
    }
    public void Fondo2(){
        estrellas.setBackgroundResource(R.drawable.ic_action_name);
    }



    public class NameViewHolder extends RecyclerView.ViewHolder {
        public NameViewHolder(@NonNull View itemView) {
            super(itemView);
        }

    }
}
/*
  /* if (view.getId() == btnPokemon.getId()){

            Toast.makeText(btnPokemon.getContext(),contado + objeto.getNombre(),Toast.LENGTH_SHORT).show();
            Fondo1();
        }
 color = Color.WHITE;

                        // btnPokemon.setBackgroundColor(color);
                         btnPokemon.getId();
                         btnPokemon.setTag(postion);
* }*/
