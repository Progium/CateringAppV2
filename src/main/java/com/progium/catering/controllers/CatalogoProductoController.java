package com.progium.catering.controllers;

import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.progium.catering.contracts.CatalogoProductoRequest;
import com.progium.catering.contracts.CatalogoProductoResponse;
import com.progium.catering.contracts.CateringResponse;
import com.progium.catering.ejb.Catalogoproducto;
import com.progium.catering.ejb.Producto;
import com.progium.catering.ejb.Catering;
import com.progium.catering.services.CataloProductoServiceInterface;
import com.progium.catering.services.GeneralServiceInterface;
import com.progium.catering.utils.Utils;

@RestController
@RequestMapping(value = "rest/protected/catalogo")
public class CatalogoProductoController {
	
	@Autowired
	CataloProductoServiceInterface catalogoProductoService;

	@Autowired
	GeneralServiceInterface generalService;

	@Autowired
	ServletContext servletContext;
	
	@Autowired
	HttpServletRequest request;	

	public CatalogoProductoController() {
		// TODO Auto-generated constructor stub
	}
	
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@Transactional
	public CatalogoProductoResponse create(@RequestBody CatalogoProductoRequest catalogoProductoRequest)throws NoSuchAlgorithmException {
		
		CatalogoProductoResponse cs = new CatalogoProductoResponse();
		Producto objProducto = generalService.getProductoById(catalogoProductoRequest.getProductoId());
		
		for(int i = 0; i<catalogoProductoRequest.getCateringId().size(); i++){
			Catering objCatering = generalService.getCateringById(catalogoProductoRequest.getCateringId().get(i));
			Catalogoproducto objNuevoCataloProducto = new Catalogoproducto();
			objNuevoCataloProducto.setCatering(objCatering);
			objNuevoCataloProducto.setProducto(objProducto);
			objNuevoCataloProducto.setPrecio(catalogoProductoRequest.getPrecio());
			objNuevoCataloProducto.setEstado(false);

			Boolean state = catalogoProductoService.saveCatalogoProducto(objNuevoCataloProducto);
			
			if (state) {
				cs.setCode(200);
				cs.setCodeMessage("catalogo producto created succesfully");
				cs.setIdCatalogo(objNuevoCataloProducto.getIdCatalogoProducto());

			}else{
				cs.setCode(401);
				cs.setErrorMessage("Unauthorized User");
			}
			
		}
		
		return cs;
	}
	
	@RequestMapping(value = "/subirFoto", method = RequestMethod.POST)
	@Transactional
	public CatalogoProductoResponse subirFoto(@RequestParam("file") MultipartFile file,
			@RequestParam("IdCatalogoProducto") int idCatalogoProducto)
			throws NoSuchAlgorithmException {
		
		CatalogoProductoResponse cs = new CatalogoProductoResponse();
		Catalogoproducto objCatalogoProducto = catalogoProductoService.getCatalogoProductoById(idCatalogoProducto);
		String resultFileName = Utils.writeToFile(file, servletContext);

		objCatalogoProducto.setFotografia(resultFileName);
		Boolean state = catalogoProductoService.saveCatalogoProducto(objCatalogoProducto);
		if (state) {
			cs.setCode(200);
			cs.setCodeMessage("catalogo producto created succesfully");

		}else{
			cs.setCode(401);
			cs.setErrorMessage("Unauthorized User");
		}
		return cs;
	}
	
	
}
