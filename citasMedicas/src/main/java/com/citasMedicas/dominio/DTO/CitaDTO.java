package com.citasMedicas.dominio.DTO;

import java.io.Serializable;

import java.sql.Date;



public class CitaDTO implements Serializable {


	private Long idCita;
	private String fechaHora;
	private String motivoCita;
	private Long paciente;
	private Long medico;

	private static final long serialVersionUID = 1L;


	public void setIdCita(Long idCita) {
		this.idCita = idCita;
	}

	


	public String getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(String fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getMotivoCita() {
		return motivoCita;
	}

	public void setMotivoCita(String motivoCita) {
		this.motivoCita = motivoCita;
	}

	


	public Long getPaciente() {
		return paciente;
	}




	public void setPaciente(Long paciente) {
		this.paciente = paciente;
	}




	public Long getMedico() {
		return medico;
	}




	public void setMedico(Long medico) {
		this.medico = medico;
	}




	public Long getIdCita() {
		return idCita;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Cita [idCita=" + idCita + ", fechaHora=" + fechaHora + ", motivoCita=" + motivoCita  + "]";
	}

	
}
