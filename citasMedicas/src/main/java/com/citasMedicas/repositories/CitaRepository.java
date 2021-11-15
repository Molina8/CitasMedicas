package com.citasMedicas.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.citasMedicas.dominio.*;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {
	/*@Query("SELECT med FROM PacienteMedico WHERE pac = :paciente") 
	public abstract List<Long> listMedicosFromPaciente(@Param("paciente") int paciente);*/
}
