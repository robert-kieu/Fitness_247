package com.example.fitness247.Adapter;

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
import com.example.fitness247.Domain.Main_Lst_Domain;
import com.example.fitness247.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Main_Lst_Adapter extends RecyclerView.Adapter<Main_Lst_Adapter.ViewHolder> {
    ArrayList<Main_Lst_Domain> Main_Lst_Domains;

    public Main_Lst_Adapter(ArrayList<Main_Lst_Domain> main_Lst_Domains) {
        Main_Lst_Domains = main_Lst_Domains;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_view_holder_main, parent, false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tab_name.setText(Main_Lst_Domains.get(position).getTitle());
        String pic_url = "";
        switch (position) {
            case 0: {
                pic_url = "image_banner";
                holder.tab_layout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.dark_bkgr));
                holder.tab_layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(holder.itemView.getContext(), Ex_lstActivity.class);
                        holder.itemView.getContext().startActivity(i);
                    }
                });
                break;
            }
            case 1: {
                pic_url = "clock_banner";
                holder.tab_layout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.dark_bkgr));

                break;
            }
            case 2: {
                pic_url = "nutrition_banner";
                holder.tab_layout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.dark_bkgr));

                break;
            }
            case 3: {
                pic_url = "achievement_banner";
                holder.tab_layout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.dark_bkgr));

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

        return Main_Lst_Domains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tab_name;
        ImageView tab_pic;
        ConstraintLayout tab_layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tab_name = itemView.findViewById(R.id.tab_name);
            tab_pic = itemView.findViewById(R.id.tab_pic);
            tab_layout = itemView.findViewById(R.id.tab_layout);
        }
    }
}

