package com.example.fitness247.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.fitness247.Domain.Ex_Lst_Domain;
import com.example.fitness247.Domain.ExerciseDomain;
import com.example.fitness247.R;

public class Show_ex_detailActivity extends AppCompatActivity {
    private TextView backbtn;
    private TextView ex_title, ex_duration, ex_description;
    private ImageView ex_pic;
    private Ex_Lst_Domain object;


    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_show_ex_detail);

        initView();
        getBundle();

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Show_ex_detailActivity.this, Ex_lstActivity.class);
                startActivity(i);
            }
        });

    }

    private void getBundle() {
        object = (Ex_Lst_Domain) getIntent().getSerializableExtra("object");

        int drawableResourceId = getResources().getIdentifier(object.getPic(), "drawable", this.getPackageName());

        Glide.with(this)
                .load(drawableResourceId)
                .into(ex_pic);

        ex_title.setText(object.getTitle());

        ex_duration.setText("00:" + String.valueOf(object.getDuration()));

        ex_description.setText(object.getDescription());

    }

    private void initView() {
        backbtn = findViewById(R.id.back_btn);
        ex_title = findViewById(R.id.ex_detail_title);
        ex_duration = findViewById(R.id.ex_detail_duration);
        ex_description = findViewById(R.id.ex_detail_des);
        ex_pic = findViewById(R.id.ex_detail_pic);
    }

}
