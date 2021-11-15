package com.citasMedicas.dominio.converter;

import com.citasMedicas.dominio.Cita;
import com.citasMedicas.dominio.Diagnostico;
import com.citasMedicas.dominio.Medico;
import com.citasMedicas.dominio.Paciente;
import com.citasMedicas.dominio.Usuario;
import com.citasMedicas.dominio.DTO.CitaDTO;
import com.citasMedicas.dominio.DTO.DiagnosticoDTO;
import com.citasMedicas.dominio.DTO.MedicoDTO;
import com.citasMedicas.dominio.DTO.PacienteDTO;
import com.citasMedicas.dominio.DTO.UsuarioDTO;

public interface IConverter {
		public Usuario uDTOtoU(UsuarioDTO usuarioDTO);
		
		public UsuarioDTO utoUDTO(Usuario usuario);
		
		public Paciente pDTOtoP(PacienteDTO pacienteDTO);
		
		public PacienteDTO ptoPDTO(Paciente paciente);
		
		public Medico mDTOtoM(MedicoDTO medicoDTO);
		
		public MedicoDTO mtoMDTO(Medico medico);
		
		public Cita cDTOtoC(CitaDTO citaDTO, Medico medico, Paciente paciente);
		
		public CitaDTO ctoCDTO(Cita cita);
		
		public Diagnostico dDTOtoD (DiagnosticoDTO diagnosticoDTO,Cita c);
		
		public DiagnosticoDTO dtoDDTO(Diagnostico diagnostico);
	    
}
