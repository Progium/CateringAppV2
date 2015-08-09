package com.progium.catering.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
* Esta clase con anotaciones para la crear la entidadad en
* la base de datos
*
* @author  Progium<progiump3@gmail.com>
* @version 1.0
* @since   2015/08/08
*/
@Entity
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idProducto;
	private String nombre;

	//bi-directional many-to-one association to Catalogoproducto
	@OneToMany(mappedBy="producto")
	private List<Catalogoproducto> catalogoproductos;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="categoriaId")
	private Categoria categoria;

	public Producto() {
	}

	public int getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Catalogoproducto> getCatalogoproductos() {
		return this.catalogoproductos;
	}

	public void setCatalogoproductos(List<Catalogoproducto> catalogoproductos) {
		this.catalogoproductos = catalogoproductos;
	}

	public Catalogoproducto addCatalogoproducto(Catalogoproducto catalogoproducto) {
		getCatalogoproductos().add(catalogoproducto);
		catalogoproducto.setProducto(this);

		return catalogoproducto;
	}

	public Catalogoproducto removeCatalogoproducto(Catalogoproducto catalogoproducto) {
		getCatalogoproductos().remove(catalogoproducto);
		catalogoproducto.setProducto(null);

		return catalogoproducto;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}