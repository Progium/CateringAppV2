package com.progium.catering.pojo;

/**
* Esta clase se encarga de crear el objeto provincia
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/
public class ProvinciaPOJO{
	
	private int idProvincia;
	private String nombre;
		
	public ProvinciaPOJO() {
		super();
	}

	public int getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(int idProvincia) {
		this.idProvincia = idProvincia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}