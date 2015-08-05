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
 * @author Yuli
 *
 */

/**
 * Handles requests for the application home page.
 */
@RestController
@RequestMapping(value = "rest/protected/canton")
public class CantonController {

	@Autowired
	GeneralServiceInterface generalService;
	
	@RequestMapping(value ="/getAll", method = RequestMethod.GET)
	public CantonResponse getAll(){
		
		CantonResponse canton = new CantonResponse();
		
		List<Canton> listaCanton = generalService.getAllCanton();
		List<CantonPOJO> listaCantonPojo = new ArrayList<CantonPOJO>();
		
		for (Canton can : listaCanton){
			CantonPOJO nCanton = new CantonPOJO();
			PojoUtils.pojoMappingUtility(nCanton,can);
			listaCantonPojo.add(nCanton);
		}
		
		canton.setListaCanton(listaCantonPojo);
		
		return canton;		
	}

	@RequestMapping(value ="/getCantonByProvincia", method = RequestMethod.POST)
	public CantonResponse getCantonByProvincia(@RequestBody CantonRequest cantonRequest) throws NoSuchAlgorithmException{
		
		CantonResponse canton = new CantonResponse();
		
		List<Canton> listaCanton = generalService.getCantonByProvincia(cantonRequest.getProvinciaId());
		List<CantonPOJO> listaCantonPojo = new ArrayList<CantonPOJO>();
		
		for (Canton can : listaCanton){
			CantonPOJO nCanton = new CantonPOJO();
			PojoUtils.pojoMappingUtility(nCanton,can);
			listaCantonPojo.add(nCanton);
		}
		
		canton.setListaCanton(listaCantonPojo);
		
		return canton;		
	}
	
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
