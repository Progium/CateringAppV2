package com.progium.catering.ejb;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the eventocatering database table.
 * 
 */
@Entity
@NamedQuery(name="Eventocatering.findAll", query="SELECT e FROM Eventocatering e")
public class Eventocatering implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idEventoCatering;

	//bi-directional many-to-one association to Catering
	@ManyToOne
	@JoinColumn(name="cateringId")
	private Catering catering;

	//bi-directional many-to-one association to Tipo
	@ManyToOne
	@JoinColumn(name="eventoId")
	private Tipo tipo;

	public Eventocatering() {
	}

	public int getIdEventoCatering() {
		return this.idEventoCatering;
	}

	public void setIdEventoCatering(int idEventoCatering) {
		this.idEventoCatering = idEventoCatering;
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

}