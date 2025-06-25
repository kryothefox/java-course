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
@Table(name = "departamentos")
@NamedQueries({
    @NamedQuery(name = "Departamentos.findAll", query = "SELECT d FROM Departamentos d"),
    @NamedQuery(name = "Departamentos.findByIdDepartamento", query = "SELECT d FROM Departamentos d WHERE d.idDepartamento = :idDepartamento"),
    @NamedQuery(name = "Departamentos.findByNombreDepartamento", query = "SELECT d FROM Departamentos d WHERE d.nombreDepartamento = :nombreDepartamento"),
    @NamedQuery(name = "Departamentos.findByUbicacion", query = "SELECT d FROM Departamentos d WHERE d.ubicacion = :ubicacion")})
public class Departamentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_departamento")
    private Integer idDepartamento;
    @Basic(optional = false)
    @Column(name = "nombre_departamento")
    private String nombreDepartamento;
    @Lob
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "ubicacion")
    private String ubicacion;
    @OneToMany(mappedBy = "idDepartamento")
    private List<Empleados> empleadosList;

    public Departamentos() {
    }

    public Departamentos(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public Departamentos(Integer idDepartamento, String nombreDepartamento) {
        this.idDepartamento = idDepartamento;
        this.nombreDepartamento = nombreDepartamento;
    }

    public Integer getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public List<Empleados> getEmpleadosList() {
        return empleadosList;
    }

    public void setEmpleadosList(List<Empleados> empleadosList) {
        this.empleadosList = empleadosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDepartamento != null ? idDepartamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departamentos)) {
            return false;
        }
        Departamentos other = (Departamentos) object;
        if ((this.idDepartamento == null && other.idDepartamento != null) || (this.idDepartamento != null && !this.idDepartamento.equals(other.idDepartamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.core.modules.entityclasses.Departamentos[ idDepartamento=" + idDepartamento + " ]";
    }
    
}
