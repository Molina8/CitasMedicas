package com.citasMedicas.services.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citasMedicas.dominio.Paciente;
import com.citasMedicas.repositories.PacienteRepository;
import com.citasMedicas.services.PacienteService;

@Service

public class PacienteServiceImpl implements PacienteService{
	@Autowired
	private PacienteRepository pacienteRep;
	
	@Override
	public List<Paciente> listAllPacientes() {
		return pacienteRep.findAll();
	}

	@Override
	public Paciente savePaciente(Paciente p) {
		return pacienteRep.save(p);
	}

	@Override
	public void deletePaciente(Long id) {
		pacienteRep.deleteById(id);
		
	}

	@Override
	public Paciente findById(Long id) {
		return pacienteRep.findById(id).get();
	}
	
	

}
