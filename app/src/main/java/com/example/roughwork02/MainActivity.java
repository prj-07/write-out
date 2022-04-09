package com.example.roughwork02;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
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
    ProgressDialog progressDialog;
    Button btnnavigate;
    EditText mname;
    FirebaseAuth mAuth;
    SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;

    //private static final String SHARED_PREF_NAME ="mypref";
    //private static final String KEY_NAME = "name";
    private String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        btnlogout = findViewById(R.id.btnlogout);
        btnnavigate = findViewById(R.id.btnnavigate);
        mname = findViewById(R.id.naam);
        mPreferences = getSharedPreferences("Write" , MODE_PRIVATE) ;
        mEditor = mPreferences.edit();


        /*btnnavigate.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this,UserActivity.class));


        });*/
        btnnavigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,user.class));
                String name = mname.getText().toString();
                if (name.length()==0)
                {
                    mname.setError("YOU MUST ENTER YOUR NAME");
                }
                mEditor.putString(name,"");
                mEditor.commit();
                sendData();
                progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.show();
                progressDialog.setContentView(R.layout.progress_dialog);
                progressDialog.getWindow().setBackgroundDrawableResource(
                        android.R.color.transparent
                );
                Thread timer = new Thread(){
                    @Override
                    public void run() {
                        try {
                            sleep(3500);
                            Intent intent = new Intent(getApplicationContext(), user.class);
                            startActivity(intent);
                            progressDialog.dismiss();
                            finish();
                            super.run();
                    }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                };
                timer.start();
            }
        });
        btnlogout.setOnClickListener(view -> {
            mAuth.signOut();
            startActivity(new Intent(MainActivity.this,loginActivity.class));
        });
    }
    public void sendData(){
        name = mname.getText().toString().trim();
        mEditor.putString("Name" , name);
        mEditor.commit() ;
        Intent i = new Intent(MainActivity.this,user.class);
//        i.putExtra(writing.NAME,name);
        startActivity(i);
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