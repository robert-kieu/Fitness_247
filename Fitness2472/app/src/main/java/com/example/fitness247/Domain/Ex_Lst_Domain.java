package com.example.fitness247.Domain;

import android.widget.TextView;

import com.example.fitness247.R;

import java.io.Serializable;

public class Ex_Lst_Domain implements Serializable {
    private String title;
    private int duration;
    private String description;
    private String video_code;


    public Ex_Lst_Domain(String title, String video_code, String description, int duration) {
        this.title = title;
        this.duration = duration;
        this.description = description;
        this.video_code = video_code;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideo_code() {
        return video_code;
    }

    public void setVideo_code(String pic) {
        this.video_code = pic;
    }
}
