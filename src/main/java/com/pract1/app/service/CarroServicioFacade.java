package com.pract1.app.service;

import java.util.List;

import com.pract1.app.entitys.Carrito;

public interface CarroServicioFacade {

	List<Carrito> findAll();
	Carrito findbyId(Long id);
	public void create(Carrito car);
	public void update(Carrito car);
	public void delete(Carrito car);
}
