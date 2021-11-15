package com.citasMedicas.dominio.converter;

import org.springframework.stereotype.Component;

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

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.modelmapper.ModelMapper;

@Component
public class Converter implements IConverter{
private ModelMapper mapper = new ModelMapper();
	
	
	@Override
	public Usuario uDTOtoU(UsuarioDTO usuarioDTO) {
		return mapper.map(usuarioDTO, Usuario.class);
	}
	@Override
	public UsuarioDTO utoUDTO(Usuario usuario) {
		return mapper.map(usuario, UsuarioDTO.class); 
	}
	@Override
	public Paciente pDTOtoP(PacienteDTO pacienteDTO) {
		return mapper.map(pacienteDTO, Paciente.class);
	}
	@Override
	public PacienteDTO ptoPDTO(Paciente paciente) {
		return mapper.map(Paciente.class, PacienteDTO.class);		
	}
	@Override
	public Medico mDTOtoM(MedicoDTO medicoDTO) {
		return mapper.map(medicoDTO, Medico.class);
	}
	@Override
	public MedicoDTO mtoMDTO(Medico medico) {
		
		return mapper.map(Medico.class, MedicoDTO.class);
	}
	@Override
	public Cita cDTOtoC(CitaDTO citaDTO, Medico medico, Paciente paciente) {
		Cita cita = mapper.typeMap(CitaDTO.class, Cita.class)
				/*.addMappings(mappr -> mappr.skip(Cita::setFechaHora))
				.addMappings(mappr -> mappr.skip(Cita::setMedAsociado))
				.addMappings(mappr -> mappr.skip(Cita::setPacAsociado))*/
				.map(citaDTO);	
		try {
			cita.setFechaHora(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(citaDTO.getFechaHora()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
			cita.setMedAsociado(medico);
			cita.setPacAsociado(paciente);
			return cita;
	}
	@Override
	public CitaDTO ctoCDTO(Cita cita) {
		CitaDTO dto = mapper.typeMap(Cita.class, CitaDTO.class)
			/*	.addMappings(mappr -> mappr.skip(CitaDTO::setMedico))
				.addMappings(mappr -> mappr.skip(CitaDTO::setPaciente))
				.addMappings(mappr -> mappr.skip(CitaDTO::setFechaHora))*/
				.map(cita);
		dto.setMedico(cita.getMedAsociado().getIdUsuario());
		dto.setPaciente(cita.getPacAsociado().getIdUsuario());
		dto.setFechaHora(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(cita.getFechaHora()));
		return dto;
	}
	@Override
	public Diagnostico dDTOtoD (DiagnosticoDTO diagnosticoDTO,Cita c) {
		Diagnostico diag = mapper.map(diagnosticoDTO, Diagnostico.class);
		diag.setCitaAsociada(c);
		return diag;
	}
	@Override
	public DiagnosticoDTO dtoDDTO(Diagnostico diagnostico) {
		mapper.getConfiguration().setAmbiguityIgnored(true);
		DiagnosticoDTO dto = mapper.map(diagnostico, DiagnosticoDTO.class);
		dto.setCita(diagnostico.getCitaAsociada().getIdCita());
		
		return dto;
	}

}
