package com.everis.data.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
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
import com.everis.data.services.CategoriaService;
import com.everis.data.services.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	//dependencia servicio
	@Autowired
	private UsuarioService us;
	@Autowired
	private CategoriaService cs;

	@RequestMapping("")
	public String index(/*Model model,*/ @ModelAttribute("usuario") Usuario usuario, Model model)
	{
		System.out.println("Index");
		//model.addAttribute(new Usuario());
		
		List<Usuario> listaUsuarios = us.findAll();
		model.addAttribute("lista_usuarios", listaUsuarios);
		model.addAttribute("lista_categorias", cs.findAll());
		
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
	
	
	//METODOS DE REGISTRO E INGRESO
	@RequestMapping("/login")
	public String login() {
		return "login.jsp";
	}
	
	@RequestMapping("/registro")
	public String registro(@ModelAttribute("usuario") Usuario usuario) {
		return "registro.jsp";
	}
	
	@RequestMapping("/ingresar")
	public String ingresar(Model model, @RequestParam("email") String email,
			@RequestParam("password") String password,
			HttpSession session
			) {
		boolean exiteUsuario = us.validarUsuario(email, password);
		if(exiteUsuario) {
			Usuario usuario = us.findByEmail(email);
			//guardando un elemento en session
			session.setAttribute("usuarioId", usuario.getId());
			return "redirect:/producto/listar";
		}
		model.addAttribute("error", "Error al iniciar sesion");
		return "login.jsp";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@Valid @ModelAttribute("usuario") Usuario usuario) {
		//llamar a las validaciones
		us.save(usuario);
		return "redirect:/usuario/login";
	}
	
	@RequestMapping("/home")
	public String home(HttpSession session){
		//valida el acceso a rutas
		if(session.getAttribute("usuarioId")!=null) {
			return "home.jsp";
		}
		return "redirect:/usuario/login";
		
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		
		if(session.getAttribute("usuarioId")!=null) {
			session.invalidate();//matamos todas las variables de session
		}
		return "redirect:/usuario/login";
	}
	
}
