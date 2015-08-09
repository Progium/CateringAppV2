package com.progium.catering.contracts;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import com.progium.catering.pojo.CatalogoProductoPOJO;

/**
* Esta clase se encarga de setear las variables que
* se le envian al controlador de javascript.
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/
public class CatalogoProductoResponse extends BaseResponse{
	
	private List<CatalogoProductoPOJO> catalogos;
	private int idCatalogo;
	
	public CatalogoProductoResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CatalogoProductoResponse(List<CatalogoProductoPOJO> catalogos,
			int idCatalogo) {
		super();
		this.catalogos = catalogos;
		this.idCatalogo = idCatalogo;
	}

	public List<CatalogoProductoPOJO> getCatalogos() {
		return catalogos;
	}

	public void setCatalogos(List<CatalogoProductoPOJO> catalogos) {
		this.catalogos = catalogos;
	}

	public int getIdCatalogo() {
		return idCatalogo;
	}

	public void setIdCatalogo(int idCatalogo) {
		this.idCatalogo = idCatalogo;
	}
	
}
