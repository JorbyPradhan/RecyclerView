package com.example.recycler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
//private ListView listView;
    private Button addButton,DisplayButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        addButton = findViewById(R.id.add_contact);
        DisplayButton = findViewById(R.id.view_all_contact);
        addButton.setOnClickListener(this);
        DisplayButton.setOnClickListener(this);

       /* listView = findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.array_technology));
        listView.setAdapter(adapter);*/
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_contact:
                startActivity(new Intent(Main2Activity.this,AddContactActivity.class));
                break;
            case R.id.view_all_contact:
                startActivity(new Intent(Main2Activity.this,MainActivity.class));
                break;
        }
    }
}
