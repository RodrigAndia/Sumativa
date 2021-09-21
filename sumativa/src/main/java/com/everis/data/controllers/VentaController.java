package com.everis.data.controllers;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.data.models.Venta;
import com.everis.data.services.VentaService;

@Controller
@RequestMapping("/venta")
public class VentaController {
	
	//dependencia servicio
	@Autowired
	private VentaService vs;

	@RequestMapping("")
	public String index(/*Model model,*/ @ModelAttribute("venta") Venta venta, Model model)
	{
		System.out.println("Index");
		//model.addAttribute(new Venta());
		
		List<Venta> listaVentas = vs.findAll();
		model.addAttribute("lista_ventas", listaVentas);
		
		return "venta.jsp";
	}
	
	@RequestMapping(value="/crear", method=RequestMethod.POST)
	public String crear(@Valid @ModelAttribute("venta") Venta venta)
	{
		System.out.println("Crear "+venta.getId());
		vs.crearVenta(venta);
		return "redirect:/venta";
	}

	@RequestMapping(value="/actualizar/{id}", method = RequestMethod.GET)
	public String actualizar(@PathVariable("id") Long id, Model model) {
		System.out.println("actualizar id: "+ id);
		Venta venta = vs.buscarVenta(id);
		model.addAttribute("venta",venta);
		return "editar_venta.jsp";
	}
	
	@RequestMapping(value="/modificar", method = RequestMethod.PUT)
	public String modificar(@Valid @ModelAttribute("venta") Venta venta)
	{
		vs.modificarVenta(venta);
		return "redirect:/venta";
	}
	
	@RequestMapping(value="/eliminar", method = RequestMethod.POST)
	public String eliminar(@RequestParam("id") Long id)
	{
		System.out.println("Eliminar id: "+ id);
		vs.eliminarVenta(id);
		return "redirect:/venta";
	}
	
	@RequestMapping("/buscar")
	public String buscar()
	{
		return "redirect:/venta";
	}
}
