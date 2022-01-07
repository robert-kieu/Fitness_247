package com.example.fitness247.Adapter;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fitness247.Activity.MainActivity;
import com.example.fitness247.Domain.Ex_Lst_Domain;
import com.example.fitness247.R;
import com.example.fitness247.Activity.Ex_lstActivity;
import com.example.fitness247.Activity.Show_ex_detailActivity;
import com.example.fitness247.Activity.Ex_PracticeActivity;

import java.util.ArrayList;
import java.io.Serializable;
import androidx.appcompat.view.menu.MenuView.ItemView;

public class Ex_Lst_Adapter extends RecyclerView.Adapter<Ex_Lst_Adapter.ViewHolder> implements Serializable{
    ArrayList<Ex_Lst_Domain> Ex_Lst_Domains;

    public Ex_Lst_Adapter(ArrayList<Ex_Lst_Domain> ex_Lst_Domains) {
        Ex_Lst_Domains = ex_Lst_Domains;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_view_holder_ex_list, parent, false);

        return new ViewHolder(inflate);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.ex_name.setText(Ex_Lst_Domains.get(position).getTitle());
        String pic_url = "";

        switch (position) {
            case 0: {
                pic_url = "main_bkgr";
                holder.main_layout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.dark_bkgr));
                holder.main_layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(holder.itemView.getContext(), Show_ex_detailActivity.class);
                        i.putExtra("object", Ex_Lst_Domains.get(position));
                        holder.itemView.getContext().startActivity(i);
                    }
                });

                break;
            }
            case 1: {
                pic_url = "main_bkgr";
                holder.main_layout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.dark_bkgr));
                holder.main_layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(holder.itemView.getContext(), Show_ex_detailActivity.class);
                        i.putExtra("object", Ex_Lst_Domains.get(position));
                        holder.itemView.getContext().startActivity(i);
                    }
                });
                break;
            }
            case 2: {
                pic_url = "main_bkgr";
                holder.main_layout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.dark_bkgr));
                holder.main_layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(holder.itemView.getContext(), Show_ex_detailActivity.class);
                        i.putExtra("object", Ex_Lst_Domains.get(position));
                        holder.itemView.getContext().startActivity(i);
                    }
                });
                break;
            }
            case 3: {
                pic_url = "main_bkgr";
                holder.main_layout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.dark_bkgr));
                holder.main_layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(holder.itemView.getContext(), Show_ex_detailActivity.class);
                        i.putExtra("object", Ex_Lst_Domains.get(position));
                        holder.itemView.getContext().startActivity(i);
                    }
                });
                break;
            }
            case 4: {
                pic_url = "main_bkgr";
                holder.main_layout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.dark_bkgr));
                holder.main_layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(holder.itemView.getContext(), Show_ex_detailActivity.class);
                        i.putExtra("object", Ex_Lst_Domains.get(position));
                        holder.itemView.getContext().startActivity(i);
                    }
                });
                break;
            }
            case 5: {
                pic_url = "main_bkgr";
                holder.main_layout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.dark_bkgr));
                holder.main_layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(holder.itemView.getContext(), Show_ex_detailActivity.class);
                        i.putExtra("object", Ex_Lst_Domains.get(position));
                        holder.itemView.getContext().startActivity(i);
                    }
                });
                break;
            }
            case 6: {
                pic_url = "main_bkgr";
                holder.main_layout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.dark_bkgr));
                holder.main_layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(holder.itemView.getContext(), Show_ex_detailActivity.class);
                        i.putExtra("object", Ex_Lst_Domains.get(position));
                        holder.itemView.getContext().startActivity(i);
                    }
                });
                break;
            }
            case 7: {
                pic_url = "main_bkgr";
                holder.main_layout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.dark_bkgr));
                holder.main_layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(holder.itemView.getContext(), Show_ex_detailActivity.class);
                        i.putExtra("object", Ex_Lst_Domains.get(position));
                        holder.itemView.getContext().startActivity(i);
                    }
                });
                break;
            }
            case 8: {
                pic_url = "main_bkgr";
                holder.main_layout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.dark_bkgr));
                holder.main_layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(holder.itemView.getContext(), Show_ex_detailActivity.class);
                        i.putExtra("object", Ex_Lst_Domains.get(position));
                        holder.itemView.getContext().startActivity(i);
                    }
                });
                break;
            }
            case 9: {
                pic_url = "main_bkgr";
                holder.main_layout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.dark_bkgr));
                holder.main_layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(holder.itemView.getContext(), Show_ex_detailActivity.class);
                        i.putExtra("object", Ex_Lst_Domains.get(position));
                        holder.itemView.getContext().startActivity(i);
                    }
                });
                break;
            }
            case 10: {
                pic_url = "main_bkgr";
                holder.main_layout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.dark_bkgr));
                holder.main_layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(holder.itemView.getContext(), Show_ex_detailActivity.class);
                        i.putExtra("object", Ex_Lst_Domains.get(position));
                        holder.itemView.getContext().startActivity(i);
                    }
                });
                break;
            }
            case 11: {
                pic_url = "main_bkgr";
                holder.main_layout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.dark_bkgr));
                holder.main_layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(holder.itemView.getContext(), Show_ex_detailActivity.class);
                        i.putExtra("object", Ex_Lst_Domains.get(position));
                        holder.itemView.getContext().startActivity(i);
                    }
                });
                break;
            }

        }
        int drawableResource = holder.itemView.getContext().getResources().getIdentifier(pic_url, "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResource)
                .into(holder.ex_pic);
    }

    @Override
    public int getItemCount() {

        return Ex_Lst_Domains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView ex_name;
        ImageView ex_pic;
        ConstraintLayout main_layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ex_name = itemView.findViewById(R.id.ex_name);
            ex_pic = itemView.findViewById(R.id.ex_pic);
            main_layout = itemView.findViewById(R.id.main_layout);
        }
    }
}
