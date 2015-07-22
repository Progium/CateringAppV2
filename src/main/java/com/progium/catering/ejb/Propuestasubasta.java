package com.progium.catering.ejb;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the propuestasubasta database table.
 * 
 */
@Entity
@NamedQuery(name="Propuestasubasta.findAll", query="SELECT p FROM Propuestasubasta p")
public class Propuestasubasta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idPropuestaSubasta;

	//bi-directional many-to-one association to Subasta
	@ManyToOne
	@JoinColumn(name="subastaId")
	private Subasta subasta;

	//bi-directional many-to-one association to Paquete
	@ManyToOne
	@JoinColumn(name="paqueteId")
	private Paquete paquete;

	//bi-directional many-to-one association to Tipo
	@ManyToOne
	@JoinColumn(name="tipoTransaccionId")
	private Tipo tipo;

	public Propuestasubasta() {
	}

	public int getIdPropuestaSubasta() {
		return this.idPropuestaSubasta;
	}

	public void setIdPropuestaSubasta(int idPropuestaSubasta) {
		this.idPropuestaSubasta = idPropuestaSubasta;
	}

	public Subasta getSubasta() {
		return this.subasta;
	}

	public void setSubasta(Subasta subasta) {
		this.subasta = subasta;
	}

	public Paquete getPaquete() {
		return this.paquete;
	}

	public void setPaquete(Paquete paquete) {
		this.paquete = paquete;
	}

	public Tipo getTipo() {
		return this.tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

}