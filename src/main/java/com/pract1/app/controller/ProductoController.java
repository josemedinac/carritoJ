package com.pract1.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.pract1.app.entitys.Producto;
import com.pract1.app.implementacion.ProductImpl;

@Controller
public class ProductoController {

	@Autowired
	private ProductImpl prodimpl;

	@GetMapping("/all_producto")
	public String allProductos(Model modelo) {
		modelo.addAttribute("productos", this.prodimpl.findAll());
		return "productos/all";
	}

	@GetMapping("/map_producto")
	public String mapProductos(Model modelo) {
		Producto product = new Producto();
		modelo.addAttribute("producto", product);
		return "productos/create";
	}

	@GetMapping("/get_producto/{id}")
	public String getByIdProductos(@PathVariable Long id, Model modelo) {
		Producto product = this.prodimpl.findbyId(id);
		modelo.addAttribute("producto", product);
		return "productos/editar";
	}

	@PostMapping("/save_producto")
	public String updateProductos(@ModelAttribute("producto") Producto product) {
		this.prodimpl.update(product);
		return "redirect:/all_producto";
	}

	@GetMapping("/delete_producto/{id}")
	public String deleteProductos(@PathVariable Long id) {
		Producto product = this.prodimpl.findbyId(id);
		this.prodimpl.update(product);
		return "redirect:/all_producto";
	}
}
