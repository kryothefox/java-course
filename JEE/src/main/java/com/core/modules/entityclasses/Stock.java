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
import javax.persistence.Lob;
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
@Table(name = "stock")
@NamedQueries({
    @NamedQuery(name = "Stock.findAll", query = "SELECT s FROM Stock s"),
    @NamedQuery(name = "Stock.findByIdProducto", query = "SELECT s FROM Stock s WHERE s.idProducto = :idProducto"),
    @NamedQuery(name = "Stock.findByNombreProducto", query = "SELECT s FROM Stock s WHERE s.nombreProducto = :nombreProducto"),
    @NamedQuery(name = "Stock.findByCategoria", query = "SELECT s FROM Stock s WHERE s.categoria = :categoria"),
    @NamedQuery(name = "Stock.findByCantidadActual", query = "SELECT s FROM Stock s WHERE s.cantidadActual = :cantidadActual"),
    @NamedQuery(name = "Stock.findByCantidadMinima", query = "SELECT s FROM Stock s WHERE s.cantidadMinima = :cantidadMinima"),
    @NamedQuery(name = "Stock.findByPrecioUnitario", query = "SELECT s FROM Stock s WHERE s.precioUnitario = :precioUnitario"),
    @NamedQuery(name = "Stock.findByFechaVencimiento", query = "SELECT s FROM Stock s WHERE s.fechaVencimiento = :fechaVencimiento"),
    @NamedQuery(name = "Stock.findByProveedor", query = "SELECT s FROM Stock s WHERE s.proveedor = :proveedor"),
    @NamedQuery(name = "Stock.findByCodigoBarras", query = "SELECT s FROM Stock s WHERE s.codigoBarras = :codigoBarras")})
public class Stock implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_producto")
    private Integer idProducto;
    @Basic(optional = false)
    @Column(name = "nombre_producto")
    private String nombreProducto;
    @Lob
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "categoria")
    private String categoria;
    @Column(name = "cantidad_actual")
    private Integer cantidadActual;
    @Column(name = "cantidad_minima")
    private Integer cantidadMinima;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio_unitario")
    private BigDecimal precioUnitario;
    @Column(name = "fecha_vencimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;
    @Column(name = "proveedor")
    private String proveedor;
    @Column(name = "codigo_barras")
    private String codigoBarras;
    @OneToMany(mappedBy = "idProducto")
    private List<DetalleFactura> detalleFacturaList;

    public Stock() {
    }

    public Stock(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Stock(Integer idProducto, String nombreProducto) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getCantidadActual() {
        return cantidadActual;
    }

    public void setCantidadActual(Integer cantidadActual) {
        this.cantidadActual = cantidadActual;
    }

    public Integer getCantidadMinima() {
        return cantidadMinima;
    }

    public void setCantidadMinima(Integer cantidadMinima) {
        this.cantidadMinima = cantidadMinima;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public List<DetalleFactura> getDetalleFacturaList() {
        return detalleFacturaList;
    }

    public void setDetalleFacturaList(List<DetalleFactura> detalleFacturaList) {
        this.detalleFacturaList = detalleFacturaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stock)) {
            return false;
        }
        Stock other = (Stock) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.core.modules.entityclasses.Stock[ idProducto=" + idProducto + " ]";
    }
    
}
