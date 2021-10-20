package com.citasMedicas.dominio;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;



@Entity
@Table(name="usuario",schema = "SYSTEM")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements Serializable{

	@Id
	@Column(name = "usuario_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String apellidos;
	private String usuario;
	private String clave;
	
	private static final long serialVersionUID = 1L;

	/*public Usuario(String nombre, String apellidos, String usuario, String clave) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.usuario = usuario;
		this.clave = clave;
	}*/
	
	public Long getIdUsuario() {
		return id;
	}

	public void setIdUsuario(Long idUsuario) {
		this.id = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", usuario=" + usuario
				+ ", clave=" + clave + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellidos, clave, id, nombre, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(apellidos, other.apellidos) && Objects.equals(clave, other.clave)
				&& Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(usuario, other.usuario);
	}
	
	
	
	
}
