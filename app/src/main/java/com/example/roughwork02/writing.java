package com.example.roughwork02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class writing extends AppCompatActivity {
private TextView txtname;
private TextView txtdate;
private TextView Topic;
private Button post;
private EditText editText;
private FirebaseDatabase db = FirebaseDatabase.getInstance();
private DatabaseReference root = db.getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writing);
        txtname = (TextView) findViewById(R.id.txtname);
        txtdate = (TextView) findViewById(R.id.txtdate);
        post = (Button) findViewById(R.id.buttonpost);
        editText = findViewById(R.id.editTextTextMultiLine);
        SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = mPreferences.edit();

//        editor.getClass()

        String name =   mPreferences.getString(getString(R.string.name),"");
        txtname.setText(name);

        //String date =(declaring date)
      //  txtdate.setText(date);

        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = txtname.getText().toString();
                String date = txtdate.getText().toString();
                String article = editText.getText().toString();


            }
        });

    }
}