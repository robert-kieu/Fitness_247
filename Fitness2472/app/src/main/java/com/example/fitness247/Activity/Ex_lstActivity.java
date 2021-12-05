package com.example.fitness247.Activity;


import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitness247.Adapter.Ex_Lst_Adapter;
import com.example.fitness247.Domain.Ex_Lst_Domain;
import com.example.fitness247.R;

import java.util.ArrayList;

public class Ex_lstActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private RecyclerView recycleView_ex_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_exercise_lst);
        recyclerView_ex_list();
    }


    private void recyclerView_ex_list() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recycleView_ex_list = findViewById(com.example.fitness247.R.id.ex_lst_view);
        recycleView_ex_list.setLayoutManager(linearLayoutManager);

        ArrayList<Ex_Lst_Domain> ex_lst = new ArrayList<>();
        ex_lst.add(new Ex_Lst_Domain("Calf Raise With Splayed Foot", "main_bkgr"));
        ex_lst.add(new Ex_Lst_Domain("Jumping Jacks", "main_bkgr"));
        ex_lst.add(new Ex_Lst_Domain("Standing Back Stretches", "main_bkgr"));
        ex_lst.add(new Ex_Lst_Domain("Hands On The Head Bow Down", "main_bkgr"));
        ex_lst.add(new Ex_Lst_Domain("Wall Standing Glute Kickbacks Left", "main_bkgr"));
        ex_lst.add(new Ex_Lst_Domain("Wall Standing Glute Kickbacks Right", "main_bkgr"));
        ex_lst.add(new Ex_Lst_Domain("Jumping Squats", "main_bkgr"));
        ex_lst.add(new Ex_Lst_Domain("Calf Stretch Left", "main_bkgr"));
        ex_lst.add(new Ex_Lst_Domain("Calf Stretch Right", "main_bkgr"));
        ex_lst.add(new Ex_Lst_Domain("Butt Bride", "main_bkgr"));
        ex_lst.add(new Ex_Lst_Domain("Forward Spine Stretch", "main_bkgr"));
        ex_lst.add(new Ex_Lst_Domain("Cobra Stretch", "main_bkgr"));

        adapter = new Ex_Lst_Adapter(ex_lst);
        recycleView_ex_list.setAdapter(adapter);
    }
}
