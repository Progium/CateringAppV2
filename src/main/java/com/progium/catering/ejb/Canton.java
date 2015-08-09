package com.progium.catering.ejb;

import java.io.Serializable;
import javax.persistence.*;
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
@NamedQuery(name="Canton.findAll", query="SELECT c FROM Canton c")
public class Canton implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idCanton;

	private String nombre;

	//bi-directional many-to-one association to Provincia
	@ManyToOne
	@JoinColumn(name="provinciaId")
	private Provincia provincia;

	//bi-directional many-to-one association to Distrito
	@OneToMany(mappedBy="canton")
	private List<Distrito> distritos;

	public Canton() {
	}

	public int getIdCanton() {
		return this.idCanton;
	}

	public void setIdCanton(int idCanton) {
		this.idCanton = idCanton;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Provincia getProvincia() {
		return this.provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public List<Distrito> getDistritos() {
		return this.distritos;
	}

	public void setDistritos(List<Distrito> distritos) {
		this.distritos = distritos;
	}

	public Distrito addDistrito(Distrito distrito) {
		getDistritos().add(distrito);
		distrito.setCanton(this);

		return distrito;
	}

	public Distrito removeDistrito(Distrito distrito) {
		getDistritos().remove(distrito);
		distrito.setCanton(null);

		return distrito;
	}

}