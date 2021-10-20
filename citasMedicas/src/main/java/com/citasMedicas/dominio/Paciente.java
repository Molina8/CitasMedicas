package com.citasMedicas.dominio;

import java.io.Serializable;

import javax.persistence.*;



@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "usuario_id")
public class Paciente extends Usuario implements Serializable{

	private String NSS;
	private String numTarjeta;
	private String telefono;
	private String direccion;
	private static final long serialVersionUID = 1L;
	
	
	public String getNSS() {
		return NSS;
	}
	public void setNSS(String nSS) {
		NSS = nSS;
	}
	public String getNumTarjeta() {
		return numTarjeta;
	}
	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
