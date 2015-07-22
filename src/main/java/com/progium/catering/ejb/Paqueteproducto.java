package com.progium.catering.ejb;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the paqueteproductos database table.
 * 
 */
@Entity
@Table(name="paqueteproductos")
@NamedQuery(name="Paqueteproducto.findAll", query="SELECT p FROM Paqueteproducto p")
public class Paqueteproducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idPaqueteProductos;

	//bi-directional many-to-one association to Catalogoproducto
	@ManyToOne
	@JoinColumn(name="productoId")
	private Catalogoproducto catalogoproducto;

	public Paqueteproducto() {
	}

	public int getIdPaqueteProductos() {
		return this.idPaqueteProductos;
	}

	public void setIdPaqueteProductos(int idPaqueteProductos) {
		this.idPaqueteProductos = idPaqueteProductos;
	}

	public Catalogoproducto getCatalogoproducto() {
		return this.catalogoproducto;
	}

	public void setCatalogoproducto(Catalogoproducto catalogoproducto) {
		this.catalogoproducto = catalogoproducto;
	}

}