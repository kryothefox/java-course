/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.core.modules.entityclasses;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author manana
 */
@Entity
@Table(name = "especies")
@NamedQueries({
    @NamedQuery(name = "Especies.findAll", query = "SELECT e FROM Especies e"),
    @NamedQuery(name = "Especies.findByIdEspecie", query = "SELECT e FROM Especies e WHERE e.idEspecie = :idEspecie"),
    @NamedQuery(name = "Especies.findByNombreEspecie", query = "SELECT e FROM Especies e WHERE e.nombreEspecie = :nombreEspecie")})
public class Especies implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_especie")
    private Integer idEspecie;
    @Basic(optional = false)
    @Column(name = "nombre_especie")
    private String nombreEspecie;
    @Lob
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "idEspecie")
    private List<Mascotas> mascotasList;

    public Especies() {
    }

    public Especies(Integer idEspecie) {
        this.idEspecie = idEspecie;
    }

    public Especies(Integer idEspecie, String nombreEspecie) {
        this.idEspecie = idEspecie;
        this.nombreEspecie = nombreEspecie;
    }

    public Integer getIdEspecie() {
        return idEspecie;
    }

    public void setIdEspecie(Integer idEspecie) {
        this.idEspecie = idEspecie;
    }

    public String getNombreEspecie() {
        return nombreEspecie;
    }

    public void setNombreEspecie(String nombreEspecie) {
        this.nombreEspecie = nombreEspecie;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Mascotas> getMascotasList() {
        return mascotasList;
    }

    public void setMascotasList(List<Mascotas> mascotasList) {
        this.mascotasList = mascotasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEspecie != null ? idEspecie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Especies)) {
            return false;
        }
        Especies other = (Especies) object;
        if ((this.idEspecie == null && other.idEspecie != null) || (this.idEspecie != null && !this.idEspecie.equals(other.idEspecie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.core.modules.entityclasses.Especies[ idEspecie=" + idEspecie + " ]";
    }
    
}
