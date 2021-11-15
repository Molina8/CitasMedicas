package com.citasMedicas.services;

import java.util.List;


import com.citasMedicas.dominio.Cita;

public interface CitaService {
	public abstract List<Cita> listAllCitas();
	public abstract Cita saveCita(Cita c);
	public abstract Cita findById(Long id);
	public abstract void deleteCita(Long id);

}
