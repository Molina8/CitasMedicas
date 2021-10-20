package com.citasMedicas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citasMedicas.dominio.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long>{
	
}


