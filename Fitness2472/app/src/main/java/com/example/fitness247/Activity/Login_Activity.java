package com.example.fitness247.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fitness247.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Login_Activity extends AppCompatActivity {
    Button login, back2;
    EditText username,password;
    ProgressDialog progressDialog;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        progressDialog = new ProgressDialog(this);
        setContentView(R.layout.activity_view_login_page);
        login=(Button) findViewById(R.id.login_btn2);
        username=(EditText) findViewById(R.id.txt_user);
        password=(EditText) findViewById(R.id.txtpass);
        back2 =(Button)findViewById(R.id.back_btn2);
        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(),Landing_Activity.class));
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(v);
            }
        });
    }

    public void login(View v){
        String user=username.getText().toString().trim();
        String pass=password.getText().toString().trim();
        FirebaseAuth mAuth;
        mAuth = FirebaseAuth.getInstance();
        progressDialog.show();

        String md5Pass=null;
        try
        {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Add password bytes to digest
            md.update(pass.getBytes());

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


        mAuth.signInWithEmailAndPassword(user, md5Pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Intent intent = new Intent(Login_Activity.this,MainActivity.class);
                            startActivity(intent);
                            finishAffinity();
                        } else {
                            // If sign in fails, display a message to the user
                            Toast.makeText(Login_Activity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });

//        if(user.equals("admin")&&pass.equals("Admin123")){
//            Toast.makeText(this,"Authentication successful!",Toast.LENGTH_LONG).show();
//            Intent i=new Intent(v.getContext(),MainActivity.class);
//            startActivity(i);
//        }else {
//            Toast.makeText(this,"Authentication failed!\nWrong Username or Password!",Toast.LENGTH_LONG).show();
//        }
    }
}
