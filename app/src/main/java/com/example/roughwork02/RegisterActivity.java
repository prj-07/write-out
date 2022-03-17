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

public class RegisterActivity extends AppCompatActivity {
    TextInputEditText textView4;
    TextInputEditText textView5;
    Button regbutton ;
    TextView login;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);
        login = findViewById(R.id.login);
        regbutton = findViewById(R.id.regbutton);

            mAuth = FirebaseAuth.getInstance();
            regbutton.setOnClickListener(view ->
            {
                createUser();
            });
            login.setOnClickListener(view -> {
                startActivity(new Intent(RegisterActivity.this,loginActivity.class));
            });
    }
    private void createUser(){
        String email = textView4.getText().toString();
        String password = textView5.getText().toString();
        if (TextUtils.isEmpty(email)){
            textView4.setError("Email cannot be Empty");
            textView4.requestFocus();
        }
        else if (TextUtils.isEmpty(password)){
            textView5.setError("Password cannot be empty");
            textView5.requestFocus();
        }
        else{
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(RegisterActivity.this, "User Registered Successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new  Intent(RegisterActivity.this,loginActivity.class));
                    }else {
                        Toast.makeText(RegisterActivity.this, "Registration Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}