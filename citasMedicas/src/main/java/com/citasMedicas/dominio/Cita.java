package com.citasMedicas.dominio;

import java.io.Serializable;

import java.sql.Date;
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

	private static final long serialVersionUID = 1L;

	/*public Cita(Date fechaHora, String motivoCita){
		this.fechaHora = fechaHora;
		this.motivoCita = motivoCita;
	}*/

	public void setIdCita(Long idCita) {
		this.idCita = idCita;
	}

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
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
