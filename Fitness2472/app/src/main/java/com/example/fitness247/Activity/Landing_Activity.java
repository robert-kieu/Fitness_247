package com.example.fitness247.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;
import com.example.fitness247.R;

public class Landing_Activity extends AppCompatActivity {
    Button login1,signup1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_landing);
        login1=(Button) findViewById(R.id.login_btn);
        login1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(v.getContext(),Login_Activity.class);
                startActivity(i);
            }
        });
        signup1=(Button) findViewById(R.id.signup_btn);
        signup1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(v.getContext(),));
            }
        });
    }
}
