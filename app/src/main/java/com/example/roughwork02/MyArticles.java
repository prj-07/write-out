package com.example.roughwork02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MyArticles extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    TextView textView;
    Button btnstart;
    EditText categoryspec;
    FloatingActionButton addnew;
    private String category;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_articles);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.myarticles);

        textView = (TextView) findViewById(R.id.textViewmyart);
        btnstart = (Button) findViewById(R.id.startarticle);
        addnew = findViewById(R.id.extended_fab);
        bottomNavigationView.setSelectedItemId(R.id.myarticles);

        addnew.setOnClickListener(view -> {
            startActivity(new Intent(MyArticles.this,select_category.class));
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.navigation:
                        startActivity(new Intent(getApplicationContext(),user.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.favourites:
                        startActivity(new Intent(getApplicationContext(),Favourites.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.myarticles:

                        return true;
                }
                return false;
            }
        });



    }

}