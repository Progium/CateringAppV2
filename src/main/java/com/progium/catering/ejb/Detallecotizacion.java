package com.progium.catering.ejb;

import java.io.Serializable;
import javax.persistence.*;


/**
* Esta clase con anotaciones para la crear la entidadad en
* la base de datos
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/
@Entity
@NamedQuery(name="Detallecotizacion.findAll", query="SELECT d FROM Detallecotizacion d")
public class Detallecotizacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idDetalleCotizacion;

	//bi-directional many-to-one association to Cotizacion
	@ManyToOne
	@JoinColumn(name="cotizacionId")
	private Cotizacion cotizacion;

	//bi-directional many-to-one association to Catalogoproducto
	@ManyToOne
	@JoinColumn(name="productoId")
	private Catalogoproducto catalogoproducto;

	public Detallecotizacion() {
	}

	public int getIdDetalleCotizacion() {
		return this.idDetalleCotizacion;
	}

	public void setIdDetalleCotizacion(int idDetalleCotizacion) {
		this.idDetalleCotizacion = idDetalleCotizacion;
	}

	public Cotizacion getCotizacion() {
		return this.cotizacion;
	}

	public void setCotizacion(Cotizacion cotizacion) {
		this.cotizacion = cotizacion;
	}

	public Catalogoproducto getCatalogoproducto() {
		return this.catalogoproducto;
	}

	public void setCatalogoproducto(Catalogoproducto catalogoproducto) {
		this.catalogoproducto = catalogoproducto;
	}

}