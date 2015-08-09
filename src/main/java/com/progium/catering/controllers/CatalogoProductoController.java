package com.progium.catering.controllers;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

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
import com.progium.catering.ejb.Catalogoproducto;
import com.progium.catering.ejb.Producto;
import com.progium.catering.ejb.Catering;
import com.progium.catering.pojo.CatalogoProductoPOJO;
import com.progium.catering.services.CataloProductoServiceInterface;
import com.progium.catering.services.GeneralServiceInterface;
import com.progium.catering.utils.PojoUtils;
import com.progium.catering.utils.Utils;

/**
* Esta clase se encarga de crear el controlador
* para el manejo de las diferentes funcionalidades 
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/
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
	
	/**
	* Este  metodo se encarga de registrar un catalogo producto.
	*
	* @param  catalogoProductoRequest
	* 
	* @return CatalogoProductoResponse
	*
	*/
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
	
	/**
	* Este  metodo se encarga de registrar una fotogarfia 
	*
	* @param  file
	* @param  idCatalogoProducto
	* 
	* @return CatalogoProductoResponse
	*
	*/
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
	
	
	/**
	* Este  metodo se encarga de retornar un tipo de evento.
	*
	* @param  tipoRequest
	* 
	* @return TipoResponse
	*
	*/
	@RequestMapping(value ="/getCatalogoByCatering", method = RequestMethod.POST)
	public CatalogoProductoResponse getTipo(@RequestBody CatalogoProductoRequest catalogoProductoRequest)throws NoSuchAlgorithmException {
		
		CatalogoProductoResponse catalogoProductoResponse = new CatalogoProductoResponse();
		
		List<Catalogoproducto> listaCatalogoproducto = catalogoProductoService.getCatalogoProductoByIdCatering(catalogoProductoRequest.getCateringId().get(0));
		List<CatalogoProductoPOJO> listaCatalogoProductoPOJO = new ArrayList<CatalogoProductoPOJO>();
		
		for (Catalogoproducto catProd : listaCatalogoproducto){
			CatalogoProductoPOJO nCatalogoProd = new CatalogoProductoPOJO();
			PojoUtils.pojoMappingUtility(nCatalogoProd,catProd);
			listaCatalogoProductoPOJO.add(nCatalogoProd);
		}
		
		catalogoProductoResponse.setCatalogos(listaCatalogoProductoPOJO);
		
		return catalogoProductoResponse;
	}
}
