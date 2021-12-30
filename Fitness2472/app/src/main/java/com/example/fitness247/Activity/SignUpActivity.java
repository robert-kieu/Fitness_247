package com.example.fitness247.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitness247.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {
    Button btn_signup;
    TextView addUser, addPass;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initUI();
        innitListener();
    }

    private void initUI()
    {
        btn_signup = (Button) findViewById(R.id.btn_sign_up);
        addPass = (TextView) findViewById(R.id.add_pass);
        addUser = (TextView) findViewById(R.id.add_user);

        progressDialog = new ProgressDialog(this);

    }
    private void innitListener()
    {
        btn_signup.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                onClickSignUp();

            }
        });
    }

    private void onClickSignUp(){
        String stringUser = addUser.getText().toString().trim();
        String stringPass = addPass.getText().toString().trim();
        FirebaseAuth mAuth;
        mAuth = FirebaseAuth.getInstance();

        progressDialog.show();

        mAuth.createUserWithEmailAndPassword(stringUser, stringPass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Intent intent = new Intent(SignUpActivity.this,MainActivity.class);
                            startActivity(intent);
                            finishAffinity();
                        } else {
                            // If sign in fails, display a message to the user
                            Toast.makeText(SignUpActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

}