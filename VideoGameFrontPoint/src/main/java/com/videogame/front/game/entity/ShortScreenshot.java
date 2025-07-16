package com.videogame.front.game.entity;

public class ShortScreenshot {
    private int id;
    private String image;

    public ShortScreenshot() {}

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    @Override
    public String toString() {
        return "ShortScreenshot{" +
               "id=" + id +
               ", image='" + image + '\'' +
               '}';
    }
}