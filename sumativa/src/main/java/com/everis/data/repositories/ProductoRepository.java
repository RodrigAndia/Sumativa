package com.everis.data.repositories;

import java.util.ArrayList;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.everis.data.models.Producto;

@Repository
public interface ProductoRepository extends CrudRepository<Producto,Long> {
	//plantilla
	//intereccion con la base de datos
	//metodos que heredaremos de otras clases (CRUD y Jpa)
	ArrayList<Producto> findAll();
}
