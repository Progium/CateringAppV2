package com.progium.catering.pojo;

import com.progium.catering.ejb.Provincia;

/**
* Esta clase se encarga de crear el objeto canton
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/
public class CantonPOJO {
	
	private int idCanton;
	private String nombre;
	private Provincia provincia;
	private int idProvincia;
	
	public CantonPOJO() {
		super();
	}

	public int getIdCanton() {
		return idCanton;
	}

	public void setIdCanton(int idCanton) {
		this.idCanton = idCanton;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	public int getProvincia() {
		this.idProvincia = this.provincia.getIdProvincia();
		return idProvincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
		setIdProvincia(this.provincia);
	}
	
	public void setIdProvincia(Provincia provincia) {
		this.idProvincia = provincia.getIdProvincia();
	}
}

