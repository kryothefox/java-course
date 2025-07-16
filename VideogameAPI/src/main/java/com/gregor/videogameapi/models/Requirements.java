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
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import java.io.Serializable;

/**
 *
 * @author rauma
 */
@Entity
@Table(name = "requirements")
@NamedQueries({
    @NamedQuery(name = "Requirements.findAll", query = "SELECT r FROM Requirements r"),
    @NamedQuery(name = "Requirements.findById", query = "SELECT r FROM Requirements r WHERE r.id = :id"),
    @NamedQuery(name = "Requirements.findByLanguage", query = "SELECT r FROM Requirements r WHERE r.language = :language")})
public class Requirements implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 10)
    @Column(name = "language")
    private String language;
    @Lob
    @Size(max = 65535)
    @Column(name = "minimum")
    private String minimum;
    @Lob
    @Size(max = 65535)
    @Column(name = "recommended")
    private String recommended;
    @JoinColumn(name = "platform_id", referencedColumnName = "id")
    @ManyToOne
    private Platforms platformId;

    public Requirements() {
    }

    public Requirements(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getMinimum() {
        return minimum;
    }

    public void setMinimum(String minimum) {
        this.minimum = minimum;
    }

    public String getRecommended() {
        return recommended;
    }

    public void setRecommended(String recommended) {
        this.recommended = recommended;
    }

    public Platforms getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Platforms platformId) {
        this.platformId = platformId;
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
        if (!(object instanceof Requirements)) {
            return false;
        }
        Requirements other = (Requirements) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gregor.videogameapi.models.Requirements[ id=" + id + " ]";
    }
    
}
