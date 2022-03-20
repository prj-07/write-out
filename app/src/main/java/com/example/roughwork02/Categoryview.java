package com.example.roughwork02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class Categoryview extends AppCompatActivity {
    ImageView ishq;
    ImageView deshprem;
    ImageView motivate;
    ImageView Philosphy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoryview);
    ishq = (ImageView) findViewById(R.id.prem);
    deshprem= (ImageView) findViewById(R.id.desh);
    motivate= (ImageView) findViewById(R.id.hosla);
    Philosphy = (ImageView) findViewById(R.id.phalsafa);
 ishq.setOnClickListener(view -> {
     startActivity(new Intent(Categoryview.this, com.example.roughwork02.ishq.class));
 });



    }
}