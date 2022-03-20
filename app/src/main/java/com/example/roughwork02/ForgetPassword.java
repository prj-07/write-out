package com.example.roughwork02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetPassword extends AppCompatActivity {

    Button btnchange;
    Button  btnback;
    FirebaseAuth auth;
    TextInputEditText email;
    String Email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        btnback = (Button) findViewById(R.id.backtologin);
        btnchange = (Button) findViewById(R.id.changepass);
        email =findViewById(R.id.txtemail);
        auth = FirebaseAuth.getInstance();

        btnback.setOnClickListener(view -> {
            startActivity(new Intent(ForgetPassword.this,loginActivity.class));
        });
        btnchange.setOnClickListener(view -> {
            foregetpassword();
        });
    }
    private void foregetpassword(){
       Email = email.getText().toString();
       if (Email.isEmpty()){
           email.setError("Required Field");
       }
       else{
           forget();
       }

    }
    private void forget(){
        auth.sendPasswordResetEmail(Email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(ForgetPassword.this, "Check your mail", Toast.LENGTH_SHORT).show();
                           startActivity(new Intent(ForgetPassword.this,loginActivity.class));
                           finish();
                        }else
                        {
                            Toast.makeText(ForgetPassword.this, "Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}