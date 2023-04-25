package com.pract1.app.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pract1.app.entitys.ItemCarrito;
import com.pract1.app.repositorio.IitemCarrito;
import com.pract1.app.service.ItemCarritoServicioFacade;

@Service
public class itemCarritoImpl implements ItemCarritoServicioFacade {

	@Autowired
	private IitemCarrito iITcar;

	@Override
	public List<ItemCarrito> findAll() {
		return this.iITcar.findAll();
	}

	@SuppressWarnings("deprecation")
	@Override
	public ItemCarrito findbyId(Long id) {
		return  this.iITcar.getById(id);
	}

	@Override
	public void create(ItemCarrito itemCar) {
		this.iITcar.save(itemCar);
	}

	@Override
	public void update(ItemCarrito itemCar) {
		this.iITcar.save(itemCar);
	}

	@Override
	public void delete(ItemCarrito itemCar) {
		this.iITcar.delete(itemCar);
	}

}
