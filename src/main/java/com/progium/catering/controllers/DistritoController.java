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
 * @author Yuli
 *
 */

/**
 * Handles requests for the application home page.
 */
@RestController
@RequestMapping(value = "rest/protected/distrito")
public class DistritoController {

	@Autowired
	GeneralServiceInterface generalService;
	
	@RequestMapping(value ="/getAll", method = RequestMethod.GET)
	public DistritoResponse getAll(){
		
		DistritoResponse distrito = new DistritoResponse();
		
		List<Distrito> listaDistrito = generalService.getAllDistrito();
		List<DistritoPOJO> listaDistritoPojo = new ArrayList<DistritoPOJO>();
		
		for (Distrito dis : listaDistrito){
			DistritoPOJO nDistrito = new DistritoPOJO();
			PojoUtils.pojoMappingUtility(nDistrito,dis);
			listaDistritoPojo.add(nDistrito);
		}
		
		distrito.setListaDistrito(listaDistritoPojo);
		
		return distrito;		
	}
	
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
