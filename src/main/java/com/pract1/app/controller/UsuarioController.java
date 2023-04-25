package com.pract1.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.pract1.app.entitys.Usuario;
import com.pract1.app.implementacion.UsuarioImpl;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioImpl usuaImpl;

	@GetMapping("/all_usuarios")
	public String allUsuarios(Model modelo) {
		modelo.addAttribute("usuarios", this.usuaImpl.findAll());
		return "usuarios/all";
	}

	@GetMapping("/map_usuarios")
	public String mapUsuarios(Model modelo) {
		Usuario user = new Usuario();
		modelo.addAttribute("usuario", user);
		return "usuarios/crear";
	}

	@GetMapping("/get_usuario/{id}")
	public String getByIdUsuarios(@PathVariable Long id, Model modelo) {
		Usuario user = this.usuaImpl.findbyId(id);
		modelo.addAttribute("usuario",user);
		return "usuarios/editar";
	}

	@PostMapping("/save_usuario")
	public String updateUsuarios(@ModelAttribute("usuario") Usuario user) {
		this.usuaImpl.update(user);
		return "redirect:/all_usuarios";
	}

	@GetMapping("/delete_usuario/{id}")
	public String deleteUsuarios(@PathVariable Long id) {
		Usuario user = this.usuaImpl.findbyId(id);
		this.usuaImpl.update(user);
		return "redirect:/all_usuarios";
	}
}
