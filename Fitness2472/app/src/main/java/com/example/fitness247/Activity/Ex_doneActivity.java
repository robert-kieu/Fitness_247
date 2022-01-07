package com.example.fitness247.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitness247.Domain.Ex_Lst_Domain;
import com.example.fitness247.R;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class Ex_doneActivity extends AppCompatActivity {
    private TextView done_btn;
    private TextView sum_kcal, sum_duration;
    private ArrayList<Ex_Lst_Domain> object_lst;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_finished_practice);

        initView();
        kcal_and_dur_cal();
        done_btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }

    private void kcal_and_dur_cal() {
        int kcal = (int) getIntent().getSerializableExtra("sum_kcal");
        int dur = (int) getIntent().getSerializableExtra("sum_duration");

        NumberFormat f = new DecimalFormat("00");
        long min = (dur / 60000) % 60;
        long sec = (dur / 1000) % 60;

        sum_duration.setText(f.format(min) + ":" + f.format(sec));
        sum_kcal.setText(String.valueOf(kcal));
    }

    private void initView() {
        sum_duration = findViewById(R.id.sum_duration);
        sum_kcal = findViewById(R.id.sum_kcal);
        done_btn = findViewById(R.id.done_btn);
    }

}
