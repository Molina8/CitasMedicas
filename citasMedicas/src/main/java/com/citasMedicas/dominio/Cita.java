package com.citasMedicas.dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name = "cita")
public class Cita implements Serializable {

	@Id
	@Column(name = "cita_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCita;
	private Date fechaHora;
	private String motivoCita;
	
	@ManyToOne
	@JoinColumn(name = "paciente")
	private Paciente pacAsociado;
	
	@ManyToOne
	@JoinColumn(name = "medico")
	private Medico medAsociado;

	private static final long serialVersionUID = 1L;

	/*public Cita(Date fechaHora, String motivoCita){
		this.fechaHora = fechaHora;
		this.motivoCita = motivoCita;
	}*/

	public void setIdCita(Long idCita) {
		this.idCita = idCita;
	}

	public Medico getMedAsociado() {
		return medAsociado;
	}

	public void setMedAsociado(Medico medAsociado) {
		this.medAsociado = medAsociado;
	}

	public java.util.Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date date) {
		this.fechaHora = date;
	}

	public String getMotivoCita() {
		return motivoCita;
	}

	public void setMotivoCita(String motivoCita) {
		this.motivoCita = motivoCita;
	}

	

	public Paciente getPacAsociado() {
		return pacAsociado;
	}

	public void setPacAsociado(Paciente pacAsociado) {
		this.pacAsociado = pacAsociado;
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
