package com.example.fitness247.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import java.security.MessageDigest;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fitness247.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


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

        String md5Pass=null;
        try
        {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Add password bytes to digest
            md.update(stringPass.getBytes());

            // Get the hash's bytes
            byte[] bytes = md.digest();

            // This bytes[] has bytes in decimal format. Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            // Get complete hashed password in hex format
            md5Pass = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        System.out.println("Pass:"+ md5Pass);

        FirebaseAuth mAuth;
        mAuth = FirebaseAuth.getInstance();

        progressDialog.show();


        mAuth.createUserWithEmailAndPassword(stringUser, md5Pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                            String Path = user.getUid();

                            FirebaseDatabase database = FirebaseDatabase.getInstance();
                            DatabaseReference myRef = database.getReference(Path);
                            // Sign in success, update UI with the signed-in user's information
                            User myPr = new User("Name",1.0,1.0);
                            myRef.setValue(myPr, new DatabaseReference.CompletionListener() {
                                @Override
                                public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                                }
                            });
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