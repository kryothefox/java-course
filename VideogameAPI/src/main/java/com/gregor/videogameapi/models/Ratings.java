/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gregor.videogameapi.models;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author rauma
 */
@Entity
@Table(name = "ratings")
@NamedQueries({
    @NamedQuery(name = "Ratings.findAll", query = "SELECT r FROM Ratings r"),
    @NamedQuery(name = "Ratings.findById", query = "SELECT r FROM Ratings r WHERE r.ratingsPK.id = :id"),
    @NamedQuery(name = "Ratings.findByGameId", query = "SELECT r FROM Ratings r WHERE r.ratingsPK.gameId = :gameId"),
    @NamedQuery(name = "Ratings.findByTitle", query = "SELECT r FROM Ratings r WHERE r.title = :title"),
    @NamedQuery(name = "Ratings.findByCount", query = "SELECT r FROM Ratings r WHERE r.count = :count"),
    @NamedQuery(name = "Ratings.findByPercent", query = "SELECT r FROM Ratings r WHERE r.percent = :percent")})
public class Ratings implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RatingsPK ratingsPK;
    @Size(max = 100)
    @Column(name = "title")
    private String title;
    @Column(name = "count")
    private Integer count;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "percent")
    private BigDecimal percent;
    @JoinColumn(name = "game_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Games games;

    public Ratings() {
    }

    public Ratings(RatingsPK ratingsPK) {
        this.ratingsPK = ratingsPK;
    }

    public Ratings(int id, int gameId) {
        this.ratingsPK = new RatingsPK(id, gameId);
    }

    public RatingsPK getRatingsPK() {
        return ratingsPK;
    }

    public void setRatingsPK(RatingsPK ratingsPK) {
        this.ratingsPK = ratingsPK;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getPercent() {
        return percent;
    }

    public void setPercent(BigDecimal percent) {
        this.percent = percent;
    }

    public Games getGames() {
        return games;
    }

    public void setGames(Games games) {
        this.games = games;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ratingsPK != null ? ratingsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ratings)) {
            return false;
        }
        Ratings other = (Ratings) object;
        if ((this.ratingsPK == null && other.ratingsPK != null) || (this.ratingsPK != null && !this.ratingsPK.equals(other.ratingsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gregor.videogameapi.models.Ratings[ ratingsPK=" + ratingsPK + " ]";
    }
    
}
