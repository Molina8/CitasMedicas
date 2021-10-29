package com.citasMedicas.dominio;

import java.io.Serializable;
import java.util.Objects;

public class PacienteMedicoID implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private Long med;
	private Long pac;
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(med, pac);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PacienteMedicoID other = (PacienteMedicoID) obj;
		return Objects.equals(med, other.med) && Objects.equals(pac, other.pac);
	}
	
	

}
