package com.gregor.videogameapi.entity;

// Archivo: Requirements.java
public class Requirements {
    private String minimum;
    private String recommended;

    public Requirements() {}

    // Getters y Setters
    public String getMinimum() { return minimum; }
    public void setMinimum(String minimum) { this.minimum = minimum; }
    public String getRecommended() { return recommended; }
    public void setRecommended(String recommended) { this.recommended = recommended; }

    @Override
    public String toString() {
        return "Requirements{" +
               "minimum='" + (minimum != null ? minimum.substring(0, Math.min(minimum.length(), 20)) + "..." : "null") + '\'' +
               ", recommended='" + (recommended != null ? recommended.substring(0, Math.min(recommended.length(), 20)) + "..." : "null") + '\'' +
               '}';
    }
}