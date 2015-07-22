package com.progium.catering.ejb;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the reservapaquete database table.
 * 
 */
@Entity
@NamedQuery(name="Reservapaquete.findAll", query="SELECT r FROM Reservapaquete r")
public class Reservapaquete implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idReservaPaquete;

	//bi-directional many-to-one association to Paquete
	@ManyToOne
	@JoinColumn(name="paqueteId")
	private Paquete paquete;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="clienteId")
	private Usuario usuario;

	public Reservapaquete() {
	}

	public int getIdReservaPaquete() {
		return this.idReservaPaquete;
	}

	public void setIdReservaPaquete(int idReservaPaquete) {
		this.idReservaPaquete = idReservaPaquete;
	}

	public Paquete getPaquete() {
		return this.paquete;
	}

	public void setPaquete(Paquete paquete) {
		this.paquete = paquete;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}