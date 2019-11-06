package com.example.recyclerview.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;

import org.w3c.dom.Text;

import java.util.List;

public class CarApdaterD extends RecyclerView.Adapter<CarApdaterD.NameViewHolder> {

    String a;

    public CarApdaterD(String  a) {
        this.a = a;
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

        TextView texNomb = holder.itemView.findViewById(R.id.texNom);

        String valor = a;

        texNomb.setText(valor);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class NameViewHolder extends RecyclerView.ViewHolder {
        public NameViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
