package com.videogame.front.game.entity;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Game {
    private int id;
    private String slug;
    private String name;
    private String released;
    private boolean tba;
    private String backgroundImage; // Mapea a 'background_image' en JSON
    private double rating;
    private int ratingTop; // Mapea a 'rating_top' en JSON
    private List<Rating> ratings;
    private int ratingsCount; // Mapea a 'ratings_count' en JSON
    private int reviewsTextCount; // Mapea a 'reviews_text_count' en JSON
    private int added;
    private AddedByStatus addedByStatus; // Mapea a 'added_by_status' en JSON
    private int metacritic;
    private int playtime;
    private int suggestionsCount; // Mapea a 'suggestions_count' en JSON
    private String updated;
    private Object userGame; // Mapea a 'user_game' en JSON
    private int reviewsCount; // Mapea a 'reviews_count' en JSON
    private String saturatedColor; // Mapea a 'saturated_color' en JSON
    private String dominantColor; // Mapea a 'dominant_color' en JSON
    private List<PlatformWrapper> platforms;
    private List<ParentPlatformWrapper> parentPlatforms; // Mapea a 'parent_platforms' en JSON
    private List<Genre> genres;
    private List<StoreWrapper> stores;
    private Object clip;
    private List<Tag> tags;
//    @SerializedName("esrb_rating")
    private EsrbRating esrbRating; // Mapea a 'esrb_rating' en JSON
    private List<ShortScreenshot> shortScreenshots; // Mapea a 'short_screenshots' en JSON

    // Constructor vacío (necesario si vas a usar reflexión o un parser que lo requiera)
    public Game() {}

    // --- Getters y Setters ---
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getSlug() { return slug; }
    public void setSlug(String slug) { this.slug = slug; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getReleased() { return released; }
    public void setReleased(String released) { this.released = released; }
    public boolean isTba() { return tba; }
    public void setTba(boolean tba) { this.tba = tba; }
    public String getBackgroundImage() { return backgroundImage; }
    public void setBackgroundImage(String backgroundImage) { this.backgroundImage = backgroundImage; }
    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }
    public int getRatingTop() { return ratingTop; }
    public void setRatingTop(int ratingTop) { this.ratingTop = ratingTop; }
    public List<Rating> getRatings() { return ratings; }
    public void setRatings(List<Rating> ratings) { this.ratings = ratings; }
    public int getRatingsCount() { return ratingsCount; }
    public void setRatingsCount(int ratingsCount) { this.ratingsCount = ratingsCount; }
    public int getReviewsTextCount() { return reviewsTextCount; }
    public void setReviewsTextCount(int reviewsTextCount) { this.reviewsTextCount = reviewsTextCount; }
    public int getAdded() { return added; }
    public void setAdded(int added) { this.added = added; }
    public AddedByStatus getAddedByStatus() { return addedByStatus; }
    public void setAddedByStatus(AddedByStatus addedByStatus) { this.addedByStatus = addedByStatus; }
    public int getMetacritic() { return metacritic; }
    public void setMetacritic(int metacritic) { this.metacritic = metacritic; }
    public int getPlaytime() { return playtime; }
    public void setPlaytime(int playtime) { this.playtime = playtime; }
    public int getSuggestionsCount() { return suggestionsCount; }
    public void setSuggestionsCount(int suggestionsCount) { this.suggestionsCount = suggestionsCount; }
    public String getUpdated() { return updated; }
    public void setUpdated(String updated) { this.updated = updated; }
    public Object getUserGame() { return userGame; }
    public void setUserGame(Object userGame) { this.userGame = userGame; }
    public int getReviewsCount() { return reviewsCount; }
    public void setReviewsCount(int reviewsCount) { this.reviewsCount = reviewsCount; }
    public String getSaturatedColor() { return saturatedColor; }
    public void setSaturatedColor(String saturatedColor) { this.saturatedColor = saturatedColor; }
    public String getDominantColor() { return dominantColor; }
    public void setDominantColor(String dominantColor) { this.dominantColor = dominantColor; }
    public List<PlatformWrapper> getPlatforms() { return platforms; }
    public void setPlatforms(List<PlatformWrapper> platforms) { this.platforms = platforms; }
    public List<ParentPlatformWrapper> getParentPlatforms() { return parentPlatforms; }
    public void setParentPlatforms(List<ParentPlatformWrapper> parentPlatforms) { this.parentPlatforms = parentPlatforms; }
    public List<Genre> getGenres() { return genres; }
    public void setGenres(List<Genre> genres) { this.genres = genres; }
    public List<StoreWrapper> getStores() { return stores; }
    public void setStores(List<StoreWrapper> stores) { this.stores = stores; }
    public Object getClip() { return clip; }
    public void setClip(Object clip) { this.clip = clip; }
    public List<Tag> getTags() { return tags; }
    public void setTags(List<Tag> tags) { this.tags = tags; }
    public EsrbRating getEsrbRating() { return esrbRating; }
    public void setEsrbRating(EsrbRating esrbRating) { this.esrbRating = esrbRating; }
    public List<ShortScreenshot> getShortScreenshots() { return shortScreenshots; }
    public void setShortScreenshots(List<ShortScreenshot> shortScreenshots) { this.shortScreenshots = shortScreenshots; }

    @Override
    public String toString() {
        return "Game{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", released='" + released + '\'' +
               ", rating=" + rating +
               ", ratings=" + ratings +
               ", metacritic=" + metacritic +
               '}';
    }
}