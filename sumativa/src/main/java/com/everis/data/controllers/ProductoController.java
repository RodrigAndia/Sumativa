package com.everis.data.controllers;

import java.util.ArrayList;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.data.models.Producto;
import com.everis.data.services.ProductoService;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	
	//dependencia servicio
	@Autowired
	private ProductoService ps;

	@RequestMapping("")
	public String index(/*Model model,*/ @ModelAttribute("producto") Producto producto, Model model)
	{
		System.out.println("Index");
		//model.addAttribute(new Producto());
		
		ArrayList<Producto> listaProductos = ps.findAll();
		model.addAttribute("lista_productos", listaProductos);
		
		return "producto.jsp";
	}
	
	@RequestMapping(value="/crear", method=RequestMethod.POST)
	public String crear(@Valid @ModelAttribute("producto") Producto producto)
	{
		System.out.println("Crear "+producto.getNombre()+" "+producto.getPrecio()+" "+producto.getExistencia());
		ps.crearProducto(producto);
		return "redirect:/producto";
	}

	@RequestMapping(value="/actualizar/{id}", method = RequestMethod.GET)
	public String actualizar(@PathVariable("id") Long id, Model model) {
		System.out.println("actualizar id: "+ id);
		Producto producto = ps.buscarProducto(id);
		model.addAttribute("producto",producto);
		return "editar_producto.jsp";
	}
	
	@RequestMapping(value="/modificar", method = RequestMethod.PUT)
	public String modificar(@Valid @ModelAttribute("producto") Producto producto)
	{
		ps.modificarProducto(producto);
		return "redirect:/producto";
	}
	
	@RequestMapping(value="/eliminar", method = RequestMethod.POST)
	public String eliminar(@RequestParam("id") Long id)
	{
		System.out.println("Eliminar id: "+ id);
		ps.eliminarProducto(id);
		return "redirect:/producto";
	}
	
	@RequestMapping("/buscar")
	public String buscar()
	{
		return "redirect:/producto";
	}
}
