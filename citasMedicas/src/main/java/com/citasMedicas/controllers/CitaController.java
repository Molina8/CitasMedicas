package com.citasMedicas.controllers;

import java.rmi.ServerException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.citasMedicas.dominio.Cita;

import com.citasMedicas.services.impl.CitaServiceImpl;
import com.citasMedicas.services.impl.PacienteServiceImpl;

@RestController
@RequestMapping("/cita")
public class CitaController {
	@Autowired
	private CitaServiceImpl citaServ;
	@Autowired
    private PacienteServiceImpl pacServ;
	
	@GetMapping(path = "/list",produces = {"application/json"})
	public List<Cita> listAllCita(){
		return this.citaServ.listAllCitas();
	}
	
	
	
		@PostMapping(path = "/solicitud/{id}",
		consumes = MediaType.APPLICATION_JSON_VALUE, 
		produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Cita> create(@RequestBody Cita c,@PathVariable Long id) throws ServerException {
			c.setPacAsociado(pacServ.findById(id));
			Cita cita = citaServ.saveCita(c);	
		    return new ResponseEntity<>( cita , HttpStatus.CREATED);
		}
	
	


}
