package com.citasMedicas.services.impl;

import java.util.List;



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

	@Override
	public Usuario findById(Long id) {
		return usuarioRep.findById(id).get();
	}

	@Override
	public void deleteUser(Long id) {
		usuarioRep.deleteById(id);
		
	}

	@Override
	public Usuario login(String userName, String passWord) {
		return findByUsername(userName);
	}

}
