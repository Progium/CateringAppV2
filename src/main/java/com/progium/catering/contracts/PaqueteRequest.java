package com.progium.catering.contracts;

import com.progium.catering.pojo.PaquetePOJO;

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