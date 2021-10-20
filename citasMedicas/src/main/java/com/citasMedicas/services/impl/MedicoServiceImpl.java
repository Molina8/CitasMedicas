package com.citasMedicas.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citasMedicas.dominio.Medico;
import com.citasMedicas.dominio.Paciente;
import com.citasMedicas.repositories.MedicoRepository;
import com.citasMedicas.services.MedicoService;

@Service
public class MedicoServiceImpl implements MedicoService{
	@Autowired
	private MedicoRepository medicoRep;
	
	@Override
	public List<Medico> listAllMedicos() {
		return medicoRep.findAll();
	}

	@Override
	public Medico saveMedico(Medico m) {
		return medicoRep.save(m);
	}

	@Override
	public void deleteMedico(Long id) {
		medicoRep.deleteById(id);
		
	}

	
	

}
