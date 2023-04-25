package com.pract1.app.service;

import java.util.List;

import com.pract1.app.entitys.Usuario;

public interface UsuarioServicioFacade {

	List<Usuario> findAll();
	Usuario findbyId(Long id);
	public void create(Usuario usuario);
	public void update(Usuario usuario);
	public void delete(Usuario usuario);
}
