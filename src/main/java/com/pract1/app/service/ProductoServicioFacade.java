package com.pract1.app.service;

import java.util.List;

import com.pract1.app.entitys.Producto;

public interface ProductoServicioFacade {

	List<Producto> findAll();
	Producto findbyId(Long id);
	public void create(Producto product);
	public void update(Producto product);
	public void delete(Producto product);
}
