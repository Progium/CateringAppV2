package com.progium.catering.contracts;

import java.util.List;

import com.progium.catering.pojo.PropuestaSubastaPOJO;

/**
* Esta clase se encarga de setear las variables que
* se le envian al controlador de javascript.
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/

public class PropuestaResponse extends BaseResponse{
	
	private List<PropuestaSubastaPOJO> propuestas;
	private PropuestaSubastaPOJO propuesta;
	private int idPropuesta;

	public List<PropuestaSubastaPOJO> getPropuestas() {
		return propuestas;
	}
	public void setPropuestas(List<PropuestaSubastaPOJO> propuestas) {
		this.propuestas = propuestas;
	}
	public PropuestaSubastaPOJO getPropuesta() {
		return propuesta;
	}
	public void setPropuesta(PropuestaSubastaPOJO propuesta) {
		this.propuesta = propuesta;
	}
	public int getIdPropuesta() {
		return idPropuesta;
	}
	public void setIdPropuesta(int idPropuesta) {
		this.idPropuesta = idPropuesta;
	}
	
}
