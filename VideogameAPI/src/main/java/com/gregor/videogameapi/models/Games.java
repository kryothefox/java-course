package com.gregor.videogameapi.models;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity
@Table(name = "games")
@NamedQueries({
    @NamedQuery(name = "Games.findAll", query = "SELECT g FROM Games g"),
    @NamedQuery(name = "Games.findById", query = "SELECT g FROM Games g WHERE g.id = :id"),
    @NamedQuery(name = "Games.findBySlug", query = "SELECT g FROM Games g WHERE g.slug = :slug"),
    @NamedQuery(name = "Games.findByName", query = "SELECT g FROM Games g WHERE g.name = :name"),
    @NamedQuery(name = "Games.findByReleased", query = "SELECT g FROM Games g WHERE g.released = :released"),
    @NamedQuery(name = "Games.findByTba", query = "SELECT g FROM Games g WHERE g.tba = :tba"),
    @NamedQuery(name = "Games.findByRating", query = "SELECT g FROM Games g WHERE g.rating = :rating"),
    @NamedQuery(name = "Games.findByRatingTop", query = "SELECT g FROM Games g WHERE g.ratingTop = :ratingTop"),
    @NamedQuery(name = "Games.findByRatingsCount", query = "SELECT g FROM Games g WHERE g.ratingsCount = :ratingsCount"),
    @NamedQuery(name = "Games.findByReviewsTextCount", query = "SELECT g FROM Games g WHERE g.reviewsTextCount = :reviewsTextCount"),
    @NamedQuery(name = "Games.findByAdded", query = "SELECT g FROM Games g WHERE g.added = :added"),
    @NamedQuery(name = "Games.findByMetacritic", query = "SELECT g FROM Games g WHERE g.metacritic = :metacritic"),
    @NamedQuery(name = "Games.findByPlaytime", query = "SELECT g FROM Games g WHERE g.playtime = :playtime"),
    @NamedQuery(name = "Games.findBySuggestionsCount", query = "SELECT g FROM Games g WHERE g.suggestionsCount = :suggestionsCount"),
    @NamedQuery(name = "Games.findByUpdated", query = "SELECT g FROM Games g WHERE g.updated = :updated"),
    @NamedQuery(name = "Games.findByReviewsCount", query = "SELECT g FROM Games g WHERE g.reviewsCount = :reviewsCount"),
    @NamedQuery(name = "Games.findBySaturatedColor", query = "SELECT g FROM Games g WHERE g.saturatedColor = :saturatedColor"),
    @NamedQuery(name = "Games.findByDominantColor", query = "SELECT g FROM Games g WHERE g.dominantColor = :dominantColor")})
