package com.example.fitness247.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitness247.Adapter.Ex_Type_Lst_Adapter;
import com.example.fitness247.Adapter.Main_Lst_Adapter;
import com.example.fitness247.Domain.Ex_Type_Domain;
import com.example.fitness247.Domain.Main_Lst_Domain;
import com.example.fitness247.R;

import java.util.ArrayList;

public class Ex_typeActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerView_ex_type_list;
    private TextView back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_type_exercise);
        RecyclerView_ex_type_list();

    }

    private void RecyclerView_ex_type_list() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView_ex_type_list = findViewById(R.id.exercise_type_list);
        recyclerView_ex_type_list.setLayoutManager(linearLayoutManager);

        ArrayList<Ex_Type_Domain> ex_lst = new ArrayList<>();
        ex_lst.add(new Ex_Type_Domain("Before 18", "youth"));
        ex_lst.add(new Ex_Type_Domain("18 to 50", "mid"));
        ex_lst.add(new Ex_Type_Domain("After 50", "old"));

        adapter = new Ex_Type_Lst_Adapter(ex_lst);
        recyclerView_ex_type_list.setAdapter(adapter);

        back_btn = findViewById(R.id.back_btn_at_ex_type);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }


}
