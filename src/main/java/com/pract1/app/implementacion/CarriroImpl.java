package com.pract1.app.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pract1.app.entitys.Carrito;
import com.pract1.app.repositorio.ICarrito;
import com.pract1.app.service.CarroServicioFacade;

@Service
public class CarriroImpl implements CarroServicioFacade {

	@Autowired
	private ICarrito iCar;

	@Override
	public List<Carrito> findAll() {
		return this.iCar.findAll();
	}

	@SuppressWarnings("deprecation")
	@Override
	public Carrito findbyId(Long id) {
		return this.iCar.getById(id);
	}

	@Override
	public void create(Carrito car) {
		this.iCar.save(car);
	}

	@Override
	public void update(Carrito car) {
		this.iCar.save(car);
	}

	@Override
	public void delete(Carrito car) {
		this.iCar.delete(car);
	}

}
