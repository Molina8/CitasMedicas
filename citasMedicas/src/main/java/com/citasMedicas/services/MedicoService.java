package com.citasMedicas.services;

import java.util.List;

import com.citasMedicas.dominio.Medico;

public interface MedicoService {
	public abstract List<Medico> listAllMedicos();
	public abstract Medico saveMedico(Medico m);
	public abstract void deleteMedico(Long id);
	public abstract Medico findById(Long id);
	public abstract Medico getMedicoConMenosPacientes();
	public abstract void addPaciente(Medico m);
	//public abstract void updateMedico(Medico m);
}
