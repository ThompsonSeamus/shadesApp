package com.example.shadesapp;

public class Shade {
    private String name;
    private String description;
    private int colorID;

    public Shade(String name, String description, int colorID) {
        this.name = name;
        this.description = description;
        this.colorID = colorID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getColorID() {return colorID;}

    public void setDescription(String description) {
        this.description = description;
    }
}
