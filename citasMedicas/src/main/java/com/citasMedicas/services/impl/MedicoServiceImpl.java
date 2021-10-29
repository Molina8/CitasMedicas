package com.citasMedicas.services.impl;

import java.util.ArrayList;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.citasMedicas.dominio.Medico;
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

	@Override
	public Medico findById(Long id) {
		return medicoRep.findById(id).get();
	}
	
	@Override
	public Medico getMedicoConMenosPacientes() {
		ArrayList<Medico> medicos = (ArrayList<Medico>) medicoRep.findAll(Sort.by("numPacientes"));
		return medicos.get(0);
	}

	@Override
	public void addPaciente(Medico m) {
		m.addPaciente();
		medicoRep.save(m);
		
	}
	
	
	
	
	
	

	
	

}
