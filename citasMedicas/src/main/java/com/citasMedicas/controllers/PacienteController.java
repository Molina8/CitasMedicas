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

import com.citasMedicas.dominio.Cita;
import com.citasMedicas.dominio.Medico;
import com.citasMedicas.dominio.Paciente;
import com.citasMedicas.dominio.PacienteMedico;
import com.citasMedicas.services.impl.MedicoServiceImpl;
import com.citasMedicas.services.impl.PacienteMedicoServiceImpl;
import com.citasMedicas.services.impl.PacienteServiceImpl;


@RestController
@RequestMapping(path = "/paciente")
public class PacienteController {
	@Autowired
	private PacienteServiceImpl pacienteServ;
	@Autowired 
	private MedicoServiceImpl medicoServ;
	
	@Autowired
	private PacienteMedicoServiceImpl pacMedServ;

	
	@GetMapping(path = "/list",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Paciente> listAllPacientes(){
		return pacienteServ.listAllPacientes();
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Paciente> getPaciente(@PathVariable Long id){
		Paciente p;
		try {
			p = pacienteServ.findById(id);
		}catch (NullPointerException e) {
			return new ResponseEntity<Paciente>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Paciente>(p,HttpStatus.OK);
	}
	
	
	@PostMapping(path = "/register", 
	        consumes = MediaType.APPLICATION_JSON_VALUE, 
	        produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Paciente> create(@RequestBody Paciente p) throws ServerException{
		Paciente pac= pacienteServ.savePaciente(p);
		Medico m = medicoServ.getMedicoConMenosPacientes();
		PacienteMedico pm = asignarMedicoPaciente(pac,m);
		pacMedServ.savePacMed(pm);
		 if (pac == null) {
		        throw new ServerException("No valido");
		    } else {
		        return new ResponseEntity<>(pac, HttpStatus.CREATED);
		    }
	}
	
	private PacienteMedico asignarMedicoPaciente(Paciente pac, Medico m) {
		PacienteMedico pacMed = new PacienteMedico();
		pacMed.setMed(m);
		pacMed.setPac(pac);
		medicoServ.addPaciente(m);
		return pacMed;
	}


	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Long> deletePaciente(@PathVariable Long id){
		try {
			pacienteServ.deletePaciente(id);
		}catch (NullPointerException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(id,HttpStatus.OK);
	}
	
}
