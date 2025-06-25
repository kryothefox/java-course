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
@Table(name = "tratamientos")
@NamedQueries({
    @NamedQuery(name = "Tratamientos.findAll", query = "SELECT t FROM Tratamientos t"),
    @NamedQuery(name = "Tratamientos.findByIdTratamiento", query = "SELECT t FROM Tratamientos t WHERE t.idTratamiento = :idTratamiento"),
    @NamedQuery(name = "Tratamientos.findByTipoTratamiento", query = "SELECT t FROM Tratamientos t WHERE t.tipoTratamiento = :tipoTratamiento"),
    @NamedQuery(name = "Tratamientos.findByFechaTratamiento", query = "SELECT t FROM Tratamientos t WHERE t.fechaTratamiento = :fechaTratamiento"),
    @NamedQuery(name = "Tratamientos.findByHoraInicio", query = "SELECT t FROM Tratamientos t WHERE t.horaInicio = :horaInicio"),
    @NamedQuery(name = "Tratamientos.findByHoraFin", query = "SELECT t FROM Tratamientos t WHERE t.horaFin = :horaFin"),
    @NamedQuery(name = "Tratamientos.findByCosto", query = "SELECT t FROM Tratamientos t WHERE t.costo = :costo"),
    @NamedQuery(name = "Tratamientos.findByEstado", query = "SELECT t FROM Tratamientos t WHERE t.estado = :estado")})
public class Tratamientos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tratamiento")
    private Integer idTratamiento;
    @Basic(optional = false)
    @Column(name = "tipo_tratamiento")
    private String tipoTratamiento;
    @Lob
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "fecha_tratamiento")
    @Temporal(TemporalType.DATE)
    private Date fechaTratamiento;
    @Column(name = "hora_inicio")
    @Temporal(TemporalType.TIME)
    private Date horaInicio;
    @Column(name = "hora_fin")
    @Temporal(TemporalType.TIME)
    private Date horaFin;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "costo")
    private BigDecimal costo;
    @Column(name = "estado")
    private String estado;
    @Lob
    @Column(name = "observaciones")
    private String observaciones;
    @OneToMany(mappedBy = "idTratamiento")
    private List<DetalleFactura> detalleFacturaList;
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado")
    @ManyToOne
    private Empleados idEmpleado;
    @JoinColumn(name = "id_mascota", referencedColumnName = "id_mascota")
    @ManyToOne
    private Mascotas idMascota;

    public Tratamientos() {
    }

    public Tratamientos(Integer idTratamiento) {
        this.idTratamiento = idTratamiento;
    }

    public Tratamientos(Integer idTratamiento, String tipoTratamiento, Date fechaTratamiento) {
        this.idTratamiento = idTratamiento;
        this.tipoTratamiento = tipoTratamiento;
        this.fechaTratamiento = fechaTratamiento;
    }

    public Integer getIdTratamiento() {
        return idTratamiento;
    }

    public void setIdTratamiento(Integer idTratamiento) {
        this.idTratamiento = idTratamiento;
    }

    public String getTipoTratamiento() {
        return tipoTratamiento;
    }

    public void setTipoTratamiento(String tipoTratamiento) {
        this.tipoTratamiento = tipoTratamiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaTratamiento() {
        return fechaTratamiento;
    }

    public void setFechaTratamiento(Date fechaTratamiento) {
        this.fechaTratamiento = fechaTratamiento;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public List<DetalleFactura> getDetalleFacturaList() {
        return detalleFacturaList;
    }

    public void setDetalleFacturaList(List<DetalleFactura> detalleFacturaList) {
        this.detalleFacturaList = detalleFacturaList;
    }

    public Empleados getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleados idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Mascotas getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(Mascotas idMascota) {
        this.idMascota = idMascota;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTratamiento != null ? idTratamiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tratamientos)) {
            return false;
        }
        Tratamientos other = (Tratamientos) object;
        if ((this.idTratamiento == null && other.idTratamiento != null) || (this.idTratamiento != null && !this.idTratamiento.equals(other.idTratamiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.core.modules.entityclasses.Tratamientos[ idTratamiento=" + idTratamiento + " ]";
    }
    
}
