package com.example.roughwork02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    Button btnlogout;
    Button btnnavigate;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        btnlogout = findViewById(R.id.btnlogout);
        btnnavigate = findViewById(R.id.btnnavigate);

        btnnavigate.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this,Categoryview.class));
        });
        btnlogout.setOnClickListener(view -> {
            mAuth.signOut();
            startActivity(new Intent(MainActivity.this,loginActivity.class));
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if(user== null){
            startActivity(new Intent(MainActivity.this,loginActivity.class));
        }
    }
}