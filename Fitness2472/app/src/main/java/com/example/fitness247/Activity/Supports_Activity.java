package com.example.fitness247.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitness247.R;

public class Supports_Activity extends AppCompatActivity {
    private LinearLayout profile_button, home_button;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supports);

        profile_button = findViewById(R.id.profile_button);
        profile_button.setOnClickListener(mListener);

        home_button = findViewById(R.id.home_button);
        home_button.setOnClickListener(mListener);
    }

    View.OnClickListener mListener = new View.OnClickListener(){
        @Override
        public void onClick(View view)
        {
            Intent intent;
            int id = view.getId();
            switch(id)
            {
                case R.id.profile_button:
                    intent = new Intent(view.getContext(),UserProfile.class);
                    startActivity(intent);

                    break;
                case R.id.home_button:
                    intent = new Intent(view.getContext(),MainActivity.class);
                    startActivity(intent);
                    break;
                default:
                    break;
            }
        }

    };
}
