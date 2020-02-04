package com.example.recycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<User> datalist;
    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private DatabaseHandler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datalist = new ArrayList<>();
        setId();
        handler = new DatabaseHandler(this);
        populateView();
        adapter = new RecyclerAdapter(this,datalist);
        //
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this, recyclerView,
                new RecyclerTouchListener.ClickListener() {
                    @Override
                    public void onClick(View view, int position) {
                        Toast.makeText(MainActivity.this,"You Clicked" + position,Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onLongClick(View view, int position) {
                        Toast.makeText(MainActivity.this,"We Clicked" + position,Toast.LENGTH_SHORT).show();
                    }

                }));
    }
    private void populateView() {
        Cursor data = handler.getData();
        while (data.moveToNext()){
            datalist.add(new User(data.getString(0),data.getString(1),
                    data.getString(2),data.getBlob(3)));
        }
    }
    private void setId() {
        recyclerView = findViewById(R.id.his_rec);
    }
}
