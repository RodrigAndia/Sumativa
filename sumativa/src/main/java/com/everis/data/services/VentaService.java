package com.everis.data.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.data.models.Venta;
import com.everis.data.repositories.VentaRepository;

@Service
public class VentaService {
	
	//dependencia servicio
	@Autowired
	private VentaRepository vr;
	
	public Venta crearVenta(@Valid Venta producto) {
		return vr.save(producto);
	}

	public List<Venta> findAll() {
		// TODO Auto-generated method stub
		return vr.findAll();
	}

	public void eliminarVenta(Long id) {
		vr.deleteById(id);
	}

	public Venta buscarVenta(Long id) {
		
		Optional<Venta> oVenta = vr.findById(id);
		
		if(oVenta.isPresent())
		{
			return oVenta.get();
		}
		return null;
	}

	public void modificarVenta(@Valid Venta producto) {
		vr.save(producto);
	}

	public Venta insertarVenta(Venta producto) {
		return vr.save(producto);
	}
	
}

