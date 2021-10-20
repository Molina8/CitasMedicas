package com.citasMedicas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.citasMedicas.dominio.*;

@Component
public interface PruebaRepository extends JpaRepository<Prueba, Long>{

}
