package com.citasMedicas.dominio;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "usuario_id")
public class Medico extends Usuario implements Serializable{
	
	
	private String numColegiado;
	private int numPacientes;
	
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
	
	

}
