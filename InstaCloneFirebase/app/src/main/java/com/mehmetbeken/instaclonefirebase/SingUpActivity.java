package com.mehmetbeken.instaclonefirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SingUpActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    EditText emaiText, passwordText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        firebaseAuth = FirebaseAuth.getInstance();
        emaiText = findViewById(R.id.emailText);
        passwordText = findViewById(R.id.passwordText);

        FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
        if (firebaseUser != null){

            Intent intent=new Intent(SingUpActivity.this,FeedActivity.class);
            startActivity(intent);
            finish();




        }




    }

    public void signInClicked(View view) {

        String email = emaiText.getText().toString();
        String password = passwordText.getText().toString();
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Intent intent=new Intent(SingUpActivity.this,FeedActivity.class);
                startActivity(intent);
                finish();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(SingUpActivity.this, e.getLocalizedMessage().toString(), Toast.LENGTH_LONG).show();
            }
        });


    }

    public void signUpClicked(View view) {

        String email = emaiText.getText().toString();
        String password = passwordText.getText().toString();

        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(SingUpActivity.this, "User Created", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(SingUpActivity.this, FeedActivity.class);
                startActivity(intent);
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(SingUpActivity.this, e.getLocalizedMessage().toString(), Toast.LENGTH_LONG).show();
            }
        });

    }


}


















