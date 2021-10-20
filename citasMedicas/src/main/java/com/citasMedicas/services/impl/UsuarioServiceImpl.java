package com.citasMedicas.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.citasMedicas.dominio.Usuario;
import com.citasMedicas.repositories.UsuarioRepository;
import com.citasMedicas.services.UsuarioService;

@Service

public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRep;
	
	@Override
	public List<Usuario> listAllUsuarios() {
		return usuarioRep.findAll();
	}

	@Override
	public Usuario findByUsername(String username) {
		for (Usuario u : usuarioRep.findAll()) {
			if(u.getUsuario().equals(username)) return u;
		}
		return null;
	}

	@Override
	public Usuario saveUser(Usuario u) {
		return usuarioRep.save(u);
	}

}
