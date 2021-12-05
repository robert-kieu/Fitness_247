package com.example.fitness247.Domain;

import java.io.Serializable;

public class MainDomain implements Serializable {
    private String title;
    private String pic;


    public MainDomain(String title, String pic) {
        this.title = title;
        this.pic = pic;
    }

    public String getTitle() {
        return title;
    }

    public String getPic() {
        return pic;
    }
}