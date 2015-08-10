package com.progium.catering.contracts;

/**
* Esta clase se encarga de setear las variables 
* para realizar peticiones al controlador.
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/
public class ProductoRequest extends BaseResponse {
	private int idProducto;
	
	public ProductoRequest() {
		super();
	 	// TODO Auto-generated constructor stub
	}
	
	public ProductoRequest(int idProducto) {
		super();
		this.setIdProducto(idProducto);
	}
	

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

 
}
