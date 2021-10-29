package com.citasMedicas.dominio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@IdClass(PacienteMedicoID.class)
@Table(name = "paciente_medico")
public class PacienteMedico implements Serializable{


	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne
	@JoinColumn(name = "medico")
	private Medico med;

	@Id
	@OneToOne
	@JoinColumn(name = "paciente")
	private Paciente pac;



	public Medico getMed() {
		return med;
	}



	public void setMed(Medico med) {
		this.med = med;
	}



	public Paciente getPac() {
		return pac;
	}



	public void setPac(Paciente pac) {
		this.pac = pac;
	}



	@Override
	public String toString() {
		return "PacienteMedico [med=" + med + ", pac=" + pac + "]";
	}
	
	
	
	
}
