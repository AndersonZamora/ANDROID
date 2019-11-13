package com.example.frutas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleVieHolder> {


    public interface  OnItemClickListener{
        void OnItemClick(int position);
    }
    private OnItemClickListener mListener;

    private ArrayList<ExampleIten> exampleList;

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    @NonNull
    @Override
    public ExampleVieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item,parent,false);
        ExampleVieHolder evh = new ExampleVieHolder(view,mListener);
        return evh;
    }
    public ExampleAdapter(ArrayList<ExampleIten> exampleList){
        this.exampleList = exampleList;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleVieHolder holder, int position) {

        ExampleIten currenteItem = exampleList.get(position);

        holder.mImageView.setImageResource(currenteItem.getmImageResource());
        holder.mTextView1.setText(currenteItem.getmText1());
        holder.mTextView2.setText(currenteItem.getMText2());
    }

    @Override
    public int getItemCount() {
        return exampleList.size();
    }

    public static class ExampleVieHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;
        public ExampleVieHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
            mTextView1 = itemView.findViewById(R.id.textView);
            mTextView2 = itemView.findViewById(R.id.textView2);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.OnItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
