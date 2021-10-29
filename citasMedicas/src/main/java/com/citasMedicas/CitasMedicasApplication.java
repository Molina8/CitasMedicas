package com.citasMedicas;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;





@SpringBootApplication

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
