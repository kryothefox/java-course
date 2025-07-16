/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gregor.videogameapi.models;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;

/**
 *
 * @author rauma
 */
@Entity
@Table(name = "added_by_status")
@NamedQueries({
    @NamedQuery(name = "AddedByStatus.findAll", query = "SELECT a FROM AddedByStatus a"),
    @NamedQuery(name = "AddedByStatus.findByGameId", query = "SELECT a FROM AddedByStatus a WHERE a.gameId = :gameId"),
    @NamedQuery(name = "AddedByStatus.findByYet", query = "SELECT a FROM AddedByStatus a WHERE a.yet = :yet"),
    @NamedQuery(name = "AddedByStatus.findByOwned", query = "SELECT a FROM AddedByStatus a WHERE a.owned = :owned"),
    @NamedQuery(name = "AddedByStatus.findByBeaten", query = "SELECT a FROM AddedByStatus a WHERE a.beaten = :beaten"),
    @NamedQuery(name = "AddedByStatus.findByToplay", query = "SELECT a FROM AddedByStatus a WHERE a.toplay = :toplay"),
    @NamedQuery(name = "AddedByStatus.findByDropped", query = "SELECT a FROM AddedByStatus a WHERE a.dropped = :dropped"),
    @NamedQuery(name = "AddedByStatus.findByPlaying", query = "SELECT a FROM AddedByStatus a WHERE a.playing = :playing")})
public class AddedByStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "game_id")
    private Integer gameId;
    @Column(name = "yet")
    private Integer yet;
    @Column(name = "owned")
    private Integer owned;
    @Column(name = "beaten")
    private Integer beaten;
    @Column(name = "toplay")
    private Integer toplay;
    @Column(name = "dropped")
    private Integer dropped;
    @Column(name = "playing")
    private Integer playing;
    @JoinColumn(name = "game_id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Games games;

    public AddedByStatus() {
    }

    public AddedByStatus(Integer gameId) {
        this.gameId = gameId;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public Integer getYet() {
        return yet;
    }

    public void setYet(Integer yet) {
        this.yet = yet;
    }

    public Integer getOwned() {
        return owned;
    }

    public void setOwned(Integer owned) {
        this.owned = owned;
    }

    public Integer getBeaten() {
        return beaten;
    }

    public void setBeaten(Integer beaten) {
        this.beaten = beaten;
    }

    public Integer getToplay() {
        return toplay;
    }

    public void setToplay(Integer toplay) {
        this.toplay = toplay;
    }

    public Integer getDropped() {
        return dropped;
    }

    public void setDropped(Integer dropped) {
        this.dropped = dropped;
    }

    public Integer getPlaying() {
        return playing;
    }

    public void setPlaying(Integer playing) {
        this.playing = playing;
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
        hash += (gameId != null ? gameId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AddedByStatus)) {
            return false;
        }
        AddedByStatus other = (AddedByStatus) object;
        if ((this.gameId == null && other.gameId != null) || (this.gameId != null && !this.gameId.equals(other.gameId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gregor.videogameapi.models.AddedByStatus[ gameId=" + gameId + " ]";
    }
    
}
