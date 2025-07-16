package com.videogame.front.game.entity;

public class Store {
    private int id;
    private String name;
    private String slug;
    private String domain;
    private int gamesCount; // Mapea a 'games_count' en JSON
    private String imageBackground; // Mapea a 'image_background' en JSON

    public Store() {}

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSlug() { return slug; }
    public void setSlug(String slug) { this.slug = slug; }
    public String getDomain() { return domain; }
    public void setDomain(String domain) { this.domain = domain; }
    public int getGamesCount() { return gamesCount; }
    public void setGamesCount(int gamesCount) { this.gamesCount = gamesCount; }
    public String getImageBackground() { return imageBackground; }
    public void setImageBackground(String imageBackground) { this.imageBackground = imageBackground; }

    @Override
    public String toString() {
        return "Store{" +
               "id=" + id +
               ", name='" + name + '\'' +
               '}';
    }
}