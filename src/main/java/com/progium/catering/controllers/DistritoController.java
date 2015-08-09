package com.progium.catering.controllers;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.progium.catering.contracts.DistritoRequest;
import com.progium.catering.contracts.DistritoResponse;
import com.progium.catering.ejb.Distrito;
import com.progium.catering.pojo.DistritoPOJO;
import com.progium.catering.services.GeneralServiceInterface;
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
@RequestMapping(value = "rest/protected/distrito")
public class DistritoController {

	@Autowired
	GeneralServiceInterface generalService;
	
	/**
	* Este  metodo se encarga de mostrar todos los distritos
	*
	* @return DistritoResponse
	*
	*/
	@RequestMapping(value ="/getAll", method = RequestMethod.GET)
	public DistritoResponse getAll(){
		
		DistritoResponse distritoResponse = new DistritoResponse();
		
		List<Distrito> listaDistrito = generalService.getAllDistrito();
		List<DistritoPOJO> listaDistritoPojo = new ArrayList<DistritoPOJO>();
		
		for (Distrito dis : listaDistrito){
			DistritoPOJO nDistrito = new DistritoPOJO();
			PojoUtils.pojoMappingUtility(nDistrito,dis);
			listaDistritoPojo.add(nDistrito);
		}
		
		distritoResponse.setListaDistrito(listaDistritoPojo);
		
		return distritoResponse;		
	}
	
	/**
	* Este  metodo se encarga de retornar un distrito por un determinado id distrito
	*
	* @param  distritoRequest
	* 
	* @return DistritoResponse
	*
	*/
	@RequestMapping(value ="/getDistrito", method = RequestMethod.POST)
	public DistritoResponse getDistrito(@RequestBody DistritoRequest distritoRequest)throws NoSuchAlgorithmException {
		
		DistritoResponse distritoResponse = new DistritoResponse();
		
		Distrito distrito = generalService.getDistritoById(distritoRequest.getDistritoId());
		DistritoPOJO distritoPojo = new DistritoPOJO();
		
		PojoUtils.pojoMappingUtility(distritoPojo,distrito);
		
		distritoResponse.setDistrito(distritoPojo);
		
		return distritoResponse;		
	}

}
