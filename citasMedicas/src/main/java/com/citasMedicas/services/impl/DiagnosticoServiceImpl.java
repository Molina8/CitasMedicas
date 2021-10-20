package com.citasMedicas.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citasMedicas.dominio.Diagnostico;
import com.citasMedicas.repositories.DiagnosticoRepository;
import com.citasMedicas.services.DiagnosticoService;

@Service

public class DiagnosticoServiceImpl implements DiagnosticoService {
		@Autowired
		DiagnosticoRepository diagnosticoRep;

		public List<Diagnostico> listAllDiagnosticos() {
			return diagnosticoRep.findAll();
		}
}
