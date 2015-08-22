package com.progium.catering.pojo;

/**
* Esta clase se encarga de crear el objeto detalle cotizacion
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/
public class DetalleCotizacionPOJO {
	
	private int idDetalleCotizacion;
	private Integer cotizacionId;
	private Integer productosId;
	
	public DetalleCotizacionPOJO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdDetalleCotizacion() {
		return idDetalleCotizacion;
	}
	
	public void setIdDetalleCotizacion(int idDetalleCotizacion) {
		this.idDetalleCotizacion = idDetalleCotizacion;
	}
	
	public Integer getCotizacionId() {
		return cotizacionId;
	}
	
	public void setCotizacionId(Integer cotizacionId) {
		this.cotizacionId = cotizacionId;
	}
	
	public Integer getProductosId() {
		return productosId;
	}
	
	public void setProductosId(Integer productosId) {
		this.productosId = productosId;
	}
	
	
}
