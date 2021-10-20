package com.citasMedicas.services;

import java.util.List;
import java.util.Optional;

import com.citasMedicas.dominio.Cita;

public interface CitaService {
	public abstract List<Cita> listAllCitas();
	public abstract Cita saveCita(Cita c);
	public abstract Cita findById(Long id);

}
