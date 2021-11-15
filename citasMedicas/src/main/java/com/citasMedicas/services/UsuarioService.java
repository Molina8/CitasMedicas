package com.citasMedicas.services;

import java.util.List;



import com.citasMedicas.dominio.Usuario;


public interface UsuarioService {
	public abstract List<Usuario> listAllUsuarios();
	public abstract Usuario findByUsername(String username);
	public abstract Usuario saveUser(Usuario u);
	public abstract Usuario findById(Long id);
	public abstract void deleteUser(Long id);
	public abstract Usuario login(String userName,String passWord);
}
