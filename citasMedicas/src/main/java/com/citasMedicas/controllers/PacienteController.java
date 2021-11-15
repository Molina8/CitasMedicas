package com.citasMedicas.controllers;

import java.rmi.ServerException;
import java.util.ArrayList;
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

import com.citasMedicas.dominio.Paciente;
import com.citasMedicas.dominio.Paciente;
import com.citasMedicas.dominio.DTO.PacienteDTO;
import com.citasMedicas.dominio.DTO.MessageDTO;
import com.citasMedicas.dominio.DTO.PacienteDTO;
import com.citasMedicas.dominio.converter.Converter;
import com.citasMedicas.services.impl.PacienteServiceImpl;
import com.citasMedicas.services.impl.PacienteServiceImpl;


@RestController
@RequestMapping(path = "/pacientes")
@CrossOrigin("http://localhost:4200")
public class PacienteController {
	@Autowired
	private PacienteServiceImpl pacienteServ;

	@Autowired
	private Converter conv;
	


	@GetMapping
	public ResponseEntity<List<PacienteDTO>> listAllPacientes(){
		List<PacienteDTO> lista = new ArrayList<PacienteDTO>();
		this.pacienteServ.listAllPacientes().stream().forEach(p->lista.add(conv.ptoPDTO(p)));
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MessageDTO> getPaciente (@PathVariable Long id){
		Paciente p;
		try {
			p = pacienteServ.findById(id);
		}catch (NullPointerException e) {
			return ResponseEntity.ok(new MessageDTO(404, "No existe el Paciente"));
		}
		return ResponseEntity.ok(new MessageDTO(100, conv.ptoPDTO(p)));
	}
	
	@PostMapping(path = "/register")
	public ResponseEntity<MessageDTO> registrarPaciente (@RequestBody PacienteDTO pacienteDTO) {
		Paciente p;
		try{
			p = conv.pDTOtoP(pacienteDTO);
			pacienteServ.savePaciente(p);
		}catch (NullPointerException e) {
			return ResponseEntity.ok(new MessageDTO(404, "No se pudo registrar el usuario"));
		}
		return ResponseEntity.ok(new MessageDTO(100, conv.ptoPDTO(p)));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deletePaciente(@PathVariable Long id){
		pacienteServ.deletePaciente(id);
		return ResponseEntity.ok("Paciente eliminado correctamente");
	}
	
	
	
}
