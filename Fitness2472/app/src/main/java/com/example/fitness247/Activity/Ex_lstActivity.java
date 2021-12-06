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
        ex_lst.add(new Ex_Lst_Domain("Calf Raise With Splayed Foot", "main_bkgr", "Stand with your feet shoulder width apart, knees slightly bent and toes pointing outwards. Put your hands on the wall to maintain balance.\n\nLift your heels up and down.", 30));
        ex_lst.add(new Ex_Lst_Domain("Jumping Jacks", "main_bkgr", "Stand upright with your legs together, arms at your sides. Bend your knees slightly, and jump into the air.\n\nAs you jump, spread your legs to be about shoulder-width apart. Stretch your arms out and over your head. Jump back to starting position.", 45));
        ex_lst.add(new Ex_Lst_Domain("Standing Back Stretches", "main_bkgr", "Stand with feet a little wider than shoulder width apart.\n\nRaise your hands overhead with palms up toward the ceiling.\n\nUse one of your hands grab the other. Bend your body side to side.", 45));
        ex_lst.add(new Ex_Lst_Domain("Hands On The Head Bow Down", "main_bkgr", "Stand with your feet shoulder with apart. Put your hands behind your head and open your elbows to the sides. Sightly bend your legs.\n\nSit your hips back and bend your upper body forward until your back is almost parallel to the ground. Come back and repeat the exercise.", 45));
        ex_lst.add(new Ex_Lst_Domain("Wall Standing Glute Kickbacks Left", "main_bkgr", "Stand straight with your arms on a wall, then kick your left leg backwards and extend it as far as you can, meanwhile keep your legs and back straight and head up.\n\nGo back to the start position and repeat the exercise.", 45));
        ex_lst.add(new Ex_Lst_Domain("Wall Standing Glute Kickbacks Right", "main_bkgr", "Stand straight with your arms on a wall, then kick your right leg backwards and extend it as far as you can, meanwhile keep your legs and back straight and head up.\n\nGo back to the start position and repeat the exercise.", 45));
        ex_lst.add(new Ex_Lst_Domain("Jumping Squats", "main_bkgr", "Start in the squat position, then jump up using your abdominal muscles for strength. This exercise work your abdomen.", 30));
        ex_lst.add(new Ex_Lst_Domain("Calf Stretch Left", "main_bkgr", "Stand one big step away in front of a wall. Step forward with your right foot and push the wall with your hands.", 45));
        ex_lst.add(new Ex_Lst_Domain("Calf Stretch Right", "main_bkgr", "Stand one big step away in front of a wall. Step forward with your left foot and push the wall with your hands.", 45));
        ex_lst.add(new Ex_Lst_Domain("Butt Bride", "main_bkgr", "Lie on your back with knees bent and feet flat on the floor. Put your arms flat at your sides.\n\nThen lift your butt up and down.", 45));
        ex_lst.add(new Ex_Lst_Domain("Forward Spine Stretch", "main_bkgr", "Sit on the floor with your feet hip width apart. Lift your arms at shoulder height, curl your chin towards your chest.\n\nAs your exercise, draw your abdomen in and use your hands to reach your toes. Inhale and come back. Repeat it.", 45));
        ex_lst.add(new Ex_Lst_Domain("Cobra Stretch", "main_bkgr", "Lie down on your stomach and bend your elbows with your hands beneath your shoulders.\n\nThen push your chest up off the ground as far as possible. Hold this position for seconds.", 45));

        adapter = new Ex_Lst_Adapter(ex_lst);
        recycleView_ex_list.setAdapter(adapter);
    }
}
