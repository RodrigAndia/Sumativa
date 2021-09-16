package com.everis.data.services;

import java.util.ArrayList;
import java.util.Optional;

import javax.validation.Valid;

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

	public ArrayList<Usuario> findAll() {
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
	
}

