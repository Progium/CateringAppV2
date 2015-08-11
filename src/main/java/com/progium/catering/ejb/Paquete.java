package com.progium.catering.ejb;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.List;


/**
* Esta clase con anotaciones para la crear la entidadad en
* la base de datos
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/
@Entity
@NamedQuery(name="Paquete.findAll", query="SELECT p FROM Paquete p")
public class Paquete implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idPaquete;

	private int cantidadPersonas;

	private String descripcion;

	private int descuento;

	private BigDecimal montoTotal;

	private String nombre;

	private BigDecimal precio;

	//bi-directional many-to-one association to Catering
	@ManyToOne
	@JoinColumn(name="cateringId")
	private Catering catering;

	//bi-directional many-to-one association to Tipo
	@ManyToOne
	@JoinColumn(name="eventoId")
	private Tipo tipo;

	//bi-directional many-to-one association to Paqueteproducto
	@OneToMany(mappedBy="paquete")
	private List<Paqueteproducto> paqueteproducto;
	
	//bi-directional many-to-one association to Propuestasubasta
	@OneToMany(mappedBy="paquete")
	private List<Propuestasubasta> propuestasubastas;

	//bi-directional many-to-one association to Reservapaquete
	@OneToMany(mappedBy="paquete")
	private List<Reservapaquete> reservapaquetes;

	public Paquete() {
	}

	public int getIdPaquete() {
		return this.idPaquete;
	}

	public void setIdPaquete(int idPaquete) {
		this.idPaquete = idPaquete;
	}

	public int getCantidadPersonas() {
		return this.cantidadPersonas;
	}

	public void setCantidadPersonas(int cantidadPersonas) {
		this.cantidadPersonas = cantidadPersonas;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getDescuento() {
		return this.descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	public BigDecimal getMontoTotal() {
		return this.montoTotal;
	}

	public void setMontoTotal(BigDecimal montoTotal) {
		this.montoTotal = montoTotal;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public Tipo getTipo() {
		return this.tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public List<Paqueteproducto> getPaqueteproducto() {
		return this.paqueteproducto;
	}

	public void setPaqueteproducto(List<Paqueteproducto> paqueteproducto) {
		this.paqueteproducto = paqueteproducto;
	}
	
	public Paqueteproducto addPaqueteproducto(Paqueteproducto paqueteproducto) {
		getPaqueteproducto().add(paqueteproducto);
		paqueteproducto.setPaquete(this);

		return paqueteproducto;
	}

	public Paqueteproducto removePaqueteproducto(Paqueteproducto paqueteproducto) {
		getPaqueteproducto().remove(paqueteproducto);
		paqueteproducto.setPaquete(null);

		return paqueteproducto;
	}
	
	public List<Propuestasubasta> getPropuestasubastas() {
		return this.propuestasubastas;
	}

	public void setPropuestasubastas(List<Propuestasubasta> propuestasubastas) {
		this.propuestasubastas = propuestasubastas;
	}

	public Propuestasubasta addPropuestasubasta(Propuestasubasta propuestasubasta) {
		getPropuestasubastas().add(propuestasubasta);
		propuestasubasta.setPaquete(this);

		return propuestasubasta;
	}

	public Propuestasubasta removePropuestasubasta(Propuestasubasta propuestasubasta) {
		getPropuestasubastas().remove(propuestasubasta);
		propuestasubasta.setPaquete(null);

		return propuestasubasta;
	}

	public List<Reservapaquete> getReservapaquetes() {
		return this.reservapaquetes;
	}

	public void setReservapaquetes(List<Reservapaquete> reservapaquetes) {
		this.reservapaquetes = reservapaquetes;
	}

	public Reservapaquete addReservapaquete(Reservapaquete reservapaquete) {
		getReservapaquetes().add(reservapaquete);
		reservapaquete.setPaquete(this);

		return reservapaquete;
	}

	public Reservapaquete removeReservapaquete(Reservapaquete reservapaquete) {
		getReservapaquetes().remove(reservapaquete);
		reservapaquete.setPaquete(null);

		return reservapaquete;
	}

}