package com.progium.catering.pojo;
import java.util.List;

/**
* Esta clase se encarga de crear el objeto catering
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/
public class CateringPOJO {

	private int idCatering;
	private String nombre;
	private String cedulaJuridica;
	private String direccion;
	private String telefono1;
	private String telefono2;
	private String horario;
	private boolean estado;
	private String fotografia;
	private Integer provinciaId;
	private Integer cantonId;
	private Integer administradorId;
	private Integer distritoId;
	private List<Integer> tipoEvento;
	
	
	public CateringPOJO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdCatering() {
		return idCatering;
	}

	public void setIdCatering(int idCatering) {
		this.idCatering = idCatering;
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

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getFotografia() {
		return fotografia;
	}

	public void setFotografia(String fotografia) {
		this.fotografia = fotografia;
	}

	public Integer getProvinciaId() {
		return provinciaId;
	}

	public void setProvinciaId(Integer provinciaId) {
		this.provinciaId = provinciaId;
	}

	public Integer getCantonId() {
		return cantonId;
	}

	public void setCantonId(Integer cantonId) {
		this.cantonId = cantonId;
	}

	public Integer getAdministradorId() {
		return administradorId;
	}

	public void setAdministradorId(Integer administradorId) {
		this.administradorId = administradorId;
	}

	public Integer getDistritoId() {
		return distritoId;
	}

	public void setDistritoId(Integer distritoId) {
		this.distritoId = distritoId;
	}

	public List<Integer> getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(List<Integer> tipoEvento) {
		this.tipoEvento = tipoEvento;
	}
}
