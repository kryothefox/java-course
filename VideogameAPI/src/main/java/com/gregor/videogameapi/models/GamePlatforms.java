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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author rauma
 */
@Entity
@Table(name = "game_platforms")
@NamedQueries({
    @NamedQuery(name = "GamePlatforms.findAll", query = "SELECT g FROM GamePlatforms g"),
    @NamedQuery(name = "GamePlatforms.findByGameId", query = "SELECT g FROM GamePlatforms g WHERE g.gamePlatformsPK.gameId = :gameId"),
    @NamedQuery(name = "GamePlatforms.findByPlatformId", query = "SELECT g FROM GamePlatforms g WHERE g.gamePlatformsPK.platformId = :platformId"),
    @NamedQuery(name = "GamePlatforms.findByReleasedAt", query = "SELECT g FROM GamePlatforms g WHERE g.releasedAt = :releasedAt")})
public class GamePlatforms implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GamePlatformsPK gamePlatformsPK;
    @Column(name = "released_at")
    @Temporal(TemporalType.DATE)
    private Date releasedAt;
    @JoinColumn(name = "game_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Games games;
    @JoinColumn(name = "platform_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Platforms platforms;

    public GamePlatforms() {
    }

    public GamePlatforms(GamePlatformsPK gamePlatformsPK) {
        this.gamePlatformsPK = gamePlatformsPK;
    }

    public GamePlatforms(int gameId, int platformId) {
        this.gamePlatformsPK = new GamePlatformsPK(gameId, platformId);
    }

    public GamePlatformsPK getGamePlatformsPK() {
        return gamePlatformsPK;
    }

    public void setGamePlatformsPK(GamePlatformsPK gamePlatformsPK) {
        this.gamePlatformsPK = gamePlatformsPK;
    }

    public Date getReleasedAt() {
        return releasedAt;
    }

    public void setReleasedAt(Date releasedAt) {
        this.releasedAt = releasedAt;
    }

    public Games getGames() {
        return games;
    }

    public void setGames(Games games) {
        this.games = games;
    }

    public Platforms getPlatforms() {
        return platforms;
    }

    public void setPlatforms(Platforms platforms) {
        this.platforms = platforms;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gamePlatformsPK != null ? gamePlatformsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GamePlatforms)) {
            return false;
        }
        GamePlatforms other = (GamePlatforms) object;
        if ((this.gamePlatformsPK == null && other.gamePlatformsPK != null) || (this.gamePlatformsPK != null && !this.gamePlatformsPK.equals(other.gamePlatformsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gregor.videogameapi.models.GamePlatforms[ gamePlatformsPK=" + gamePlatformsPK + " ]";
    }
    
}
