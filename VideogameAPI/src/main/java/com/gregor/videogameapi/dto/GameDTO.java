package com.gregor.videogameapi.dto;

import com.gregor.videogameapi.models.Games;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GameDTO {
    private int id;
    private String name;
    private String slug;
    private String released;
    private double rating;
    private int metacritic;
    private String backgroundImage;
    private EsrbRatingDTO esrbRating;
    private List<GenreDTO> genres;
    private List<PlatformDTO> platforms;
    private List<StoreDTO> stores;
    private List<TagDTO> tags;
    private List<ScreenshotDTO> screenshots;

    public GameDTO() {
    }

    public GameDTO(int id, String name, String slug, String released, double rating,
            int metacritic, String backgroundImage, EsrbRatingDTO esrbRating, List<GenreDTO> genres,
            List<PlatformDTO> platforms, List<StoreDTO> stores, List<TagDTO> tags, List<ScreenshotDTO> screenshots) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.released = released;
        this.rating = rating;
        this.metacritic = metacritic;
        this.backgroundImage = backgroundImage;
        this.esrbRating = esrbRating;
        this.genres = genres;
        this.platforms = platforms;
        this.stores = stores;
        this.tags = tags;
        this.screenshots = screenshots;
    }

    public static GameDTO fromEntity(Games game) {
        GameDTO gdto = new GameDTO();
        gdto.id = game.getId();
        gdto.name = game.getName();
        gdto.slug = game.getSlug();
        gdto.released = Optional.ofNullable(game.getReleased())
                .map(Date::toString).orElse("Unknown");
        gdto.rating = Optional.ofNullable(game.getRating())
                .map(BigDecimal::doubleValue).orElse(0.0);
        gdto.metacritic = Optional.ofNullable(game.getMetacritic()).orElse(0);
        gdto.backgroundImage = game.getBackgroundImage();

        if (game.getEsrbRatingId() != null) {
            com.gregor.videogameapi.models.EsrbRatings esrbRating = game.getEsrbRatingId();
            gdto.esrbRating = new EsrbRatingDTO(esrbRating.getId(), esrbRating.getName(), esrbRating.getSlug());
        }

        if (game.getGenresList() != null) {
            gdto.genres = game.getGenresList().stream()
                .map(g -> new GenreDTO(g.getId(), g.getName(), g.getSlug()))
                .collect(Collectors.toList());
        }

        if (game.getPlatformsList() != null) {
            gdto.platforms = game.getPlatformsList().stream()
                .map(p -> new PlatformDTO(p.getId(), p.getName(), p.getSlug()))
                .collect(Collectors.toList());
        }

        if (game.getStoresList() != null) {
            gdto.stores = game.getStoresList().stream()
                .map(s -> new StoreDTO(s.getId(), s.getName(), s.getSlug()))
                .collect(Collectors.toList());
        }

        if (game.getTagsList() != null) {
            gdto.tags = game.getTagsList().stream()
                .map(t -> new TagDTO(t.getId(), t.getName(), t.getSlug()))
                .collect(Collectors.toList());
        }

        if (game.getScreenshotsList() != null) {
            gdto.screenshots = game.getScreenshotsList().stream()
                .map(s -> new ScreenshotDTO(s.getId(), s.getImage()))
                .collect(Collectors.toList());
        }

        return gdto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getMetacritic() {
        return metacritic;
    }

    public void setMetacritic(int metacritic) {
        this.metacritic = metacritic;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public EsrbRatingDTO getEsrbRating() {
        return esrbRating;
    }

    public void setEsrbRating(EsrbRatingDTO esrbRating) {
        this.esrbRating = esrbRating;
    }

    public List<GenreDTO> getGenres() {
        return genres;
    }

    public void setGenres(List<GenreDTO> genres) {
        this.genres = genres;
    }

    public List<PlatformDTO> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(List<PlatformDTO> platforms) {
        this.platforms = platforms;
    }

    public List<StoreDTO> getStores() {
        return stores;
    }

    public void setStores(List<StoreDTO> stores) {
        this.stores = stores;
    }

    public List<TagDTO> getTags() {
        return tags;
    }

    public void setTags(List<TagDTO> tags) {
        this.tags = tags;
    }

    public List<ScreenshotDTO> getScreenshots() {
        return screenshots;
    }

    public void setScreenshots(List<ScreenshotDTO> screenshots) {
        this.screenshots = screenshots;
    }
} 
