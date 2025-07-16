/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gregor.videogameapi.models;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;

/**
 *
 * @author rauma
 */
@Embeddable
public class GamePlatformsPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "game_id")
    private int gameId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "platform_id")
    private int platformId;

    public GamePlatformsPK() {
    }

    public GamePlatformsPK(int gameId, int platformId) {
        this.gameId = gameId;
        this.platformId = platformId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getPlatformId() {
        return platformId;
    }

    public void setPlatformId(int platformId) {
        this.platformId = platformId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) gameId;
        hash += (int) platformId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GamePlatformsPK)) {
            return false;
        }
        GamePlatformsPK other = (GamePlatformsPK) object;
        if (this.gameId != other.gameId) {
            return false;
        }
        if (this.platformId != other.platformId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gregor.videogameapi.models.GamePlatformsPK[ gameId=" + gameId + ", platformId=" + platformId + " ]";
    }
    
}
