package com.progium.catering.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
* Esta clase con anotaciones para la crear la entidadad en
* la base de datos
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/
@Entity
@NamedQuery(name="Otrocargo.findAll", query="SELECT o FROM Otrocargo o")
public class Otrocargo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idOtroCargo;

	private String nombre;

	private BigDecimal precio;

	//bi-directional many-to-one association to Cotizacion
	@ManyToOne
	@JoinColumn(name="cotizacionId")
	private Cotizacion cotizacion;

	public Otrocargo() {
	}

	public int getIdOtroCargo() {
		return this.idOtroCargo;
	}

	public void setIdOtroCargo(int idOtroCargo) {
		this.idOtroCargo = idOtroCargo;
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

	public Cotizacion getCotizacion() {
		return this.cotizacion;
	}

	public void setCotizacion(Cotizacion cotizacion) {
		this.cotizacion = cotizacion;
	}

}