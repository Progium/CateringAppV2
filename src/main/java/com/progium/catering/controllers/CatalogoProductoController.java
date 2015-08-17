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
import org.springframework.data.domain.Page;
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
		int idCat = catalogoProductoRequest.getCateringId().get(0);
		List<Catalogoproducto> listaCatalogoProducto = catalogoProductoService.getCatalogoProductoByIdCatering(catalogoProductoRequest.getCateringId().get(0));
		List<CatalogoProductoPOJO> listaCatalogoProductoPOJO = new ArrayList<CatalogoProductoPOJO>();
		
		for (Catalogoproducto catProd : listaCatalogoProducto){
			CatalogoProductoPOJO nCatalogoProd = new CatalogoProductoPOJO();
			
			nCatalogoProd.setIdCatalogoProducto(catProd.getIdCatalogoProducto());
			nCatalogoProd.setCateringId(catProd.getCatering().getIdCatering());
			nCatalogoProd.setProductoId(catProd.getProducto().getIdProducto());
			nCatalogoProd.setPrecio(catProd.getPrecio());
			
			listaCatalogoProductoPOJO.add(nCatalogoProd);
		}
		
		catalogoProductoResponse.setCatalogos(listaCatalogoProductoPOJO);
		
		return catalogoProductoResponse;
	}
	
	/**
	* Este  metodo se encarga de retornar un tipo de evento.
	*
	* @param  catalogoProductoRequest
	* 
	* @return catalogoProductoResponse
	*
	*/
	@RequestMapping(value ="/getCatalogoProducto", method = RequestMethod.POST)
	public CatalogoProductoResponse getCatalogoProducto(@RequestBody CatalogoProductoRequest catalogoProductoRequest)throws NoSuchAlgorithmException {
		
		CatalogoProductoResponse catalogoProductoResponse = new CatalogoProductoResponse();
		List<CatalogoProductoPOJO> listaCatalogoProductoPOJO = new ArrayList<CatalogoProductoPOJO>();
		
		for(int i = 0; i < catalogoProductoRequest.getCatalogoProducto().size(); i++){
			Catalogoproducto catalogoProducto = catalogoProductoService.getCatalogoProductoById(catalogoProductoRequest.getCatalogoProducto().get(i));		
			CatalogoProductoPOJO nCatalogoProd = new CatalogoProductoPOJO();
			
			nCatalogoProd.setIdCatalogoProducto(catalogoProducto.getIdCatalogoProducto());
			nCatalogoProd.setCateringId(catalogoProducto.getCatering().getIdCatering());
			nCatalogoProd.setProductoId(catalogoProducto.getProducto().getIdProducto());
			nCatalogoProd.setPrecio(catalogoProducto.getPrecio());
			
			listaCatalogoProductoPOJO.add(nCatalogoProd);
		}
		
		catalogoProductoResponse.setCatalogos(listaCatalogoProductoPOJO);
		
		return catalogoProductoResponse;
	}
	
	/**
	* Este  metodo se encarga de retornar el catalogo del catering.
	*
	* @param  catalogoProductoRequest
	* 
	* @return catalogoProductoResponse
	*
	*/
	@RequestMapping(value ="/getCatalogoProductoByCatering", method = RequestMethod.POST)
	public CatalogoProductoResponse getCatalogoProductoByCatering(@RequestBody CatalogoProductoRequest catalogoProductoRequest)throws NoSuchAlgorithmException {
		
		catalogoProductoRequest.setPageNumber(catalogoProductoRequest.getPageNumber() - 1);
		
		CatalogoProductoResponse catalogoProductoResponse = new CatalogoProductoResponse();
		
		Page<Catalogoproducto> catalogoProductos = catalogoProductoService.getCatalogoProductoByIdCatering(catalogoProductoRequest);
		List<CatalogoProductoPOJO> listaCatalogoProductoPOJO = new ArrayList<CatalogoProductoPOJO>();
		
		catalogoProductoResponse.setCode(200);
		catalogoProductoResponse.setCodeMessage("catalogos fetch success");
		catalogoProductoResponse.setTotalElements(catalogoProductos.getTotalElements());
		catalogoProductoResponse.setTotalPages(catalogoProductos.getTotalPages());
		
		//Recorre por cada catalogo producto obtiene y setea los datos en el pojo.
		
		catalogoProductos.getContent().forEach(catalogoProducto->{
			
			CatalogoProductoPOJO nCatalogoProd = new CatalogoProductoPOJO();
			
			nCatalogoProd.setIdCatalogoProducto(catalogoProducto.getIdCatalogoProducto());
			nCatalogoProd.setCateringId(catalogoProducto.getCatering().getIdCatering());
			nCatalogoProd.setProductoId(catalogoProducto.getProducto().getIdProducto());
			nCatalogoProd.setPrecio(catalogoProducto.getPrecio());
			
			listaCatalogoProductoPOJO.add(nCatalogoProd);
		});
		
		catalogoProductoResponse.setCatalogos(listaCatalogoProductoPOJO);
		
		return catalogoProductoResponse;
	}
}
