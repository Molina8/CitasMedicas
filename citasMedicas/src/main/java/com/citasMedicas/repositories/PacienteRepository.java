package com.citasMedicas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citasMedicas.dominio.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{

}
