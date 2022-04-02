package com.example.roughwork02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.*;
import java.util.concurrent.Callable;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class writing extends AppCompatActivity {
private TextView txtname;
private TextView txtdate;
private TextView txtcategory;
private Calendar calendar;
private SimpleDateFormat simpleDateFormat;

private Button post;
private EditText editText;
public static final String NAME ="NAME";
public static final String CATEGORY ="CATEGORY";
private String name;
private String getCategory;
FirebaseDatabase rootnode;
DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writing);
        txtname = (TextView) findViewById(R.id.txtname);
        txtdate = (TextView) findViewById(R.id.txtdate);
        txtcategory = (TextView) findViewById(R.id.textcategory);
        post = (Button) findViewById(R.id.buttonpost);
        editText = findViewById(R.id.editTextTextMultiLine);
      //  SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
       // SharedPreferences.Editor editor = mPreferences.edit();

//        editor.getClass()

        //String name =   mPreferences.getString(getString(R.string.name),"");
        //txtname.setText(name);
        Intent i =getIntent();
        name = i.getStringExtra(NAME);
        txtname.setText(name);

        Intent j = getIntent();
        getCategory =j.getStringExtra(CATEGORY);
        txtcategory.setText(getCategory);


       //calendar class
        calendar = Calendar.getInstance();
        String currentdate = DateFormat.getDateInstance().format(calendar.getTime());
        txtdate.setText(currentdate);



        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = txtname.getText().toString();
                String date = txtdate.getText().toString();
                String article = editText.getText().toString();
                String category = txtcategory.getText().toString();

                rootnode = FirebaseDatabase.getInstance();
                reference = rootnode.getReference("Users");

            UserHelperClass helperClass = new UserHelperClass(name,date,category,article);

                reference.child(name).setValue(helperClass);
               // reference.child(article).setValue(helperClass);

            }
        });

    }
}