public class Games implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "slug")
    private String slug;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    @Column(name = "released")
    @Temporal(TemporalType.DATE)
    private Date released;
    @Column(name = "tba")
    private Boolean tba;
    @Lob
    @Size(max = 65535)
    @Column(name = "background_image")
    private String backgroundImage;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "rating")
    private BigDecimal rating;
    @Column(name = "rating_top")
    private Integer ratingTop;
    @Column(name = "ratings_count")
    private Integer ratingsCount;
    @Column(name = "reviews_text_count")
    private Integer reviewsTextCount;
    @Column(name = "added")
    private Integer added;
    @Column(name = "metacritic")
    private Integer metacritic;
    @Column(name = "playtime")
    private Integer playtime;
    @Column(name = "suggestions_count")
    private Integer suggestionsCount;
    @Column(name = "updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    @Column(name = "reviews_count")
    private Integer reviewsCount;
    @Size(max = 7)
    @Column(name = "saturated_color")
    private String saturatedColor;
    @Size(max = 7)
    @Column(name = "dominant_color")
    private String dominantColor;
    @JoinTable(name = "game_parent_platforms", joinColumns = {
        @JoinColumn(name = "game_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "parent_platform_id", referencedColumnName = "id")})
    @ManyToMany
    private List<ParentPlatforms> parentPlatformsList;
    @JoinTable(name = "game_tags", joinColumns = {
        @JoinColumn(name = "game_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "tag_id", referencedColumnName = "id")})
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Tags> tagsList;
    @JoinTable(name = "game_genres", joinColumns = {
        @JoinColumn(name = "game_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "genre_id", referencedColumnName = "id")})
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Genres> genresList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "games")
    private List<GamePlatforms> gamePlatformsList;
    @OneToMany(mappedBy = "gameId", fetch = FetchType.EAGER)
    private List<GameStores> gameStoresList;
    @OneToMany(mappedBy = "gameId", fetch = FetchType.EAGER)
    private List<Screenshots> screenshotsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "games")
    private List<Ratings> ratingsList;
    @JoinColumn(name = "esrb_rating_id", referencedColumnName = "id")
    @ManyToOne
    private EsrbRatings esrbRatingId;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "games")
    private AddedByStatus addedByStatus;

    public Games() {
    }

    public Games(Integer id) {
        this.id = id;
    }

    public Games(Integer id, String slug, String name) {
        this.id = id;
        this.slug = slug;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getReleased() {
        return released;
    }

    public void setReleased(Date released) {
        this.released = released;
    }

    public Boolean getTba() {
        return tba;
    }

    public void setTba(Boolean tba) {
        this.tba = tba;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public Integer getRatingTop() {
        return ratingTop;
    }

    public void setRatingTop(Integer ratingTop) {
        this.ratingTop = ratingTop;
    }

    public Integer getRatingsCount() {
        return ratingsCount;
    }

    public void setRatingsCount(Integer ratingsCount) {
        this.ratingsCount = ratingsCount;
    }

    public Integer getReviewsTextCount() {
        return reviewsTextCount;
    }

    public void setReviewsTextCount(Integer reviewsTextCount) {
        this.reviewsTextCount = reviewsTextCount;
    }

    public Integer getAdded() {
        return added;
    }

    public void setAdded(Integer added) {
        this.added = added;
    }

    public Integer getMetacritic() {
        return metacritic;
    }

    public void setMetacritic(Integer metacritic) {
        this.metacritic = metacritic;
    }

    public Integer getPlaytime() {
        return playtime;
    }

    public void setPlaytime(Integer playtime) {
        this.playtime = playtime;
    }

    public Integer getSuggestionsCount() {
        return suggestionsCount;
    }

    public void setSuggestionsCount(Integer suggestionsCount) {
        this.suggestionsCount = suggestionsCount;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Integer getReviewsCount() {
        return reviewsCount;
    }

    public void setReviewsCount(Integer reviewsCount) {
        this.reviewsCount = reviewsCount;
    }

    public String getSaturatedColor() {
        return saturatedColor;
    }

    public void setSaturatedColor(String saturatedColor) {
        this.saturatedColor = saturatedColor;
    }

    public String getDominantColor() {
        return dominantColor;
    }

    public void setDominantColor(String dominantColor) {
        this.dominantColor = dominantColor;
    }

    public List<ParentPlatforms> getParentPlatformsList() {
        return parentPlatformsList;
    }

    public void setParentPlatformsList(List<ParentPlatforms> parentPlatformsList) {
        this.parentPlatformsList = parentPlatformsList;
    }

    public List<Tags> getTagsList() {
        return tagsList;
    }

    public void setTagsList(List<Tags> tagsList) {
        this.tagsList = tagsList;
    }

    public List<Genres> getGenresList() {
        return genresList;
    }

    public void setGenresList(List<Genres> genresList) {
        this.genresList = genresList;
    }

    public List<GamePlatforms> getGamePlatformsList() {
        return gamePlatformsList;
    }

    public void setGamePlatformsList(List<GamePlatforms> gamePlatformsList) {
        this.gamePlatformsList = gamePlatformsList;
    }

    public List<GameStores> getGameStoresList() {
        return gameStoresList;
    }

    public void setGameStoresList(List<GameStores> gameStoresList) {
        this.gameStoresList = gameStoresList;
    }

    public List<Screenshots> getScreenshotsList() {
        return screenshotsList;
    }

    public void setScreenshotsList(List<Screenshots> screenshotsList) {
        this.screenshotsList = screenshotsList;
    }

    public List<Ratings> getRatingsList() {
        return ratingsList;
    }

    public void setRatingsList(List<Ratings> ratingsList) {
        this.ratingsList = ratingsList;
    }

    public EsrbRatings getEsrbRatingId() {
        return esrbRatingId;
    }

    public void setEsrbRatingId(EsrbRatings esrbRatingId) {
        this.esrbRatingId = esrbRatingId;
    }

    public AddedByStatus getAddedByStatus() {
        return addedByStatus;
    }

    public void setAddedByStatus(AddedByStatus addedByStatus) {
        this.addedByStatus = addedByStatus;
    }

    public List<Platforms> getPlatformsList() {
        if (gamePlatformsList != null) {
            return gamePlatformsList.stream()
                    .map(gp -> gp.getPlatforms())
                    .collect(Collectors.toList());
        }
        return null;
    }

    public List<Stores> getStoresList() {
        if (gamePlatformsList != null) {
            return gameStoresList.stream()
                    .map(gs -> gs.getStoreId())
                    .collect(Collectors.toList());
        }
        return null;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.slug);
        hash = 79 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Games other = (Games) obj;
        if (!Objects.equals(this.slug, other.slug)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Games{" + "id=" + id + ", name=" + name + ", slug=" + slug + '}';
    }
    
}
