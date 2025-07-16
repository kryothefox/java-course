/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gregor.videogameapi.models;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
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
@Table(name = "platforms")
@NamedQueries({
    @NamedQuery(name = "Platforms.findAll", query = "SELECT p FROM Platforms p"),
    @NamedQuery(name = "Platforms.findById", query = "SELECT p FROM Platforms p WHERE p.id = :id"),
    @NamedQuery(name = "Platforms.findByName", query = "SELECT p FROM Platforms p WHERE p.name = :name"),
    @NamedQuery(name = "Platforms.findBySlug", query = "SELECT p FROM Platforms p WHERE p.slug = :slug"),
    @NamedQuery(name = "Platforms.findByYearStart", query = "SELECT p FROM Platforms p WHERE p.yearStart = :yearStart"),
    @NamedQuery(name = "Platforms.findByYearEnd", query = "SELECT p FROM Platforms p WHERE p.yearEnd = :yearEnd"),
    @NamedQuery(name = "Platforms.findByGamesCount", query = "SELECT p FROM Platforms p WHERE p.gamesCount = :gamesCount")})
public class Platforms implements Serializable {

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
    @Lob
    @Size(max = 65535)
    @Column(name = "image")
    private String image;
    @Column(name = "year_start")
    private Integer yearStart;
    @Column(name = "year_end")
    private Integer yearEnd;
    @Column(name = "games_count")
    private Integer gamesCount;
    @Lob
    @Size(max = 65535)
    @Column(name = "image_background")
    private String imageBackground;
    @OneToMany(mappedBy = "platformId")
    private List<Requirements> requirementsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "platforms")
    private List<GamePlatforms> gamePlatformsList;

    public Platforms() {
    }

    public Platforms(Integer id) {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getYearStart() {
        return yearStart;
    }

    public void setYearStart(Integer yearStart) {
        this.yearStart = yearStart;
    }

    public Integer getYearEnd() {
        return yearEnd;
    }

    public void setYearEnd(Integer yearEnd) {
        this.yearEnd = yearEnd;
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

    public List<Requirements> getRequirementsList() {
        return requirementsList;
    }

    public void setRequirementsList(List<Requirements> requirementsList) {
        this.requirementsList = requirementsList;
    }

    public List<GamePlatforms> getGamePlatformsList() {
        return gamePlatformsList;
    }

    public void setGamePlatformsList(List<GamePlatforms> gamePlatformsList) {
        this.gamePlatformsList = gamePlatformsList;
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
        if (!(object instanceof Platforms)) {
            return false;
        }
        Platforms other = (Platforms) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gregor.videogameapi.models.Platforms[ id=" + id + " ]";
    }
    
}
