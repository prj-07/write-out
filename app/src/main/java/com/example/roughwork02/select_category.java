package com.example.roughwork02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class select_category extends AppCompatActivity {
    Button btnstart;
    EditText categoryspec;
    private String category;
    FloatingActionButton selectcategory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_category);
        btnstart = findViewById(R.id.startarticle);
        categoryspec = findViewById(R.id.specifycat);
        selectcategory = findViewById(R.id.extended_fab2);



        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(select_category.this, writing.class));
                sendData();
            }
        });
    }
    public void sendData(){
        category = categoryspec.getText().toString().trim();
        Intent i = new Intent(select_category.this,writing.class);
        i.putExtra(writing.CATEGORY,category);
        startActivity(i);
    }
}