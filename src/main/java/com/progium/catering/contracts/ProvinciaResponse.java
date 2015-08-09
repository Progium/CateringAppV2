package com.progium.catering.contracts;

import java.util.List;

import com.progium.catering.pojo.ProvinciaPOJO;

/**
* Esta clase se encarga de setear las variables que
* se le envian al controlador de javascript.
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/
public class ProvinciaResponse  extends BaseResponse{

	private List<ProvinciaPOJO> listaProvincia;
	private ProvinciaPOJO provincia;

	public ProvinciaResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<ProvinciaPOJO> getListaProvincia() {
		return listaProvincia;
	}

	public void setListaProvincia(List<ProvinciaPOJO> listaProvincia) {
		this.listaProvincia = listaProvincia;
	}

	public ProvinciaPOJO getProvincia() {
		return provincia;
	}

	public void setProvincia(ProvinciaPOJO provincia) {
		this.provincia = provincia;
	}

}
