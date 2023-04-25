package com.pract1.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping("/")
	public String login(Model model, String error, String logout) {
		/*
		 * if (error != null) model.addAttribute("error",
		 * "El nombre de usuario o contraseña son incorrectos.");
		 * 
		 * if (logout != null) model.addAttribute("message",
		 * "Ha cerrado sesión correctamente.");
		 */
		return "index";
	}

}
