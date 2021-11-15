package com.citasMedicas.controllers;

import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import com.citasMedicas.dominio.Usuario;
import com.citasMedicas.dominio.DTO.MedicoDTO;
import com.citasMedicas.dominio.DTO.MessageDTO;
import com.citasMedicas.dominio.DTO.UsuarioDTO;
import com.citasMedicas.dominio.converter.Converter;
import com.citasMedicas.services.impl.MedicoServiceImpl;

@RestController
@RequestMapping("/medicos")
@CrossOrigin("http://localhost:4200")
public class MedicoController {
	@Autowired
	private MedicoServiceImpl medicoServ;
	@Autowired
	private Converter conv;
	
	@GetMapping
	public ResponseEntity<List<MedicoDTO>> listAllMedicos(){
		List<MedicoDTO> lista = new ArrayList<MedicoDTO>();
		this.medicoServ.listAllMedicos().stream().forEach(m->lista.add(conv.mtoMDTO(m)));
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MessageDTO> getMedico (@PathVariable Long id){
		Medico m;
		try {
			m = medicoServ.findById(id);
		}catch (NullPointerException e) {
			return ResponseEntity.ok(new MessageDTO(404, "No existe el medico"));
		}
		return ResponseEntity.ok(new MessageDTO(100, conv.mtoMDTO(m)));
	}
	
	@PostMapping(path = "/register")
	public ResponseEntity<MessageDTO> registrarMedico (@RequestBody MedicoDTO medicoDTO) {
		Medico m;
		try{
			m = conv.mDTOtoM(medicoDTO);
			medicoServ.saveMedico(m);
		}catch (NullPointerException e) {
			return ResponseEntity.ok(new MessageDTO(404, "No se pudo registrar el usuario"));
		}
		return ResponseEntity.ok(new MessageDTO(100, conv.mtoMDTO(m)));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteMedico(@PathVariable Long id){
		medicoServ.deleteMedico(id);
		return ResponseEntity.ok("Medico eliminado correctamente");
	}
	
	
	
}
