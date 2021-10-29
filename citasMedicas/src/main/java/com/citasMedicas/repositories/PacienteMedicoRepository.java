package com.citasMedicas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citasMedicas.dominio.PacienteMedico;

public interface PacienteMedicoRepository extends JpaRepository<PacienteMedico, Long>{

}
