package com.everis.data.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String index() {
		return "login.jsp";
	}
	
	@RequestMapping("/home")
	public String home() //SE VISUALIZARA EN EL HOME LA LISTA DE PRODUCTOS!.
	{
		return "redirect:/producto/listar";
	}
}
