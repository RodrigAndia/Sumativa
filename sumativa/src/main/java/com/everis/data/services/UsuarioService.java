package com.everis.data.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.data.models.Usuario;
import com.everis.data.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	//dependencia servicio
	@Autowired
	private UsuarioRepository ur;
	
	public Usuario crearUsuario(@Valid Usuario usuario) {
		return ur.save(usuario);
	}

	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return ur.findAll();
	}

	public void eliminarUsuario(Long id) {
		ur.deleteById(id);
	}

	public Usuario buscarUsuario(Long id) {
		
		Optional<Usuario> oUsuario = ur.findById(id);
		
		if(oUsuario.isPresent())
		{
			return oUsuario.get();
		}
		return null;
	}

	public void modificarUsuario(@Valid Usuario usuario) {
		ur.save(usuario);
	}

	public Usuario insertarUsuario(Usuario usuario) {
		return ur.save(usuario);
	}
	
	public void save(@Valid Usuario usuario) {
		// hash password
        String hashed = BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt());
        usuario.setPassword(hashed);
        ur.save(usuario);
	}

	public boolean validarUsuario(String email, String password) {
		
		Usuario usuario = ur.findByEmail(email);
		//siempre validar si es null
		if(usuario == null) {
			return false;
		}else {
			//comparar los password
			if (BCrypt.checkpw(password, usuario.getPassword())) {
			    System.out.println("Password iguales");
				return true;
				
			}else {
			    System.out.println("Password Distintos");
			    return false;
			}
			
		}
	}

	public Usuario findByEmail(String email) {
		return ur.findByEmail(email);
	}
	
	
}

