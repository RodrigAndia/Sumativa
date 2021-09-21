package com.everis.data.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
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
	public String index(@ModelAttribute("producto") Producto producto, Model model)
	{
		System.out.println("Index");		
		List<Producto> listaProductos = ps.findAll();
		model.addAttribute("lista_productos", listaProductos);
		
		return "producto.jsp";
	}
	
	@RequestMapping(value="/crear", method=RequestMethod.POST)
	public String crear(@Valid @ModelAttribute("producto") Producto producto)
	{
		System.out.println("Crear "+producto.getNombre()+" "+producto.getPrecio()+" "+producto.getCaracteristicas());
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
	
	@RequestMapping("listar")
	public String listarProductos(/*Model model,*/ @ModelAttribute("producto") Producto producto, Model model)
	{		
		List<Producto> listaProductos = ps.findAll();
		listaProductos.removeIf(n -> n.getExistencias()==0);
		model.addAttribute("lista_productos", listaProductos);
		
		return "home.jsp";
	}
	
	@RequestMapping("resumen")
	public String resumen(@RequestParam(value="prod",required=false) String productos, Model model)
	{
		double costoTotal = 0;
		if (productos == null)
		{
			model.addAttribute("error","¡No ha seleccionado ningun producto!");
			return "resumen.jsp";
		}
		List<Producto> add_productos = new ArrayList<Producto>();
		for (String producto_id : productos.split(",")) {
			Producto producto = ps.buscarProducto(Long.parseLong(producto_id));
			costoTotal+=producto.getPrecio();
			producto.setExistencias(producto.getExistencias()-1);
			this.modificar(producto);
			add_productos.add(producto);
		}
		model.addAttribute("lista_productos",add_productos);
		model.addAttribute("costo_total", costoTotal);
		return "resumen.jsp";
	}

}
