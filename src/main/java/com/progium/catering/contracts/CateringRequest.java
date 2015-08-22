package com.progium.catering.contracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

/**
* Esta clase se encarga de setear las variables 
* para realizar peticiones al controlador.
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/
public class CateringRequest extends BasePagingRequest {

	private int idCatering;
	private int administradorId;
	private String nombre;
	private String cedulaJuridica;
	private String direccion;
	private String telefono1;
	private String telefono2;
	private String horario;
	private int provinciaId;
	private int cantonId;
	private int distritoId;
	private String needAccess;
	private MultipartFile file;
	private List<Integer> tipoEvento;
	
	public CateringRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CateringRequest(int administradorId, String nombre, String cedulaJuridica, String direccion, String telefono1, String telefono2,
			String horario,int provinciaId, int cantonId, int distritoId, String needAccess, MultipartFile file, List<Integer> tipoEvento) {
		super();
		this.setAdministradorId(administradorId);
		this.setNombre(nombre);
		this.setCedulaJuridica(cedulaJuridica);
		this.setDireccion(direccion);
		this.setTelefono1(telefono1);
		this.setTelefono2(telefono2);
		this.setHorario(horario);
		this.setProvinciaId(provinciaId);
		this.setCantonId(cantonId);
		this.setDistritoId(distritoId);
		this.setNeedAccess(needAccess);
		this.setFile(file);
		this.setTipoEvento(tipoEvento);
	}

	public CateringRequest(int idCatering) {
		super();
		this.setIdCatering(idCatering);
	}
	
	public int getAdministradorId() {
		return administradorId;
	}

	public void setAdministradorId(int administradorId) {
		this.administradorId = administradorId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCedulaJuridica() {
		return cedulaJuridica;
	}

	public void setCedulaJuridica(String cedulaJuridica) {
		this.cedulaJuridica = cedulaJuridica;
	}
	
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono1() {
		return telefono1;
	}

	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}

	public String getTelefono2() {
		return telefono2;
	}

	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public int getProvinciaId() {
		return provinciaId;
	}

	public void setProvinciaId(int provinciaId) {
		this.provinciaId = provinciaId;
	}

	public int getCantonId() {
		return cantonId;
	}

	public void setCantonId(int cantonId) {
		this.cantonId = cantonId;
	}

	public int getDistritoId() {
		return distritoId;
	}

	public void setDistritoId(int distritoId) {
		this.distritoId = distritoId;
	}

	public String getNeedAccess() {
		return needAccess;
	}

	public void setNeedAccess(String needAccess) {
		this.needAccess = needAccess;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public List<Integer> getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(List<Integer> tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public int getIdCatering() {
		return idCatering;
	}

	public void setIdCatering(int idCatering) {
		this.idCatering = idCatering;
	}

}
