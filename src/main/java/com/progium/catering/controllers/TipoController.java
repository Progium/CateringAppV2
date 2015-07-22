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

import com.progium.catering.contracts.TipoResponse;
import com.progium.catering.ejb.Tipo;
import com.progium.catering.pojo.TipoPOJO;
import com.progium.catering.services.GeneralServiceInterface;
import com.progium.catering.utils.PojoUtils;

/**
 * Handles requests for the application home page.
 */
@RestController
@RequestMapping(value = "rest/protected/tipo")
public class TipoController {

	@Autowired
	GeneralServiceInterface generalService;
	
	@RequestMapping(value ="/getTipoEvento", method = RequestMethod.GET)
	public TipoResponse getTipoEvento(){
		
		TipoResponse tipo = new TipoResponse();
		
		List<Tipo> listaEvento = generalService.getTipoByDescripcion("tipo evento");
		List<TipoPOJO> listaTipoPojo = new ArrayList<TipoPOJO>();
		
		for (Tipo tip : listaEvento){
			TipoPOJO nTipo = new TipoPOJO();
			PojoUtils.pojoMappingUtility(nTipo,tip);
			listaTipoPojo.add(nTipo);
		}
		
		tipo.setTipos(listaTipoPojo);
		
		return tipo;		
	}

}
