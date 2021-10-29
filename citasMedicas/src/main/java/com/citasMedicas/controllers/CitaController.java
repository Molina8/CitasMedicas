package com.citasMedicas.controllers;

import java.rmi.ServerException;
import java.util.List;
import java.util.Random;

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

import com.citasMedicas.dominio.Cita;

import com.citasMedicas.services.impl.CitaServiceImpl;

import com.citasMedicas.services.impl.MedicoServiceImpl;
import com.citasMedicas.services.impl.PacienteServiceImpl;

@RestController
@RequestMapping("/cita")
public class CitaController {
	@Autowired
	private CitaServiceImpl citaServ;
	@Autowired
    private PacienteServiceImpl pacServ;
	@Autowired
	private MedicoServiceImpl medServ;

	//Autenticar con Token JWT
	/*1. utilizar DTOs con mapstruct ó modelMapper
		2. Uso de la relación de ManyToMany*/
	
	@GetMapping(path = "/list",produces = {"application/json"})
	public List<Cita> listAllCita(){
		return this.citaServ.listAllCitas();
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Cita> getCita(@PathVariable Long id){
		Cita c;
		try {
			c = citaServ.findById(id);
		}catch (NullPointerException e) {
			return new ResponseEntity<Cita>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Cita>(c,HttpStatus.OK);
	}
	
	@PostMapping(path = "/solicitud/{id}",
	consumes = MediaType.APPLICATION_JSON_VALUE, 
	produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cita> create(@RequestBody Cita c,@PathVariable Long id) throws ServerException {
		c.setPacAsociado(pacServ.findById(id));
		List<Long> medAsociados = citaServ.listMedicosFromPaciente(id.intValue());
		Random r = new Random();
		int idx = r.nextInt(medAsociados.size()-1);
		c.setMedAsociado(medServ.findById(medAsociados.get(idx)));
		
		Cita cita = citaServ.saveCita(c);	
	    return new ResponseEntity<>( cita , HttpStatus.CREATED);
	}
	
		
	
		@DeleteMapping(value = "/delete/{id}")
		public ResponseEntity<Long> deleteCita(@PathVariable Long id){
			try {
				citaServ.deleteCita(id);
			}catch (NullPointerException e) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
			return new ResponseEntity<>(id,HttpStatus.OK);
		}


}
