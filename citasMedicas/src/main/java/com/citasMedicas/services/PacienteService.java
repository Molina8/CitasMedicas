package com.citasMedicas.services;

import java.util.List;


import com.citasMedicas.dominio.Paciente;

public interface PacienteService {
	public abstract List<Paciente> listAllPacientes();
	public abstract Paciente savePaciente(Paciente p);
	public abstract void deletePaciente(Long id);
	public abstract Paciente findById(Long id);
}
