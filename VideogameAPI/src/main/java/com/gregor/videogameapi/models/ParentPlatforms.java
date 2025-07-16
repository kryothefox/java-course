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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author rauma
 */
@Entity
@Table(name = "parent_platforms")
@NamedQueries({
    @NamedQuery(name = "ParentPlatforms.findAll", query = "SELECT p FROM ParentPlatforms p"),
    @NamedQuery(name = "ParentPlatforms.findById", query = "SELECT p FROM ParentPlatforms p WHERE p.id = :id"),
    @NamedQuery(name = "ParentPlatforms.findByName", query = "SELECT p FROM ParentPlatforms p WHERE p.name = :name"),
    @NamedQuery(name = "ParentPlatforms.findBySlug", query = "SELECT p FROM ParentPlatforms p WHERE p.slug = :slug")})
public class ParentPlatforms implements Serializable {

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
    @ManyToMany(mappedBy = "parentPlatformsList")
    private List<Games> gamesList;

    public ParentPlatforms() {
    }

    public ParentPlatforms(Integer id) {
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

    public List<Games> getGamesList() {
        return gamesList;
    }

    public void setGamesList(List<Games> gamesList) {
        this.gamesList = gamesList;
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
        if (!(object instanceof ParentPlatforms)) {
            return false;
        }
        ParentPlatforms other = (ParentPlatforms) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gregor.videogameapi.models.ParentPlatforms[ id=" + id + " ]";
    }
    
}
