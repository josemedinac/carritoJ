package com.pract1.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.pract1.app.entitys.Carrito;
import com.pract1.app.implementacion.CarriroImpl;

@Controller
public class CarritoContrl {

	@Autowired
	private CarriroImpl carImpl;

	@GetMapping("all_carrito")
	public String allCarritos(Model modelo) {
		Carrito car = new Carrito();
		modelo.addAttribute("carrito",car);
		return "ventas/todasLasVentas";
	}

	@GetMapping("/map_carrito")
	public String mapCarritos(Model modelo) {
		Carrito car = new Carrito();
		modelo.addAttribute("Carrito", car);
		return "ventas/nuevaVenta";
	}

	@GetMapping("/get_carrito/{id}")
	public String getByIdCarritos(@PathVariable Long id, Model modelo) {
		Carrito car = this.carImpl.findbyId(id);
		modelo.addAttribute("carrito", car);
		return "ventas/editar";
	}

	@PostMapping("/save_carrito")
	public String updateCarritos(@ModelAttribute("carrito") Carrito car) {
		this.carImpl.update(car);
		return "redirect:/map_product";
	}

	@GetMapping("/delete_carrito/{id}")
	public String deleteCarritos(@PathVariable Long id) {
		Carrito car = this.carImpl.findbyId(id);
		this.carImpl.update(car);
		return "redirect:/all_carrito";
	}
}
