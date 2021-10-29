package com.citasMedicas.services.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citasMedicas.dominio.PacienteMedico;
import com.citasMedicas.repositories.PacienteMedicoRepository;
import com.citasMedicas.services.PacienteMedicoService;

@Service
public class PacienteMedicoServiceImpl implements PacienteMedicoService {
	@Autowired
	private PacienteMedicoRepository pacMedRep;
	
	@Override
	public List<PacienteMedico> listAll() {
		return  pacMedRep.findAll();

	}

	@Override
	public PacienteMedico savePacMed(PacienteMedico pm) {
		return pacMedRep.save(pm);
	}
	
}
