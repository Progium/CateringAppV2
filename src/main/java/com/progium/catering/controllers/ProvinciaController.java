/**
 * 
 */
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

import com.progium.catering.contracts.ProvinciaResponse;
import com.progium.catering.ejb.Provincia;
import com.progium.catering.pojo.ProvinciaPOJO;
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
@RequestMapping(value = "rest/protected/provincia")
public class ProvinciaController {

	@Autowired
	GeneralServiceInterface generalService;
	
	@RequestMapping(value ="/getAll", method = RequestMethod.GET)
	public ProvinciaResponse getAll(){
		
		ProvinciaResponse provincia = new ProvinciaResponse();
		
		List<Provincia> listaProvincia = generalService.getAllProvincia();
		List<ProvinciaPOJO> listaProvinciaPojo = new ArrayList<ProvinciaPOJO>();
		
		for (Provincia prov : listaProvincia){
			ProvinciaPOJO nProvincia = new ProvinciaPOJO();
			PojoUtils.pojoMappingUtility(nProvincia,prov);
			listaProvinciaPojo.add(nProvincia);
		}
		
		provincia.setListaProvincia(listaProvinciaPojo);
		
		return provincia;		
	}

}
