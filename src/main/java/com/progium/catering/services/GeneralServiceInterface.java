package com.progium.catering.services;

import java.util.List;

import com.progium.catering.ejb.Tipo;
import com.progium.catering.ejb.Provincia;
import com.progium.catering.ejb.Canton;
import com.progium.catering.ejb.Distrito;
import com.progium.catering.ejb.Usuario;
import com.progium.catering.ejb.Categoria;
import com.progium.catering.ejb.Producto;
import com.progium.catering.ejb.Catering;

/**
* Esta clase se encarga de exponer las funcionalidades 
* implementadas por el servicio
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/
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
	//Obtiene las categorias
	List<Categoria> getAllCategoria();
	//Obtiene la lista de productos y producto en especifico
	List<Producto> getAllProducto();
	Producto getProductoById(Integer idProducto);
	//Obtiene la lista de catering y catering en especifico
	List<Catering> getAllCatering();
	Catering getCateringById(Integer idCatering);
	
}
