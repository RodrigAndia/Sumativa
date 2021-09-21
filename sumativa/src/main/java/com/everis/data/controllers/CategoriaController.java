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

import com.everis.data.models.Categoria;
import com.everis.data.services.CategoriaService;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {
	
	//dependencia servicio
	@Autowired
	private CategoriaService cs;

	@RequestMapping("")
	public String index(/*Model model,*/ @ModelAttribute("categoria") Categoria categoria, Model model)
	{
		System.out.println("Index");
		//model.addAttribute(new Categoria());
		
		List<Categoria> listaCategorias = cs.findAll();
		model.addAttribute("lista_categorias", listaCategorias);
		
		return "categoria.jsp";
	}
	
	@RequestMapping(value="/crear", method=RequestMethod.POST)
	public String crear(@Valid @ModelAttribute("categoria") Categoria categoria)
	{
		cs.crearCategoria(categoria);
		return "redirect:/categoria";
	}

	@RequestMapping(value="/actualizar/{id}", method = RequestMethod.GET)
	public String actualizar(@PathVariable("id") Long id, Model model) {
		System.out.println("actualizar id: "+ id);
		Categoria categoria = cs.buscarCategoria(id);
		model.addAttribute("categoria",categoria);
		return "editar_categoria.jsp";
	}
	
	@RequestMapping(value="/modificar", method = RequestMethod.PUT)
	public String modificar(@Valid @ModelAttribute("categoria") Categoria categoria)
	{
		cs.modificarCategoria(categoria);
		return "redirect:/categoria";
	}
	
	@RequestMapping(value="/eliminar", method = RequestMethod.POST)
	public String eliminar(@RequestParam("id") Long id)
	{
		System.out.println("Eliminar id: "+ id);
		cs.eliminarCategoria(id);
		return "redirect:/categoria";
	}
	
	@RequestMapping("/buscar")
	public String buscar()
	{
		return "redirect:/categoria";
	}
}
