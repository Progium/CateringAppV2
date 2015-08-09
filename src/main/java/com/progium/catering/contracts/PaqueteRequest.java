package com.progium.catering.contracts;

import com.progium.catering.pojo.PaquetePOJO;

/**
* Esta clase se encarga de setear las variables 
* para realizar peticiones al controlador.
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/
public class PaqueteRequest extends BaseResponse {
	 private PaquetePOJO paquete;

	 public PaqueteRequest() {
			super();
			// TODO Auto-generated constructor stub
		 }
	 
	 public PaquetePOJO getPaquete() {
		return paquete;
	}

	public void setPaquete(PaquetePOJO paquete) {
		this.paquete = paquete;
	}

}