package com.citasMedicas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citasMedicas.dominio.Diagnostico;

public interface DiagnosticoRepository extends JpaRepository<Diagnostico,Long> {

}
