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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.progium.catering.contracts.CantonResponse;
import com.progium.catering.contracts.CantonRequest;
import com.progium.catering.ejb.Canton;
import com.progium.catering.pojo.CantonPOJO;
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
@RequestMapping(value = "rest/protected/canton")
public class CantonController {

	@Autowired
	GeneralServiceInterface generalService;
	
	/**
	* Este  metodo se encarga de retornar la lista de cantones
	*
	* @return CantonResponse
	*
	*/
	@RequestMapping(value ="/getAll", method = RequestMethod.GET)
	public CantonResponse getAll(){
		
		CantonResponse cantonResponse = new CantonResponse();
		
		List<Canton> listaCanton = generalService.getAllCanton();
		List<CantonPOJO> listaCantonPojo = new ArrayList<CantonPOJO>();
		
		for (Canton can : listaCanton){
			CantonPOJO nCanton = new CantonPOJO();
			PojoUtils.pojoMappingUtility(nCanton,can);
			listaCantonPojo.add(nCanton);
		}
		
		cantonResponse.setListaCanton(listaCantonPojo);
		
		return cantonResponse;		
	}

	/**
	* Este  metodo se encarga de retornar los cantones por provincia 
	*
	* @param  cantonRequest
	* 
	* @return CantonResponse
	*
	*/
	@RequestMapping(value ="/getCantonByProvincia", method = RequestMethod.POST)
	public CantonResponse getCantonByProvincia(@RequestBody CantonRequest cantonRequest) throws NoSuchAlgorithmException{
		
		CantonResponse cantonResponse = new CantonResponse();
		
		List<Canton> listaCanton = generalService.getCantonByProvincia(cantonRequest.getProvinciaId());
		List<CantonPOJO> listaCantonPojo = new ArrayList<CantonPOJO>();
		
		for (Canton can : listaCanton){
			CantonPOJO nCanton = new CantonPOJO();
			PojoUtils.pojoMappingUtility(nCanton,can);
			listaCantonPojo.add(nCanton);
		}
		
		cantonResponse.setListaCanton(listaCantonPojo);
		
		return cantonResponse;		
	}
	
	/**
	* Este  metodo se encarga de retornar un canton por un determinado id canton
	*
	* @param  cantonRequest
	* 
	* @return CantonResponse
	*
	*/
	@RequestMapping(value ="/getCanton", method = RequestMethod.POST)
	public CantonResponse getCanton(@RequestBody CantonRequest cantonRequest)throws NoSuchAlgorithmException {
		
		CantonResponse cantonResponse = new CantonResponse();
		
		Canton canton = generalService.getCantonById(cantonRequest.getCantonId());
		CantonPOJO cantonPojo = new CantonPOJO();
		
		PojoUtils.pojoMappingUtility(cantonPojo,canton);
		
		cantonResponse.setCanton(cantonPojo);
		
		return cantonResponse;		
	}

}
