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

import com.citasMedicas.dominio.Medico;
import com.citasMedicas.services.impl.MedicoServiceImpl;

@RestController
@RequestMapping("/medico")
public class MedicoController {
	@Autowired
	private MedicoServiceImpl medicoServ;

	
	@GetMapping(path = "/list",produces = {"application/json"})
	public List<Medico> listAllMedicos(){
		return medicoServ.listAllMedicos();
	}
	@PostMapping(path = "/register", 
	        consumes = MediaType.APPLICATION_JSON_VALUE, 
	        produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Medico> create(@RequestBody Medico m) throws ServerException{
		Medico med = medicoServ.saveMedico(m);
		 if (med == null) {
		        throw new ServerException("No valido");
		    } else {
		        return new ResponseEntity<>(med, HttpStatus.CREATED);
		    }
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Long> deleteMedico(@PathVariable Long id){
		try {
			medicoServ.deleteMedico(id);
		}catch (NullPointerException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(id,HttpStatus.OK);
	}
	
	
	
}
