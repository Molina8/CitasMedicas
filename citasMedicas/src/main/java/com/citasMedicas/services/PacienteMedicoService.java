package com.citasMedicas.services;




import java.util.List;

import com.citasMedicas.dominio.PacienteMedico;


public interface PacienteMedicoService {

	public abstract List<PacienteMedico> listAll();
	public abstract PacienteMedico savePacMed(PacienteMedico pm);
}