package com.progium.catering.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the cotizacion database table.
 * 
 */
@Entity
@NamedQuery(name="Cotizacion.findAll", query="SELECT c FROM Cotizacion c")
public class Cotizacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idCotizacion;

	private String correo;

	private BigDecimal descuento;

	private BigDecimal montoTotal;

	private String nombre;

	private String telefono;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="clienteId")
	private Usuario usuario;

	//bi-directional many-to-one association to Catering
	@ManyToOne
	@JoinColumn(name="cateringId")
	private Catering catering;

	//bi-directional many-to-one association to Tipo
	@ManyToOne
	@JoinColumn(name="estadoTransaccionId")
	private Tipo tipo;

	//bi-directional many-to-one association to Detallecotizacion
	@OneToMany(mappedBy="cotizacion")
	private List<Detallecotizacion> detallecotizacions;

	//bi-directional many-to-one association to Otrocargo
	@OneToMany(mappedBy="cotizacion")
	private List<Otrocargo> otrocargos;

	public Cotizacion() {
	}

	public int getIdCotizacion() {
		return this.idCotizacion;
	}

	public void setIdCotizacion(int idCotizacion) {
		this.idCotizacion = idCotizacion;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public BigDecimal getDescuento() {
		return this.descuento;
	}

	public void setDescuento(BigDecimal descuento) {
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

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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

	public List<Detallecotizacion> getDetallecotizacions() {
		return this.detallecotizacions;
	}

	public void setDetallecotizacions(List<Detallecotizacion> detallecotizacions) {
		this.detallecotizacions = detallecotizacions;
	}

	public Detallecotizacion addDetallecotizacion(Detallecotizacion detallecotizacion) {
		getDetallecotizacions().add(detallecotizacion);
		detallecotizacion.setCotizacion(this);

		return detallecotizacion;
	}

	public Detallecotizacion removeDetallecotizacion(Detallecotizacion detallecotizacion) {
		getDetallecotizacions().remove(detallecotizacion);
		detallecotizacion.setCotizacion(null);

		return detallecotizacion;
	}

	public List<Otrocargo> getOtrocargos() {
		return this.otrocargos;
	}

	public void setOtrocargos(List<Otrocargo> otrocargos) {
		this.otrocargos = otrocargos;
	}

	public Otrocargo addOtrocargo(Otrocargo otrocargo) {
		getOtrocargos().add(otrocargo);
		otrocargo.setCotizacion(this);

		return otrocargo;
	}

	public Otrocargo removeOtrocargo(Otrocargo otrocargo) {
		getOtrocargos().remove(otrocargo);
		otrocargo.setCotizacion(null);

		return otrocargo;
	}

}