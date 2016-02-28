package com.mbkhack.glinkle.model;

public class Charity {
    private String name;
    private String description;
    private String imageURL;

    public Charity(String name, String description, String imageURL) {
        this.name = name;
        this.description = description;
        this.imageURL = imageURL;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImageURL() {
        return imageURL;
    }
}
