package com.citasMedicas.services.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citasMedicas.dominio.Cita;
import com.citasMedicas.repositories.CitaRepository;
import com.citasMedicas.services.CitaService;

@Service

public class CitaServiceImpl implements CitaService {
	@Autowired
	private CitaRepository citaRep;
	
	@Override
	public List<Cita> listAllCitas() {
		return citaRep.findAll();
	}

	@Override
	public Cita saveCita(Cita c) {
		return citaRep.save(c);
	}

	@Override
	public Cita findById(Long id) {
		
		return  citaRep.findById(id).get();
	}

	
}
