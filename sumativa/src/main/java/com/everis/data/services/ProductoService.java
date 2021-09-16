package com.everis.data.services;

import java.util.ArrayList;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.data.models.Producto;
import com.everis.data.repositories.ProductoRepository;

@Service
public class ProductoService {
	
	//dependencia servicio
	@Autowired
	private ProductoRepository pr;
	
	public Producto crearProducto(@Valid Producto producto) {
		System.out.println("SERVICE "+producto.getNombre());
		return pr.save(producto);
	}

	public ArrayList<Producto> findAll() {
		// TODO Auto-generated method stub
		return pr.findAll();
	}

	public void eliminarProducto(Long id) {
		pr.deleteById(id);
	}

	public Producto buscarProducto(Long id) {
		
		Optional<Producto> oProducto = pr.findById(id);
		
		if(oProducto.isPresent())
		{
			return oProducto.get();
		}
		return null;
	}

	public void modificarProducto(@Valid Producto producto) {
		pr.save(producto);
	}

	public Producto insertarProducto(Producto producto) {
		return pr.save(producto);
	}
	
}

