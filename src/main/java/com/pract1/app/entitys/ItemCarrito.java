package com.pract1.app.entitys;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "itemCarritos")
public class ItemCarrito {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@JoinColumn(name = "producto_id", nullable = false)
	@ManyToOne(optional = false, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Producto producto;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "carrito_id", nullable = false)
	private Carrito carrito;

	@NotNull
	@Min(1)
	@Column(name = "cantidad", nullable = false)
	private Integer cantidad;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "ItemCarrito [id=" + id + ", producto=" + producto + ", cantidad=" + cantidad + "]";
	}

	public ItemCarrito(Long id, @NotNull Producto producto, @NotNull @Min(1) Integer cantidad) {
		super();
		this.id = id;
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public ItemCarrito() {
		// TODO Auto-generated constructor stub
	}

}
