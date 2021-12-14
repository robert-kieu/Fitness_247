package com.example.fitness247.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitness247.R;

public class Login_Activity extends AppCompatActivity {
    Button login;
    EditText username,password;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_login_page);
        login=(Button) findViewById(R.id.login_btn2);
        username=(EditText) findViewById(R.id.txt_user);
        password=(EditText) findViewById(R.id.txtpass);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    public void login(){
        String user=username.getText().toString().trim();
        String pass=password.getText().toString().trim();
        if(user.equals("admin")&&pass.equals("Admin123")){
            Toast.makeText(this,"Authentication successful!",Toast.LENGTH_LONG).show();
            Intent i=new Intent(Login_Activity.this,IntroActivity.class);
            startActivity(i);
        }else {
            Toast.makeText(this,"Authentication failed! Wrong Username or Password",Toast.LENGTH_LONG).show();
        }
    }
}
