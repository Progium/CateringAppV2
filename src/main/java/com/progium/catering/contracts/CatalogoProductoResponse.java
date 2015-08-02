package com.progium.catering.contracts;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import com.progium.catering.pojo.CatalogoProductoPOJO;

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
