package com.progium.catering.services;

import java.util.List;

import com.progium.catering.ejb.Tipo;
import com.progium.catering.ejb.Provincia;
import com.progium.catering.ejb.Canton;
import com.progium.catering.ejb.Distrito;
import com.progium.catering.ejb.Usuario;

public interface GeneralServiceInterface {

	List<Tipo> getAllTipo();
	Tipo getTipoById(Integer idTipoUsuario);
	List<Tipo> getTipoByDescripcion(String descripcion);
	//Obtiene una lista de provincias
	List<Provincia> getAllProvincia();
	Provincia getProvinciaById(Integer idProvincia);
	//Obtiene una lista de cantones
	List<Canton> getAllCanton();
	Canton getCantonById(Integer idCanton);
	List<Canton> getCantonByProvincia(Integer idProvincia);
	//Obtiene una lista de distritos
	List<Distrito> getAllDistrito();
	Distrito getDistritoById(Integer idDistrito);
	//Obtiene un objeto usuario
	Usuario getUsuarioById(Integer idUsuario);
}
