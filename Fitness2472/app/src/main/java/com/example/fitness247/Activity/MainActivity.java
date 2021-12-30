package com.example.fitness247.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fitness247.Adapter.Main_Lst_Adapter;
import com.example.fitness247.Domain.Main_Lst_Domain;

import java.util.ArrayList;

import com.example.fitness247.R;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    LinearLayout profile_button;
    private RecyclerView.Adapter adapter, adapter_exercise;
    private RecyclerView recycleView_main_list, recyclerView_ex_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView_main_list();

        profile_button = findViewById(R.id.profile_button);
        profile_button.setOnClickListener(mListener);
    }

    View.OnClickListener mListener = new View.OnClickListener(){
        @Override
        public void onClick(View view)
        {
            int id = view.getId();
            switch(id)
            {
                case R.id.profile_button:
                    Intent intent = new Intent(MainActivity.this,UserProfile.class);
                    startActivity(intent);

                    break;
                default:
                    break;
            }
        }

    };

    private void recyclerView_main_list() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recycleView_main_list = findViewById(R.id.Main_list);
        recycleView_main_list.setLayoutManager(linearLayoutManager);

        ArrayList<Main_Lst_Domain> ex_lst = new ArrayList<>();
        ex_lst.add(new Main_Lst_Domain("Exercise", "image_banner"));
        ex_lst.add(new Main_Lst_Domain("Sleep Tracking", "clock_banner"));
        ex_lst.add(new Main_Lst_Domain("Nutrition", "nutrition_banner"));
        ex_lst.add(new Main_Lst_Domain("Achievement", "achievement_banner"));

        adapter = new Main_Lst_Adapter(ex_lst);
        recycleView_main_list.setAdapter(adapter);
    }


}