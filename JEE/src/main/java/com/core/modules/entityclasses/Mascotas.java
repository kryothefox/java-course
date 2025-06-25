/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.core.modules.entityclasses;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author manana
 */
@Entity
@Table(name = "mascotas")
@NamedQueries({
    @NamedQuery(name = "Mascotas.findAll", query = "SELECT m FROM Mascotas m"),
    @NamedQuery(name = "Mascotas.findByIdMascota", query = "SELECT m FROM Mascotas m WHERE m.idMascota = :idMascota"),
    @NamedQuery(name = "Mascotas.findByNombre", query = "SELECT m FROM Mascotas m WHERE m.nombre = :nombre"),
    @NamedQuery(name = "Mascotas.findByRaza", query = "SELECT m FROM Mascotas m WHERE m.raza = :raza"),
    @NamedQuery(name = "Mascotas.findByFechaNacimiento", query = "SELECT m FROM Mascotas m WHERE m.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Mascotas.findBySexo", query = "SELECT m FROM Mascotas m WHERE m.sexo = :sexo"),
    @NamedQuery(name = "Mascotas.findByPeso", query = "SELECT m FROM Mascotas m WHERE m.peso = :peso"),
    @NamedQuery(name = "Mascotas.findByColor", query = "SELECT m FROM Mascotas m WHERE m.color = :color"),
    @NamedQuery(name = "Mascotas.findByActivo", query = "SELECT m FROM Mascotas m WHERE m.activo = :activo")})
public class Mascotas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_mascota")
    private Integer idMascota;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "raza")
    private String raza;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Column(name = "sexo")
    private String sexo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "peso")
    private BigDecimal peso;
    @Column(name = "color")
    private String color;
    @Lob
    @Column(name = "observaciones")
    private String observaciones;
    @Column(name = "activo")
    private Boolean activo;
    @OneToMany(mappedBy = "idMascota")
    private List<Citas> citasList;
    @OneToMany(mappedBy = "idMascota")
    private List<Tratamientos> tratamientosList;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne
    private Clientes idCliente;
    @JoinColumn(name = "id_especie", referencedColumnName = "id_especie")
    @ManyToOne
    private Especies idEspecie;

    public Mascotas() {
    }

    public Mascotas(Integer idMascota) {
        this.idMascota = idMascota;
    }

    public Mascotas(Integer idMascota, String nombre) {
        this.idMascota = idMascota;
        this.nombre = nombre;
    }

    public Integer getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(Integer idMascota) {
        this.idMascota = idMascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public List<Citas> getCitasList() {
        return citasList;
    }

    public void setCitasList(List<Citas> citasList) {
        this.citasList = citasList;
    }

    public List<Tratamientos> getTratamientosList() {
        return tratamientosList;
    }

    public void setTratamientosList(List<Tratamientos> tratamientosList) {
        this.tratamientosList = tratamientosList;
    }

    public Clientes getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Clientes idCliente) {
        this.idCliente = idCliente;
    }

    public Especies getIdEspecie() {
        return idEspecie;
    }

    public void setIdEspecie(Especies idEspecie) {
        this.idEspecie = idEspecie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMascota != null ? idMascota.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mascotas)) {
            return false;
        }
        Mascotas other = (Mascotas) object;
        if ((this.idMascota == null && other.idMascota != null) || (this.idMascota != null && !this.idMascota.equals(other.idMascota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Mascotas [idMascota=" + idMascota + ", nombre=" + nombre + ", raza=" + raza + ", fechaNacimiento="
                + fechaNacimiento + ", sexo=" + sexo + ", peso=" + peso + ", color=" + color + ", observaciones="
                + observaciones + ", activo=" + activo + ", citasList=" + citasList + ", tratamientosList="
                + tratamientosList + ", idCliente=" + idCliente + ", idEspecie=" + idEspecie + "]";
    }

    
    
}
