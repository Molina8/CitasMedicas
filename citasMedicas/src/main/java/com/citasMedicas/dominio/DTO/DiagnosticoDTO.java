package com.citasMedicas.dominio.DTO;

import java.io.Serializable;

public class DiagnosticoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String valoracionEspecialista;
	private String enfermedad;
	private Long cita;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getValoracionEspecialista() {
		return valoracionEspecialista;
	}
	public void setValoracionEspecialista(String valoracionEspecialista) {
		this.valoracionEspecialista = valoracionEspecialista;
	}
	public String getEnfermedad() {
		return enfermedad;
	}
	public void setEnfermedad(String enfermedad) {
		this.enfermedad = enfermedad;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Long getCita() {
		return cita;
	}
	public void setCita(Long cita) {
		this.cita = cita;
	}

}