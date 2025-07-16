package com.videogame.front.game.entity;

public class ParentPlatformWrapper {
    private ParentPlatform platform;

    public ParentPlatformWrapper() {}

    // Getters y Setters
    public ParentPlatform getPlatform() { return platform; }
    public void setPlatform(ParentPlatform platform) { this.platform = platform; }

    @Override
    public String toString() {
        return "ParentPlatformWrapper{" +
               "platform=" + platform +
               '}';
    }
}