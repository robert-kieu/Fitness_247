package com.example.fitness247.Activity;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.net.CookieHandler;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.fitness247.Domain.Ex_Lst_Domain;
import com.example.fitness247.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.Timer;
import java.util.TimerTask;

public class Ex_PracticeActivity extends AppCompatActivity implements Serializable {
    private TextView next_btn, previous_btn;
    private TextView ex_title;
    private TextView ex_duration;

    private ArrayList<Ex_Lst_Domain> object_lst;
    private int start, current, end;
    public int sum_duration = 0, sum_kcal = 0;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_view_ex);
        object_lst= (ArrayList<Ex_Lst_Domain>) getIntent().getSerializableExtra("object_lst");
        start = 0;
        end = object_lst.size();
        current = start;
        initView();
        try {
            practice();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void practice() throws InterruptedException {
//        next_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(v.getContext(),"Not implement!",Toast.LENGTH_LONG).show();
//            }
//        });
//        previous_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(v.getContext(),"Not implement!",Toast.LENGTH_LONG).show();
//            }
//        });
        sum_duration += object_lst.get(current).getDuration() * 1000;
        ex_title.setText(object_lst.get(current).getTitle());
        countdown_ex(object_lst.get(current).getDuration());
    }

    private void rest() throws InterruptedException {
//        next_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(v.getContext(),"Not implement!",Toast.LENGTH_LONG).show();
//            }
//        });
//        previous_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(v.getContext(),"Not implement!",Toast.LENGTH_LONG).show();
//            }
//        });

        ex_title.setText("Break Time");
        countdown_rest(object_lst.get(current - 1).getDuration() - 20);
    }


    private void countdown_ex(int time){
        new CountDownTimer(time * 1000 + 1, 1000) {
            public void onTick(long millisUntilFinished) {
                // Used for formatting digit to be in 2 digits only
                NumberFormat f = new DecimalFormat("00");
                long min = (millisUntilFinished / 60000) % 60;
                long sec = (millisUntilFinished / 1000) % 60;
                ex_duration.setText(f.format(min) + ":" + f.format(sec));
            }
            // When the task is over it will print 00:00 there
            public void onFinish() {
                ex_duration.setText("00:00");
                current++;
                if (current < end){
                    try {
                        rest();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                else{
                    Intent intent = new Intent(getBaseContext(), Ex_doneActivity.class);
                    intent.putExtra("sum_duration", sum_duration);
                    intent.putExtra("sum_kcal", sum_kcal);
                    startActivity(intent);
                }
            }
        }.start();
    }

    private void countdown_rest(int time){
        new CountDownTimer(time * 1000 + 1, 1000) {
            public void onTick(long millisUntilFinished) {
                // Used for formatting digit to be in 2 digits only
                NumberFormat f = new DecimalFormat("00");
                long min = (millisUntilFinished / 60000) % 60;
                long sec = (millisUntilFinished / 1000) % 60;
                ex_duration.setText(f.format(min) + ":" + f.format(sec));
            }
            // When the task is over it will print 00:00 there
            public void onFinish() {
                ex_duration.setText("00:00");
                if (current < 2){
                    try {
                        practice();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                else{
                    Intent intent = new Intent(getBaseContext(), Ex_doneActivity.class);
                    startActivity(intent);
                }
            }
        }.start();
    }

    private void initView() {
        next_btn = findViewById(R.id.ex_practice_next_btn);
        previous_btn = findViewById(R.id.ex_practice_previous);
        ex_title = findViewById(R.id.ex_practice_title);
        ex_duration = findViewById(R.id.ex_practice_duration);
    }

}
