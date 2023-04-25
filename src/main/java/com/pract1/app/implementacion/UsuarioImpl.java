package com.pract1.app.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pract1.app.entitys.Usuario;
import com.pract1.app.repositorio.IUsuario;
import com.pract1.app.service.UsuarioServicioFacade;

@Service
public class UsuarioImpl implements UsuarioServicioFacade{

	@Autowired
	private IUsuario iUsuar;

	@Override
	public List<Usuario> findAll(){
		return this.iUsuar.findAll();
	}

	@SuppressWarnings("deprecation")
	@Override
	public Usuario findbyId(Long id) {
		return this.iUsuar.getById(id);
	}


	@Override
	public void create(Usuario usuario) {
		this.iUsuar.save(usuario);
	}

	@Override
	public void update(Usuario usuario) {
		this.iUsuar.save(usuario);
	}

	@Override
	public void delete(Usuario usuario) {
		this.iUsuar.delete(usuario);
	}



}
