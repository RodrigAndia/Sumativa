package com.everis.data.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.data.models.Categoria;
import com.everis.data.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	//dependencia servicio
	@Autowired
	private CategoriaRepository cr;
	
	public Categoria crearCategoria(@Valid Categoria Categoria) {
		System.out.println("SERVICE "+Categoria.getNombre());
		return cr.save(Categoria);
	}

	public List<Categoria> findAll() {
		// TODO Auto-generated method stub
		return cr.findAll();
	}

	public void eliminarCategoria(Long id) {
		cr.deleteById(id);
	}

	public Categoria buscarCategoria(Long id) {
		
		Optional<Categoria> oCategoria = cr.findById(id);
		
		if(oCategoria.isPresent())
		{
			return oCategoria.get();
		}
		return null;
	}

	public void modificarCategoria(@Valid Categoria Categoria) {
		cr.save(Categoria);
	}

	public Categoria insertarCategoria(Categoria Categoria) {
		return cr.save(Categoria);
	}
	
}

