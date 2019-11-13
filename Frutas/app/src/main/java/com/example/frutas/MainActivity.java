package com.example.frutas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<ExampleIten> mExampleList;
    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private Button buttonInsert;
    private Button buttonRemove;
    private EditText editTextInsert;
    private EditText editTextRemove;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createExampleList();
        buildRecyclerView();

        buttonInsert = findViewById(R.id.button_insert);
        buttonRemove = findViewById(R.id.button_remove);
        editTextInsert = findViewById(R.id.editText_insert);
        editTextRemove = findViewById(R.id.editText_remove);

        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = Integer.parseInt(editTextInsert.getText().toString());
                insertItem(position);
            }
        });
        buttonRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = Integer.parseInt(editTextRemove.getText().toString());
                removerItem(position);
            }
        });
    }

    public void insertItem(int position){
        mExampleList.add(position, new ExampleIten(R.drawable.ic_android,"New Item At Position" + position,"this is line 2 "));
        mAdapter.notifyItemInserted(position);
    }
    private void removerItem(int positon){
        mExampleList.remove(positon);
        mAdapter.notifyItemRemoved(positon);
    }

    public void changeItem(int position,String text){
        mExampleList.get(position).changeText1(text); ///CAMBIO
        mAdapter.notifyItemChanged(position);
    }
    public void createExampleList(){
        mExampleList = new ArrayList<>();
        mExampleList.add(new ExampleIten(R.drawable.ic_android,"line 1","Line 2"));
        mExampleList.add(new ExampleIten(R.drawable.ic_audio,"line 3","Line 4"));
        mExampleList.add(new ExampleIten(R.drawable.ic_sun,"line 5","Line 6"));
    }
    public void buildRecyclerView(){
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(mExampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new ExampleAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {
                changeItem(position,"clicked");
            }
        });
    }
}
