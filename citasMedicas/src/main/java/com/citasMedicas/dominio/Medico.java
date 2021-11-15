package com.citasMedicas.dominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "usuario_id")
public class Medico extends Usuario implements Serializable{
	
	
	private String numColegiado;
	private int numPacientes;
	
	
	@JoinTable(
	        name = "paciente_medico",
	        joinColumns = @JoinColumn(name = "FK_Paciente", nullable = false),
	        inverseJoinColumns = @JoinColumn(name="FK_Medico", nullable = false)
	    )
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Paciente> pacientes;
	
	private static final long serialVersionUID = 1L;
	
	

	public String getNumColegiado() {
		return numColegiado;
	}

	public void setNumColegiado(String numColegiado) {
		this.numColegiado = numColegiado;
	}

	public int getNumPacientes() {
		return numPacientes;
	}

	public void setNumPacientes(int numPacientes) {
		this.numPacientes = numPacientes;
	}
	
	public void addPaciente() {
		numPacientes++;
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}
	

}
