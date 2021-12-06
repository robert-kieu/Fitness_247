package com.example.fitness247.Domain;

import java.io.Serializable;

public class ExerciseDomain implements Serializable {
    private String title;
    private String pic;
    private String description;
    private Double duration;


    public ExerciseDomain(String title, String pic, String description, Double duration) {
        this.title = title;
        this.pic = pic;
        this.description = description;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public String getPic() {
        return pic;
    }

    public String getDescription() {
        return description;
    }

    public Double getDuration() {
        return duration;
    }
}
