package com.progium.catering.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progium.catering.ejb.Tipo;
import com.progium.catering.ejb.Usuario;
import com.progium.catering.ejb.Provincia;
import com.progium.catering.ejb.Canton;
import com.progium.catering.ejb.Distrito;
import com.progium.catering.repositories.GeneralRepository;
import com.progium.catering.repositories.TipoRepository;
import com.progium.catering.repositories.ProvinciaRepository;
import com.progium.catering.repositories.CantonRepository;
import com.progium.catering.repositories.DistritoReposity;
import com.progium.catering.repositories.UsuarioRepository;;

@Service
public class GeneralService implements GeneralServiceInterface{		
	
	@Autowired
	GeneralRepository generalRepository;
	
	@Autowired
	TipoRepository tipoRepository;
	
	@Autowired
	ProvinciaRepository provinciaRepository;
	
	@Autowired
	CantonRepository cantonRepository;
	
	@Autowired
	DistritoReposity distritoRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public List<Tipo> getAllTipo() {
		return tipoRepository.findAll();
	}

	@Override
	public List<Tipo> getTipoByDescripcion(String descripcion) {
		return tipoRepository.findTipoByDescripcion(descripcion);
	}
	
	@Override
	public Tipo getTipoById(Integer tipoUsuarioId) {
		return tipoRepository.findOne(tipoUsuarioId);
	}

	@Override
	public Usuario getUsuarioById(Integer idUsuario) {
		return usuarioRepository.findOne(idUsuario);
	}
	
	@Override
	public List<Provincia> getAllProvincia() {
		return provinciaRepository.findAll();
	}
	
	@Override
	public Provincia getProvinciaById(Integer idProvincia) {
		return provinciaRepository.findOne(idProvincia);
	}

	@Override
	public List<Canton> getAllCanton() {
		return cantonRepository.findAll();
	}
	
	@Override
	public Canton getCantonById(Integer idCanton) {
		return cantonRepository.findOne(idCanton);
	}
	
	@Override
	public List<Canton> getCantonByProvincia(Integer idProvincia) {
		return cantonRepository.findCantonByProvincia(idProvincia);
	}
	
	@Override
	public List<Distrito> getAllDistrito() {
		return distritoRepository.findAll();
	}
	
	@Override
	public Distrito getDistritoById(Integer idDistrito) {
		return distritoRepository.findOne(idDistrito);
	}
}