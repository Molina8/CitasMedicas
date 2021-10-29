package com.citasMedicas.services;

import java.util.List;

import com.citasMedicas.dominio.Diagnostico;

public interface DiagnosticoService {
	public abstract List<Diagnostico> listAllDiagnosticos();
	public abstract Diagnostico saveDiagnostico(Diagnostico d);
	public abstract void deleteDiagnostico(Long id);
	public abstract Diagnostico findDiagnosticoById(Long id);
}
