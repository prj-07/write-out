package com.example.roughwork02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.security.PrivateKey;

public class loginActivity extends AppCompatActivity {

    TextInputEditText textemail;
    TextInputEditText textpassword;
    TextView txtregister;
    Button btnlogin;
    Button forget;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtregister = (TextView)findViewById(R.id.txtregister);
        //txtregister.setOnClickListener();
        textemail = findViewById(R.id.textemail);
        btnlogin = (Button)findViewById(R.id.btnlogin);
        forget = (Button)findViewById(R.id.foregtpass);
        textpassword = findViewById(R.id.textpassword);
        mAuth = FirebaseAuth.getInstance();
        txtregister.setOnClickListener(view -> {
            startActivity(new Intent(loginActivity.this,RegisterActivity.class));
        });
        btnlogin.setOnClickListener(view -> {
            loginUser(/*new Intent(loginActivity.this,"")*/);
        });
        forget.setOnClickListener(view -> {
            startActivity(new Intent(loginActivity.this,ForgetPassword.class));
        });

    }
    private void loginUser(){
        String email = textemail.getText().toString();
        String password = textpassword.getText().toString();
        if (TextUtils.isEmpty(email)){
            textemail.setError("Email cannot be Empty");
            textpassword.requestFocus();
        }
        else if (TextUtils.isEmpty(password)){
            textpassword.setError("Password cannot be empty");
            textpassword.requestFocus();
        }
        else
        {
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(loginActivity.this, "User Logged in Succesfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(loginActivity.this,MainActivity.class));
                    }
                    else{
                        Toast.makeText(loginActivity.this, "log in error", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}