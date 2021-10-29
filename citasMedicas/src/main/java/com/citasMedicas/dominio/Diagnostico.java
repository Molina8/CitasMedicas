package com.citasMedicas.dominio;

import java.io.Serializable;

import javax.persistence.*;



@Entity
@Table(name="diagnostico")
public class Diagnostico implements Serializable {

	@Id
	@Column(name = "diagnostico_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDiagnostico;
	private String valoracionEspecialista;
	private String enfermedad;
	
	@OneToOne
	@JoinColumn(name = "cita" )
	private Cita citaAsociada;
	
	private static final long serialVersionUID = 1L;

	public Cita getCitaAsociada() {
		return citaAsociada;
	}

	public void setCitaAsociada(Cita citaAsociada) {
		this.citaAsociada = citaAsociada;
	}

	public Long getIdDiagnostico() {
		return idDiagnostico;
	}

	public void setIdDiagnostico(Long idDiagnostico) {
		this.idDiagnostico = idDiagnostico;
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

	@Override
	public String toString() {
		return "Diagnostico [idDiagnostico=" + idDiagnostico + ", valoracionEspecialista=" + valoracionEspecialista
				+ ", enfermedad=" + enfermedad + "]";
	}
	
	
}
