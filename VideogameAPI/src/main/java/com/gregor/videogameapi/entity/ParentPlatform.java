package com.gregor.videogameapi.entity;

public class ParentPlatform {
    private int id;
    private String name;
    private String slug;

    public ParentPlatform() {}

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSlug() { return slug; }
    public void setSlug(String slug) { this.slug = slug; }

    @Override
    public String toString() {
        return "ParentPlatform{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", slug='" + slug + '\'' +
               '}';
    }
}