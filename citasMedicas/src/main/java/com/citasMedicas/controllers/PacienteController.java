package com.citasMedicas.controllers;

import java.rmi.ServerException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.citasMedicas.dominio.Paciente;
import com.citasMedicas.services.impl.PacienteServiceImpl;


@RestController
@RequestMapping(path = "/paciente")
public class PacienteController {
	@Autowired
	private PacienteServiceImpl pacienteServ;

	
	@GetMapping(path = "/list",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Paciente> listAllPacientes(){
		return pacienteServ.listAllPacientes();
	}
	
	
	@PostMapping(path = "/register", 
	        consumes = MediaType.APPLICATION_JSON_VALUE, 
	        produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Paciente> create(@RequestBody Paciente p) throws ServerException{
		Paciente pac= pacienteServ.savePaciente(p);
		 if (pac == null) {
		        throw new ServerException("No valido");
		    } else {
		        return new ResponseEntity<>(pac, HttpStatus.CREATED);
		    }
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Long> deletePaciente(@PathVariable Long id){
		try {
			pacienteServ.deletePaciente(id);
		}catch (NullPointerException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(id,HttpStatus.OK);
	}
	
}
