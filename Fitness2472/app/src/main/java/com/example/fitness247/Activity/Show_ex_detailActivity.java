package com.example.fitness247.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitness247.Domain.Ex_Lst_Domain;
import com.example.fitness247.R;

public class Show_ex_detailActivity extends AppCompatActivity {
    private TextView backbtn;
    private TextView ex_title, ex_duration, ex_description;
    private String ex_code;
    private ImageView ex_pic;
    private Ex_Lst_Domain object;
    WebView mWebView;


    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_show_ex_detail);

        initView();
        getBundle();
        playVideo(ex_code);

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

        ex_title.setText(object.getTitle());

        ex_duration.setText("00:" + String.valueOf(object.getDuration()));

        ex_description.setText(object.getDescription());

        ex_code = object.getVideo_code();

    }

    private void initView() {
        backbtn = findViewById(R.id.back_btn);
        ex_title = findViewById(R.id.ex_detail_title);
        ex_duration = findViewById(R.id.ex_detail_duration);
        ex_description = findViewById(R.id.ex_detail_des);
    }

    private void playVideo(String code) {
        mWebView=(WebView)findViewById(R.id.videoview);

        //build your own src link with your video ID
        String videoStr = String.format("<html><iframe width=\"520\" height=\"400\" src=\"https://www.youtube.com/embed/%s\" frameborder=\"0\" allowfullscreen></iframe></body></html>", code);

        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        WebSettings ws = mWebView.getSettings();
        ws.setJavaScriptEnabled(true);
        mWebView.loadData(videoStr, "text/html", "utf-8");
    }

}
