package com.example.fitness247.Activity;

public class User {
    private String fullName;
    private double height;
    private double weight;
    private double bmi;

    public User()
    {
    }

    public  User(String fullName,double height, double weight)
    {
        this.fullName = fullName;
        this.height =height;
        this.weight = weight;
        this.bmi = (double) Math.ceil((weight / (height * height)  * 10) / 10);
    }

    public void setFullName(String name) {
            this.fullName = name;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getFullName(){
        return fullName;
    }
    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

}
