package com.example.recyclerview.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.Entidades.Episodio;
import com.example.recyclerview.R;

import org.w3c.dom.Text;

import java.util.List;

public class CarApdaterD extends RecyclerView.Adapter<CarApdaterD.NameViewHolder> {

    String a;
    private List<Episodio> data;

    public CarApdaterD(String  a,List<Episodio> data) {
        this.a = a;
        this.data = data;
    }

    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.custom_view2 ,parent,false);

        NameViewHolder viewHolder1 = new NameViewHolder(view);

        return viewHolder1;
    }
    @Override
    public void onBindViewHolder(@NonNull NameViewHolder holder, int position) {

        TextView texNomb = holder.itemView.findViewById(R.id.textTitle);
        TextView textepis = holder.itemView.findViewById(R.id.textepis);
        TextView textDes = holder.itemView.findViewById(R.id.texteDesd);
        Episodio valor2 = data.get(position);

        textepis.setText(valor2.getNombre());
        textDes.setText(valor2.getDescripcion());
        String valor = a;
        texNomb.setText(valor);
    }
    @Override
    public int getItemCount() {
        return data.size();
    }

    public class NameViewHolder extends RecyclerView.ViewHolder {
        public NameViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
