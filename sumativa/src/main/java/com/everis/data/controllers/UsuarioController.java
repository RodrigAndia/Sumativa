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

import com.everis.data.models.Usuario;
import com.everis.data.services.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	//dependencia servicio
	@Autowired
	private UsuarioService us;

	@RequestMapping("")
	public String index(/*Model model,*/ @ModelAttribute("usuario") Usuario usuario, Model model)
	{
		System.out.println("Index");
		//model.addAttribute(new Usuario());
		
		ArrayList<Usuario> listaUsuarios = us.findAll();
		model.addAttribute("lista_usuarios", listaUsuarios);
		
		return "usuario.jsp";
	}
	
	@RequestMapping(value="/crear", method=RequestMethod.POST)
	public String crear(@Valid @ModelAttribute("usuario") Usuario usuario)
	{
		System.out.println("Crear "+usuario.getNombre());
		us.crearUsuario(usuario);
		return "redirect:/usuario";
	}

	@RequestMapping(value="/actualizar/{id}", method = RequestMethod.GET)
	public String actualizar(@PathVariable("id") Long id, Model model) {
		System.out.println("actualizar id: "+ id);
		Usuario usuario = us.buscarUsuario(id);
		model.addAttribute("usuario",usuario);
		return "editar_usuario.jsp";
	}
	
	@RequestMapping(value="/modificar", method = RequestMethod.PUT)
	public String modificar(@Valid @ModelAttribute("usuario") Usuario usuario)
	{
		us.modificarUsuario(usuario);
		return "redirect:/usuario";
	}
	
	@RequestMapping(value="/eliminar", method = RequestMethod.POST)
	public String eliminar(@RequestParam("id") Long id)
	{
		System.out.println("Eliminar id: "+ id);
		us.eliminarUsuario(id);
		return "redirect:/usuario";
	}
	
	@RequestMapping("/buscar")
	public String buscar()
	{
		return "redirect:/usuario";
	}
}
