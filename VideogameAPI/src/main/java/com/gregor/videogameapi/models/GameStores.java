/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gregor.videogameapi.models;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author rauma
 */
@Entity
@Table(name = "game_stores")
@NamedQueries({
    @NamedQuery(name = "GameStores.findAll", query = "SELECT g FROM GameStores g"),
    @NamedQuery(name = "GameStores.findById", query = "SELECT g FROM GameStores g WHERE g.id = :id")})
public class GameStores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "game_id", referencedColumnName = "id")
    @ManyToOne
    private Games gameId;
    @JoinColumn(name = "store_id", referencedColumnName = "id")
    @ManyToOne
    private Stores storeId;

    public GameStores() {
    }

    public GameStores(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Games getGameId() {
        return gameId;
    }

    public void setGameId(Games gameId) {
        this.gameId = gameId;
    }

    public Stores getStoreId() {
        return storeId;
    }

    public void setStoreId(Stores storeId) {
        this.storeId = storeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GameStores)) {
            return false;
        }
        GameStores other = (GameStores) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gregor.videogameapi.models.GameStores[ id=" + id + " ]";
    }
    
}
