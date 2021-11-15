package com.citasMedicas.controllers;

import java.rmi.ServerException;
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

import com.citasMedicas.dominio.Diagnostico;
import com.citasMedicas.dominio.DTO.DiagnosticoDTO;
import com.citasMedicas.dominio.DTO.MessageDTO;
import com.citasMedicas.dominio.converter.Converter;
import com.citasMedicas.services.impl.CitaServiceImpl;
import com.citasMedicas.services.impl.DiagnosticoServiceImpl;

@RestController
@RequestMapping("/diagnosticos")
@CrossOrigin("http://localhost:4200")
public class DiagnosticoController {
	@Autowired 
	private DiagnosticoServiceImpl diagnosticoServ;
	@Autowired
	private CitaServiceImpl citaServ;
	@Autowired
	private Converter conv;
	
	
	@GetMapping
		public ResponseEntity<List<DiagnosticoDTO>> listAllDiagnosticos(){
			List<DiagnosticoDTO> lista = new ArrayList<DiagnosticoDTO>();
			diagnosticoServ.listAllDiagnosticos().stream().
			forEach(d -> lista.add(conv.dtoDDTO(d)));
			return ResponseEntity.ok(lista);
		}
	
	
	@PostMapping(path = "/generar/{id}")
	public ResponseEntity<MessageDTO> createDiagnostico(@RequestBody DiagnosticoDTO d,@PathVariable Long id) throws ServerException{
		d.setCita(citaServ.findById(id).getIdCita());
		Diagnostico diag = diagnosticoServ.saveDiagnostico(conv.dDTOtoD(d,citaServ.findById(id)));
		 if (diag == null) {
		      	return ResponseEntity.ok(new MessageDTO(404, "No creado"));
		 } 
		 return ResponseEntity.ok(new MessageDTO(100,conv.dtoDDTO(diag)));

	}
	
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<MessageDTO> getDiagnostico(@PathVariable Long id){
		Diagnostico d;
		try {
			 d = diagnosticoServ.findDiagnosticoById(id);
		}catch (NullPointerException e) {
			return ResponseEntity.ok(new MessageDTO(404,"No existe el diagnostico"));
		}
		return ResponseEntity.ok(new MessageDTO(100, conv.dtoDDTO(d)));
	}
	
	
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<MessageDTO> deleteDiagnostico(@PathVariable Long id){
		try {
			diagnosticoServ.deleteDiagnostico(id);
		}catch (NullPointerException e) {
			return ResponseEntity.ok(new MessageDTO(404,"No existe el diagnostico"));
		}
		return ResponseEntity.ok(new MessageDTO(200,"Diagnostico eliminado"));
	}
}
