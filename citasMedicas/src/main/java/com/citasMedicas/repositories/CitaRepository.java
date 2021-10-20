package com.citasMedicas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.citasMedicas.dominio.*;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {
	
}
