package com.videogame.front.game.entity;

public class PlatformWrapper {
    private Platform platform;
    private String releasedAt; // Mapea a 'released_at' en JSON
    private Requirements requirementsEn; // Mapea a 'requirements_en' en JSON
    private Requirements requirementsRu; // Mapea a 'requirements_ru' en JSON

    public PlatformWrapper() {}

    // Getters y Setters
    public Platform getPlatform() { return platform; }
    public void setPlatform(Platform platform) { this.platform = platform; }
    public String getReleasedAt() { return releasedAt; }
    public void setReleasedAt(String releasedAt) { this.releasedAt = releasedAt; }
    public Requirements getRequirementsEn() { return requirementsEn; }
    public void setRequirementsEn(Requirements requirementsEn) { this.requirementsEn = requirementsEn; }
    public Requirements getRequirementsRu() { return requirementsRu; }
    public void setRequirementsRu(Requirements requirementsRu) { this.requirementsRu = requirementsRu; }

    @Override
    public String toString() {
        return "PlatformWrapper{" +
               "platform=" + platform +
               ", releasedAt='" + releasedAt + '\'' +
               '}';
    }
}