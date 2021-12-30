package com.example.fitness247.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.fitness247.Domain.Ex_Lst_Domain;
import com.example.fitness247.R;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.Timer;
import java.util.TimerTask;

public class Ex_PracticeActivity extends AppCompatActivity {
    private TextView next_btn, previous_btn;
    private TextView ex_title;
    private TextView ex_duration;
    private Ex_Lst_Domain object;
    private int duration;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_view_ex);

        initView();
//        try {
//            getBundle();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


    }


    private void getBundle() throws InterruptedException {
        Ex_Lst_Domain object_lst = (Ex_Lst_Domain) getIntent().getSerializableExtra("object");

        ex_title.setText(object.getTitle());

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            int duration = object.getDuration();

            public void run() {

                ex_duration.setText("00:" + String.valueOf(duration));
                duration--;

                if (duration < 0) {
                    timer.cancel();
                }
            }
        }, 0, 1000);
    }



    private void initView() {
        next_btn = findViewById(R.id.ex_practice_next_btn);
        previous_btn = findViewById(R.id.ex_practice_previous);
        ex_title = findViewById(R.id.ex_detail_title);
        ex_duration = findViewById(R.id.ex_detail_duration);
    }

}
