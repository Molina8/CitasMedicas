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

import com.citasMedicas.dominio.Diagnostico;
import com.citasMedicas.services.impl.CitaServiceImpl;
import com.citasMedicas.services.impl.DiagnosticoServiceImpl;

@RestController
@RequestMapping("/diagnostico")
public class DiagnosticoController {
	@Autowired 
	DiagnosticoServiceImpl diagnosticoServ;
	@Autowired
	CitaServiceImpl citaServ;
	
	
	@GetMapping(path = "/list",consumes = MediaType.APPLICATION_JSON_VALUE)
		public List<Diagnostico> listAllDiagnosticos(){
			return diagnosticoServ.listAllDiagnosticos();
		}
	
	
	@PostMapping(path = "/generar/{id}",
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Diagnostico> createDiagnostico(@RequestBody Diagnostico d,@PathVariable Long id) throws ServerException{
		d.setCitaAsociada(citaServ.findById(id));
		Diagnostico diag = diagnosticoServ.saveDiagnostico(d);
		 if (diag == null) {
		        throw new ServerException("No valido");
		    } else {
		        return new ResponseEntity<>(diag, HttpStatus.CREATED);
		    }
		
	}
	
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Diagnostico> getDiagnostico(@PathVariable Long id){
		Diagnostico d;
		try {
			 d = diagnosticoServ.findDiagnosticoById(id);
		}catch (NullPointerException e) {
			return new ResponseEntity<Diagnostico>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Diagnostico>(d,HttpStatus.OK);
	}
	
	
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<Long> deleteDiagnostico(@PathVariable Long id){
		try {
			diagnosticoServ.deleteDiagnostico(id);
		}catch (NullPointerException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Long>(id,HttpStatus.OK);
	}
}
