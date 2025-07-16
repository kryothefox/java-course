/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.videogame.front.user.entity;

import jakarta.persistence.Basic;
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
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author manana
 */
@Entity
@Table(name = "gamelist")
@NamedQueries({
    @NamedQuery(name = "Gamelist.findAll", query = "SELECT g FROM Gamelist g"),
    @NamedQuery(name = "Gamelist.findById", query = "SELECT g FROM Gamelist g WHERE g.gamelistPK.id = :id"),
    @NamedQuery(name = "Gamelist.findByIdUser", query = "SELECT g FROM Gamelist g WHERE g.gamelistPK.idUser = :idUser"),
    @NamedQuery(name = "Gamelist.findByIdVideogame", query = "SELECT g FROM Gamelist g WHERE g.idVideogame = :idVideogame"),
    @NamedQuery(name = "Gamelist.findByOwned", query = "SELECT g FROM Gamelist g WHERE g.owned = :owned"),
    @NamedQuery(name = "Gamelist.findByCompleted", query = "SELECT g FROM Gamelist g WHERE g.completed = :completed"),
    @NamedQuery(name = "Gamelist.findByDate", query = "SELECT g FROM Gamelist g WHERE g.date = :date")})
public class Gamelist implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GamelistPK gamelistPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_videogame")
    private int idVideogame;
    @Column(name = "owned")
    private Short owned;
    @Column(name = "completed")
    private Short completed;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @JoinColumn(name = "id_user", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;

    public Gamelist() {
    }

    public Gamelist(GamelistPK gamelistPK) {
        this.gamelistPK = gamelistPK;
    }

    public Gamelist(GamelistPK gamelistPK, int idVideogame) {
        this.gamelistPK = gamelistPK;
        this.idVideogame = idVideogame;
    }

    public Gamelist(int id, int idUser) {
        this.gamelistPK = new GamelistPK(id, idUser);
    }

    public GamelistPK getGamelistPK() {
        return gamelistPK;
    }

    public void setGamelistPK(GamelistPK gamelistPK) {
        this.gamelistPK = gamelistPK;
    }

    public int getIdVideogame() {
        return idVideogame;
    }

    public void setIdVideogame(int idVideogame) {
        this.idVideogame = idVideogame;
    }

    public Short getOwned() {
        return owned;
    }

    public void setOwned(Short owned) {
        this.owned = owned;
    }

    public Short getCompleted() {
        return completed;
    }

    public void setCompleted(Short completed) {
        this.completed = completed;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gamelistPK != null ? gamelistPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gamelist)) {
            return false;
        }
        Gamelist other = (Gamelist) object;
        if ((this.gamelistPK == null && other.gamelistPK != null) || (this.gamelistPK != null && !this.gamelistPK.equals(other.gamelistPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.videogame.front.entity.Gamelist[ gamelistPK=" + gamelistPK + " ]";
    }
    
}
