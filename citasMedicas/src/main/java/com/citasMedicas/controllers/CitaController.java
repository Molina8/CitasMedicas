package com.citasMedicas.controllers;

import java.rmi.ServerException;
import com.citasMedicas.dominio.converter.*;

import java.util.ArrayList;
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

import com.citasMedicas.dominio.Cita;
import com.citasMedicas.dominio.Medico;
import com.citasMedicas.dominio.Paciente;
import com.citasMedicas.dominio.DTO.CitaDTO;
import com.citasMedicas.dominio.DTO.MessageDTO;
import com.citasMedicas.services.impl.CitaServiceImpl;

import com.citasMedicas.services.impl.MedicoServiceImpl;
import com.citasMedicas.services.impl.PacienteServiceImpl;

@RestController
@RequestMapping("/citas")
@CrossOrigin("http://localhost:4200")
public class CitaController {
	@Autowired
	private CitaServiceImpl citaServ;
	@Autowired
    private PacienteServiceImpl pacServ;
	@Autowired
	private MedicoServiceImpl medServ;
	@Autowired
	private Converter conv;

	//Autenticar con Token JWT
	/*1. utilizar DTOs con mapstruct ó modelMapper
		2. Uso de la relación de ManyToMany*/
	
	
	
	@GetMapping
	public ResponseEntity<List<CitaDTO>> getAll(){
		List<CitaDTO> citas = new ArrayList<CitaDTO>();
		citaServ.listAllCitas().stream().forEach(ci -> citas.add(conv.ctoCDTO(ci)));
		return ResponseEntity.ok(citas);
		
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<MessageDTO> getCita(@PathVariable Long id){
		Cita c;
		try {
			c = citaServ.findById(id);
		}catch (NullPointerException e) {
			return ResponseEntity.ok(new MessageDTO(404, "Not Found"));
		}
		
		return ResponseEntity.ok(new MessageDTO(100, conv.ctoCDTO(c)));
	}
	
	
	@PostMapping(path = "/solicitud")
	public ResponseEntity<MessageDTO> create(@RequestBody CitaDTO c) throws ServerException {
		Paciente p = pacServ.findById(c.getPaciente());
		Medico m = medServ.findById(c.getMedico());
		if(m == null || p == null) {
			return ResponseEntity.ok(new MessageDTO(404,"Paciente o Medico no registrado"));
		}
		Cita cita = conv.cDTOtoC(c, m, p);
		cita = citaServ.saveCita(cita);	
	    return ResponseEntity.ok(new MessageDTO(100, conv.ctoCDTO(cita)));
	}
	
		
	
		@DeleteMapping(value = "/delete/{id}")
		public ResponseEntity<MessageDTO> deleteCita(@PathVariable Long id){
			try {
				citaServ.deleteCita(id);
			}catch (NullPointerException e) {
				return ResponseEntity.ok(new MessageDTO(404,"No existe la cita"));
			}
			
			return ResponseEntity.ok(new MessageDTO(100,"Cita eliminada correctamente"));
		}


}
