package com.pract1.app.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pract1.app.entitys.Producto;
import com.pract1.app.repositorio.IProducto;
import com.pract1.app.service.ProductoServicioFacade;

@Service
public class ProductImpl implements ProductoServicioFacade{

	@Autowired
	private IProducto iProduct;

	@Override
	public List<Producto> findAll() {
		return this.iProduct.findAll();
	}

	@SuppressWarnings("deprecation")
	@Override
	public Producto findbyId(Long id) {
		return this.iProduct.getById(id);
	}

	@Override
	public void create(Producto product) {
		this.iProduct.save(product);
	}

	@Override
	public void update(Producto product) {
		this.iProduct.save(product);
	}

	@Override
	public void delete(Producto product) {
		this.iProduct.delete(product);
	}


}
