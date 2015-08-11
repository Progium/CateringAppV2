package com.progium.catering.controllers;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.progium.catering.ejb.Catering;
import com.progium.catering.ejb.Paqueteproducto;
import com.progium.catering.ejb.Paquete;
import com.progium.catering.ejb.Tipo;
import com.progium.catering.ejb.Catalogoproducto;
import com.progium.catering.contracts.PaqueteResponse;
import com.progium.catering.contracts.PaqueteRequest;
import com.progium.catering.services.CateringServiceInterface;
import com.progium.catering.services.GeneralServiceInterface;
import com.progium.catering.services.PaqueteServiceInterface;
import com.progium.catering.services.PaqueteProductoServiceInterface;
import com.progium.catering.services.CataloProductoServiceInterface;
import com.progium.catering.pojo.PaquetePOJO;
import com.progium.catering.utils.PojoUtils;

/**
* Esta clase se encarga de crear el controlador
* para el manejo de las diferentes funcionalidades 
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/
@RestController
@RequestMapping(value = "rest/protected/paquete")
public class PaqueteController {
	
	@Autowired
	PaqueteServiceInterface paqueteService;
	
	@Autowired
	PaqueteProductoServiceInterface paqueteProductoService;
	
	@Autowired
	GeneralServiceInterface generalService;
		
	@Autowired
	CateringServiceInterface cateringService;
	
	@Autowired
	CataloProductoServiceInterface catalogoProductoService;
	
	@Autowired
	HttpServletRequest request;	
	
	/**
	* Este  metodo se encarga de registrar un paquete de evento 
	*
	* @param  PaqueteRequest
	* 
	* @return PaqueteResponse
	*
	*/
	@RequestMapping(value = "/registrar", method = RequestMethod.POST)
	@Transactional
	public PaqueteResponse registrar(@RequestBody PaqueteRequest paqueteRequest)throws NoSuchAlgorithmException {
		//Crea un nuevo usuario response le setea los datos y le pasa el objeto de catering al servicio de usuario
		PaqueteResponse pr = new PaqueteResponse();
		Catering objCatering = cateringService.getCateringById(paqueteRequest.getCateringId());
		Tipo objTipo = generalService.getTipoById(paqueteRequest.getEventoId());
		
		Paquete objNuevoPaquete = new Paquete();
		objNuevoPaquete.setNombre(paqueteRequest.getNombre());
		objNuevoPaquete.setDescripcion(paqueteRequest.getDescripcion());
		objNuevoPaquete.setDescripcion(paqueteRequest.getDescripcion());
		objNuevoPaquete.setCantidadPersonas(paqueteRequest.getCantidadPersonas());
		objNuevoPaquete.setPrecio(paqueteRequest.getPrecio());
		objNuevoPaquete.setDescuento(paqueteRequest.getDescuento());
		objNuevoPaquete.setMontoTotal(paqueteRequest.getMontoTotal());
		objNuevoPaquete.setCatering(objCatering);
		objNuevoPaquete.setTipo(objTipo);
		
		Boolean state = paqueteService.savePaquete(objNuevoPaquete);
		
		if (state) {
			pr.setCode(200);
			for(int i = 0; i < paqueteRequest.getCatalogoProducto().size(); i++){
				Paqueteproducto objNuevoPaqueteProducto = new Paqueteproducto();
				Catalogoproducto objCatalogoProducto = catalogoProductoService.getCatalogoProductoById(paqueteRequest.getCatalogoProducto().get(i));
				objNuevoPaqueteProducto.setPaquete(objNuevoPaquete);
				objNuevoPaqueteProducto.setCatalogoproducto(objCatalogoProducto);
				
				Boolean statePaqueteProducto = paqueteProductoService.savePaqueteProducto(objNuevoPaqueteProducto);
			}
			pr.setCodeMessage("catering created succesfully");

		}else{
			pr.setCode(401);
			pr.setErrorMessage("Unauthorized User");
		}
		return pr;
	}
	
	
}