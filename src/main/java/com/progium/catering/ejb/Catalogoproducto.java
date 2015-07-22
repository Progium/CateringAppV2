package com.progium.catering.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the catalogoproducto database table.
 * 
 */
@Entity
@NamedQuery(name="Catalogoproducto.findAll", query="SELECT c FROM Catalogoproducto c")
public class Catalogoproducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idCatalogoProducto;

	private byte estado;

	private String fotografia;

	private BigDecimal precio;

	//bi-directional many-to-one association to Catering
	@ManyToOne
	@JoinColumn(name="cateringId")
	private Catering catering;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="productoId")
	private Producto producto;

	//bi-directional many-to-one association to Detallecotizacion
	@OneToMany(mappedBy="catalogoproducto")
	private List<Detallecotizacion> detallecotizacions;

	//bi-directional many-to-one association to Paqueteproducto
	@OneToMany(mappedBy="catalogoproducto")
	private List<Paqueteproducto> paqueteproductos;

	public Catalogoproducto() {
	}

	public int getIdCatalogoProducto() {
		return this.idCatalogoProducto;
	}

	public void setIdCatalogoProducto(int idCatalogoProducto) {
		this.idCatalogoProducto = idCatalogoProducto;
	}

	public byte getEstado() {
		return this.estado;
	}

	public void setEstado(byte estado) {
		this.estado = estado;
	}

	public String getFotografia() {
		return this.fotografia;
	}

	public void setFotografia(String fotografia) {
		this.fotografia = fotografia;
	}

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public Catering getCatering() {
		return this.catering;
	}

	public void setCatering(Catering catering) {
		this.catering = catering;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public List<Detallecotizacion> getDetallecotizacions() {
		return this.detallecotizacions;
	}

	public void setDetallecotizacions(List<Detallecotizacion> detallecotizacions) {
		this.detallecotizacions = detallecotizacions;
	}

	public Detallecotizacion addDetallecotizacion(Detallecotizacion detallecotizacion) {
		getDetallecotizacions().add(detallecotizacion);
		detallecotizacion.setCatalogoproducto(this);

		return detallecotizacion;
	}

	public Detallecotizacion removeDetallecotizacion(Detallecotizacion detallecotizacion) {
		getDetallecotizacions().remove(detallecotizacion);
		detallecotizacion.setCatalogoproducto(null);

		return detallecotizacion;
	}

	public List<Paqueteproducto> getPaqueteproductos() {
		return this.paqueteproductos;
	}

	public void setPaqueteproductos(List<Paqueteproducto> paqueteproductos) {
		this.paqueteproductos = paqueteproductos;
	}

	public Paqueteproducto addPaqueteproducto(Paqueteproducto paqueteproducto) {
		getPaqueteproductos().add(paqueteproducto);
		paqueteproducto.setCatalogoproducto(this);

		return paqueteproducto;
	}

	public Paqueteproducto removePaqueteproducto(Paqueteproducto paqueteproducto) {
		getPaqueteproductos().remove(paqueteproducto);
		paqueteproducto.setCatalogoproducto(null);

		return paqueteproducto;
	}

}