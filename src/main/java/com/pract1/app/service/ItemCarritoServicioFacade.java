package com.pract1.app.service;

import java.util.List;

import com.pract1.app.entitys.ItemCarrito;

public interface ItemCarritoServicioFacade {
	List<ItemCarrito> findAll();
	ItemCarrito findbyId(Long id);
	public void create(ItemCarrito itemCar);
	public void update(ItemCarrito itemCar);
	public void delete(ItemCarrito itemCar);
}
