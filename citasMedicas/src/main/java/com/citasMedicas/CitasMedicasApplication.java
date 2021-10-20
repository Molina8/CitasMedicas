package com.citasMedicas;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.citasMedicas.dominio.Cita;
import com.citasMedicas.dominio.Prueba;
import com.citasMedicas.repositories.CitaRepository;
import com.citasMedicas.repositories.PruebaRepository;


@SpringBootApplication
//@ComponentScan({"com.citasMedicas.controllers"})
public class CitasMedicasApplication implements CommandLineRunner{
	

	
	public static void main(String[] args) {
		SpringApplication.run(CitasMedicasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	
	/*	List<Cita> listCitas = citaRep.findAll();	
		
		listCitas.forEach(System.out :: println);*/
	}
	

}
