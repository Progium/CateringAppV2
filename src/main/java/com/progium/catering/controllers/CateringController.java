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
import com.progium.catering.contracts.CateringResponse;
import com.progium.catering.contracts.CateringRequest;
import com.progium.catering.contracts.UsuarioResponse;
import com.progium.catering.contracts.ProvinciaResponse;
import com.progium.catering.contracts.CantonResponse;
import com.progium.catering.contracts.DistritoResponse;
import com.progium.catering.ejb.Provincia;
import com.progium.catering.ejb.Canton;
import com.progium.catering.ejb.Distrito;
import com.progium.catering.ejb.Catering;
import com.progium.catering.ejb.Tipo;
import com.progium.catering.ejb.Usuario;
import com.progium.catering.pojo.CateringPOJO;
import com.progium.catering.services.GeneralServiceInterface;
import com.progium.catering.services.UsuarioServiceInterface;
import com.progium.catering.services.CateringServiceInterface;
import com.progium.catering.utils.GeneradorContrasennaUtil;
import com.progium.catering.utils.SendEmail;
import com.progium.catering.utils.Utils;
import com.progium.catering.utils.PojoUtils;

/**
 * Handles requests for the application home page.
 */
@RestController
@RequestMapping(value = "rest/protected/catering")
public class CateringController {

	@Autowired
	CateringServiceInterface cateringService;

	@Autowired
	GeneralServiceInterface generalService;
	
	@Autowired
	UsuarioServiceInterface usuarioService;

	@Autowired
	ServletContext servletContext;
	
	@Autowired
	HttpServletRequest request;	

	public CateringController() {
		// TODO Auto-generated constructor stub
	}
	
	//Obtiene los parametros que le envia el controller por medio del metodo post.
	@RequestMapping(value = "/registrarFoto", method = RequestMethod.POST)
	@Transactional
	public CateringResponse registrarFoto(@RequestParam("file") MultipartFile file,
			@RequestParam("idCatering") int idCatering)
			throws NoSuchAlgorithmException {
		//Busca al catering que se acaba de crear y le agrega la foto.
		CateringResponse cs = new CateringResponse();
		Catering objCatering = cateringService.getCateringById(idCatering);
		String resultFileName = Utils.writeToFile(file, servletContext);

		objCatering.setFotografia(resultFileName);
		Boolean state = cateringService.saveCatering(objCatering);
		if (state) {
			cs.setCode(200);
			cs.setCodeMessage("catering created succesfully");

		}else{
			cs.setCode(401);
			cs.setErrorMessage("Unauthorized User");
		}
		return cs;
	}

	
	//Obtiene los parametros que le envia el controller por medio del metodo post.
	@RequestMapping(value = "/registrar", method = RequestMethod.POST)
	@Transactional
	public CateringResponse registrar(@RequestBody CateringRequest cateringRequest)throws NoSuchAlgorithmException {
		//Crea un nuevo usuario response le setea los datos y le pasa el objeto de catering al servicio de usuario
		CateringResponse cs = new CateringResponse();
		Usuario objUsuario = generalService.getUsuarioById(cateringRequest.getAdministradorId());
		Distrito objDistrito = generalService.getDistritoById(cateringRequest.getDistritoId());

		Catering objNuevoCatering = new Catering();
		objNuevoCatering.setUsuario(objUsuario);
		objNuevoCatering.setNombre(cateringRequest.getNombre());
		objNuevoCatering.setCedulaJuridica(cateringRequest.getCedulaJuridica());
		objNuevoCatering.setDireccion(cateringRequest.getDireccion());
		objNuevoCatering.setTelefono1(cateringRequest.getTelefono1());
		objNuevoCatering.setTelefono2(cateringRequest.getTelefono2());
		objNuevoCatering.setHorario(cateringRequest.getHorario());
		objNuevoCatering.setProvinciaId(cateringRequest.getProvinciaId());
		objNuevoCatering.setCantonId(cateringRequest.getCantonId());
		objNuevoCatering.setDistrito(objDistrito);
		objNuevoCatering.setEstado(false);

		Boolean state = cateringService.saveCatering(objNuevoCatering);
		
		if (state) {
			cs.setCode(200);
			cs.setCodeMessage("catering created succesfully");
			cs.setIdCatering(objNuevoCatering.getIdCatering());

		}else{
			cs.setCode(401);
			cs.setErrorMessage("Unauthorized User");
		}
		return cs;
	}
	
	
	@RequestMapping(value ="/getCaterigLista", method = RequestMethod.POST)
	public CateringResponse getCaterigLista(@RequestBody CateringRequest cateringRequest) throws NoSuchAlgorithmException{
		
		CateringResponse catering = new CateringResponse();
		
		
		List<Catering> listaCatering = cateringService.getCateringByIdAdministrador(cateringRequest.getAdministradorId());
		List<CateringPOJO> listaCateringPojo = new ArrayList<CateringPOJO>();
		
		for (Catering cat : listaCatering){
			CateringPOJO nCatering = new CateringPOJO();
			PojoUtils.pojoMappingUtility(nCatering,cat);
			listaCateringPojo.add(nCatering);
		}
		
		catering.setCaterings(listaCateringPojo);
		
		return catering;	
		
	}

	
	@RequestMapping(value ="/getAll", method = RequestMethod.GET)
	public CateringResponse getCaterigLista(){
		
		CateringResponse catering = new CateringResponse();
		
		HttpSession currentSession = request.getSession();
		int idUsuario = (int) currentSession.getAttribute("idUsuario");	
		List<Catering> listaCatering = cateringService.getCateringByIdAdministrador(idUsuario);
		List<CateringPOJO> listaCateringPojo = new ArrayList<CateringPOJO>();
		
		for (Catering cat : listaCatering){
			CateringPOJO nCatering = new CateringPOJO();
			PojoUtils.pojoMappingUtility(nCatering,cat);
			listaCateringPojo.add(nCatering);
		}
		
		catering.setCaterings(listaCateringPojo);
		
		return catering;	
		
	}
}
