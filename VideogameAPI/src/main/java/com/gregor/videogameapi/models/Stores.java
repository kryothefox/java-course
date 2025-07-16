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
import jakarta.persistence.Lob;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author rauma
 */
@Entity
@Table(name = "stores")
@NamedQueries({
    @NamedQuery(name = "Stores.findAll", query = "SELECT s FROM Stores s"),
    @NamedQuery(name = "Stores.findById", query = "SELECT s FROM Stores s WHERE s.id = :id"),
    @NamedQuery(name = "Stores.findByName", query = "SELECT s FROM Stores s WHERE s.name = :name"),
    @NamedQuery(name = "Stores.findBySlug", query = "SELECT s FROM Stores s WHERE s.slug = :slug"),
    @NamedQuery(name = "Stores.findByDomain", query = "SELECT s FROM Stores s WHERE s.domain = :domain"),
    @NamedQuery(name = "Stores.findByGamesCount", query = "SELECT s FROM Stores s WHERE s.gamesCount = :gamesCount")})
public class Stores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "name")
    private String name;
    @Size(max = 100)
    @Column(name = "slug")
    private String slug;
    @Size(max = 100)
    @Column(name = "domain")
    private String domain;
    @Column(name = "games_count")
    private Integer gamesCount;
    @Lob
    @Size(max = 65535)
    @Column(name = "image_background")
    private String imageBackground;
    @OneToMany(mappedBy = "storeId")
    private List<GameStores> gameStoresList;

    public Stores() {
    }

    public Stores(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public Integer getGamesCount() {
        return gamesCount;
    }

    public void setGamesCount(Integer gamesCount) {
        this.gamesCount = gamesCount;
    }

    public String getImageBackground() {
        return imageBackground;
    }

    public void setImageBackground(String imageBackground) {
        this.imageBackground = imageBackground;
    }

    public List<GameStores> getGameStoresList() {
        return gameStoresList;
    }

    public void setGameStoresList(List<GameStores> gameStoresList) {
        this.gameStoresList = gameStoresList;
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
        if (!(object instanceof Stores)) {
            return false;
        }
        Stores other = (Stores) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gregor.videogameapi.models.Stores[ id=" + id + " ]";
    }
    
}
