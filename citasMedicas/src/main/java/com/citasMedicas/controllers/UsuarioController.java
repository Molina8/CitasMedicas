package com.citasMedicas.controllers;


import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citasMedicas.dominio.Medico;
import com.citasMedicas.dominio.Paciente;
import com.citasMedicas.dominio.Usuario;
import com.citasMedicas.dominio.DTO.MessageDTO;
import com.citasMedicas.dominio.DTO.UsuarioDTO;
import com.citasMedicas.dominio.converter.Converter;
import com.citasMedicas.services.impl.UsuarioServiceImpl;
import com.fasterxml.jackson.databind.node.ObjectNode;


@RestController
@RequestMapping("/usuarios")
@CrossOrigin("http://localhost:4200")
public class UsuarioController {

	@Autowired
	private UsuarioServiceImpl usuarioServ;
	@Autowired
	private Converter conv;
	
	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> listAllUsuarios(){
		List<UsuarioDTO> lista = new LinkedList<UsuarioDTO>();
		this.usuarioServ.listAllUsuarios().stream().forEach(u->lista.add(conv.utoUDTO(u)));
		return ResponseEntity.ok(lista);
	}
	
	
	
	/*@GetMapping(path = "/{userName}")
	public ResponseEntity<MessageDTO> findUsuario(@PathVariable String userName) {
		Usuario u;
		try{
			u = usuarioServ.findByUsername(userName);
		}catch (NullPointerException e) {
			return ResponseEntity.ok(new MessageDTO(404, "No existe el usuario"));
		}
		return ResponseEntity.ok(new MessageDTO(100, conv.utoUDTO(u)));

	}*/
	
	
	@GetMapping("/{id}")
	public ResponseEntity<MessageDTO> getUsuario (@PathVariable Long id){
		Usuario u;
		try {
			u = usuarioServ.findById(id);
		}catch (NullPointerException e) {
			return ResponseEntity.ok(new MessageDTO(404, "No existe el usuario"));
		}
		return ResponseEntity.ok(new MessageDTO(100, conv.utoUDTO(u)));
	}
	
	@PostMapping(path = "/register")
	public ResponseEntity<MessageDTO> registrarUsuario (@RequestBody UsuarioDTO usuarioDTO) {
		Usuario usuario ;
		try{
			usuario = conv.uDTOtoU(usuarioDTO);
			usuarioServ.saveUser(usuario);
		}catch (NullPointerException e) {
			return ResponseEntity.ok(new MessageDTO(404, "No se pudo registrar el usuario"));
		}
		return ResponseEntity.ok(new MessageDTO(100, conv.utoUDTO(usuario)));
	}
		
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUsuario(@PathVariable Long id){
		usuarioServ.deleteUser(id);
		return ResponseEntity.ok("Usuario eliminado correctamente");
	}
			
	@PostMapping("/login")
	public ResponseEntity<MessageDTO> login(@RequestBody ObjectNode obj){
		String usuario = obj.get("nickUsuario").asText();
		String clave = obj.get("clave").asText();
		Usuario u;
		try {
			 u = usuarioServ.login(usuario, clave);
		}catch (NullPointerException e) {
			return ResponseEntity.ok(new MessageDTO(404, "Debe registrarse primero"));
		}
		if(u instanceof Medico) {
			Medico m = (Medico) u;
			return ResponseEntity.ok(new MessageDTO(100, m));
		}else {
			Paciente p = (Paciente) u;
			return ResponseEntity.ok(new MessageDTO(100,p));
		}
		

	}
	
	}
	

