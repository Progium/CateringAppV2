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
import com.progium.catering.contracts.ProvinciaRequest;
import com.progium.catering.ejb.Provincia;
import com.progium.catering.pojo.ProvinciaPOJO;
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
@RequestMapping(value = "rest/protected/provincia")
public class ProvinciaController {

	@Autowired
	GeneralServiceInterface generalService;
	
	/**
	* Este  metodo se encarga de retornar todas las provincias.
	*
	* @return ProvinciaResponse
	*
	*/
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
	
	/**
	* Este  metodo se encarga de retornar una provincia de un determinado idprovincia.
	*
	* @param  provinciaRequest
	* 
	* @return ProvinciaResponse
	*
	*/
	@RequestMapping(value ="/getProvincia", method = RequestMethod.POST)
	public ProvinciaResponse getProvincia(@RequestBody ProvinciaRequest provinciaRequest)throws NoSuchAlgorithmException {
		
		ProvinciaResponse provinciaResponse = new ProvinciaResponse();
		
		Provincia provincia = generalService.getProvinciaById(provinciaRequest.getProvinciaId());
		ProvinciaPOJO provinciaPojo = new ProvinciaPOJO();
		
		PojoUtils.pojoMappingUtility(provinciaPojo,provincia);
		
		provinciaResponse.setProvincia(provinciaPojo);
		
		return provinciaResponse;		
	}

}
