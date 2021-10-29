package com.citasMedicas.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citasMedicas.dominio.Usuario;
import com.citasMedicas.services.impl.UsuarioServiceImpl;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioServiceImpl usuarioServ;
	
	@GetMapping(path="/list",produces = {"application/json"})
	public List<Usuario> listAllUsuarios(){
		return this.usuarioServ.listAllUsuarios();
	}
	
	/*
	@PostMapping(path = "/login", 
	        consumes = MediaType.APPLICATION_JSON_VALUE, 
	        produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> create(@RequestBody Usuario newUser) throws ServerException {
	    Usuario user = usuarioServ.saveUser(newUser);
	    if (user == null) {
	        throw new ServerException("No valido");
	    } else {
	        return new ResponseEntity<>(user, HttpStatus.CREATED);
	    }
	}
	*/
	
	
	public Usuario findUsuario(String userName) {
		return this.usuarioServ.findByUsername(userName);
	}
	
	
}
