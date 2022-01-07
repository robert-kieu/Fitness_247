package com.example.fitness247.Domain;

import java.io.Serializable;

public class Ex_Type_Domain implements Serializable {
    private String title;
    private String pic;


    public Ex_Type_Domain(String title, String pic) {
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
