package com.progium.catering.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the distrito database table.
 * 
 */
@Entity
@NamedQuery(name="Distrito.findAll", query="SELECT d FROM Distrito d")
public class Distrito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idDistrito;

	private String nombre;

	//bi-directional many-to-one association to Catering
	@OneToMany(mappedBy="distrito")
	private List<Catering> caterings;

	//bi-directional many-to-one association to Canton
	@ManyToOne
	@JoinColumn(name="cantonId")
	private Canton canton;

	public Distrito() {
	}

	public int getIdDistrito() {
		return this.idDistrito;
	}

	public void setIdDistrito(int idDistrito) {
		this.idDistrito = idDistrito;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Catering> getCaterings() {
		return this.caterings;
	}

	public void setCaterings(List<Catering> caterings) {
		this.caterings = caterings;
	}

	public Catering addCatering(Catering catering) {
		getCaterings().add(catering);
		catering.setDistrito(this);

		return catering;
	}

	public Catering removeCatering(Catering catering) {
		getCaterings().remove(catering);
		catering.setDistrito(null);

		return catering;
	}

	public Canton getCanton() {
		return this.canton;
	}

	public void setCanton(Canton canton) {
		this.canton = canton;
	}

}