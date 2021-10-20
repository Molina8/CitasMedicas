package com.citasMedicas.dominio;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




@Entity
public class Prueba {
	
	@Id
	@Column(name = "prueba_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nombre;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Prueba [id=" + id + ", nombre=" + nombre + "]";
	}
	
	

}
