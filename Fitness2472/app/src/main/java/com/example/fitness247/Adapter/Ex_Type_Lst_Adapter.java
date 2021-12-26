package com.example.fitness247.Adapter;

import android.view.ViewGroup;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fitness247.Activity.Ex_lstActivity;
import com.example.fitness247.Domain.Ex_Type_Domain;
import com.example.fitness247.Domain.Main_Lst_Domain;
import com.example.fitness247.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Ex_Type_Lst_Adapter extends RecyclerView.Adapter<Ex_Type_Lst_Adapter.ViewHolder> {

    ArrayList<Ex_Type_Domain> Ex_Type_Domains;

    public Ex_Type_Lst_Adapter(ArrayList<Ex_Type_Domain> ex_Type_Domains) {
        Ex_Type_Domains = ex_Type_Domains;
    }

    @NonNull
    @Override
    public Ex_Type_Lst_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_view_type_exercise_holder, parent, false);

        return new Ex_Type_Lst_Adapter.ViewHolder(inflate);
    }


    @Override
    public void onBindViewHolder(@NonNull Ex_Type_Lst_Adapter.ViewHolder holder, int position) {
        holder.tab_name.setText(Ex_Type_Domains.get(position).getTitle());
        String pic_url = "";
        switch (position) {
            case 0: {
                pic_url = "youth";
                holder.ex_type_tab.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.dark_bkgr));
                holder.ex_type_tab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(holder.itemView.getContext(), Ex_lstActivity.class);
                        holder.itemView.getContext().startActivity(i);
                    }
                });
                break;
            }
            case 1: {
                pic_url = "mid";
                holder.ex_type_tab.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.dark_bkgr));
                holder.ex_type_tab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(holder.itemView.getContext(), Ex_lstActivity.class);
                        holder.itemView.getContext().startActivity(i);
                    }
                });
                break;
            }
            case 2: {
                pic_url = "old";
                holder.ex_type_tab.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.dark_bkgr));
                holder.ex_type_tab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(holder.itemView.getContext(), Ex_lstActivity.class);
                        holder.itemView.getContext().startActivity(i);
                    }
                });
                break;
            }

        }
        int drawableResource = holder.itemView.getContext().getResources().getIdentifier(pic_url, "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResource)
                .into(holder.tab_pic);
    }

    @Override
    public int getItemCount() {

        return Ex_Type_Domains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tab_name;
        ImageView tab_pic;
        ConstraintLayout ex_type_tab;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tab_name = itemView.findViewById(R.id.tab_name);
            tab_pic = itemView.findViewById(R.id.tab_pic);
            ex_type_tab = itemView.findViewById(R.id.ex_type_tab);
        }
    }
}
