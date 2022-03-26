package com.example.roughwork02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    Button btnlogout;
    Button btnnavigate;
    EditText mname;
    FirebaseAuth mAuth;
    SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;

    //private static final String SHARED_PREF_NAME ="mypref";
    //private static final String KEY_NAME = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        btnlogout = findViewById(R.id.btnlogout);
        btnnavigate = findViewById(R.id.btnnavigate);
        mname = findViewById(R.id.naam);
        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mPreferences.edit();


        /*btnnavigate.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this,UserActivity.class));


        });*/
        btnnavigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,UserActivity.class));
                String name = mname.getText().toString();
                mEditor.putString(name,"");
                mEditor.commit();
            }
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