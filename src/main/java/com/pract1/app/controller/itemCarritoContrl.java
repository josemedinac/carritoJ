package com.pract1.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.pract1.app.entitys.ItemCarrito;
import com.pract1.app.implementacion.itemCarritoImpl;

@Controller
public class itemCarritoContrl {

	@Autowired
	private itemCarritoImpl ICImpl;

	@GetMapping("all_itemCarrito")
	public String allItemCarritos(Model modelo) {
		ItemCarrito itemcar = new ItemCarrito();
		modelo.addAttribute("itemCarrito", itemcar);
		return "ventas/itemCarrito/all";
	}

	@GetMapping("/map_itemCarrito")
	public String mapallItemCarritos(Model modelo) {
		ItemCarrito itemcar = new ItemCarrito();
		modelo.addAttribute("itemCarrito", itemcar);
		return "ventas/itemCarrito/crear";
	}

	@GetMapping("/get_itemCarrito/{id}")
	public String getByIdallItemCarritos(@PathVariable Long id, Model modelo) {
		ItemCarrito itemcar = this.ICImpl.findbyId(id);
		modelo.addAttribute("itemCarrito", itemcar);
		return "ventas/itemCarrito/editar";
	}

	@PostMapping("/save_itemCarrito")
	public String updateItemCarritos(@ModelAttribute("carrito") ItemCarrito itemCar) {
		this.ICImpl.update(itemCar);
		return "redirect:/all_itemCarrito";
	}

	@GetMapping("/delete_itemCarrito/{id}")
	public String deleteItemCarritos(@PathVariable Long id) {
		ItemCarrito itemcar = this.ICImpl.findbyId(id);
		this.ICImpl.update(itemcar);
		return "redirect:/all_itemCarrito";
	}
}
