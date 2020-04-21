package com.formacionbdi.spring.app.productos.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.spring.app.productos.models.entity.Producto;
import com.formacionbdi.spring.app.productos.models.service.IProductoService;
//import com.formacionbdi.spring.app.commons.models.entity.Producto; Usada para generar un dependency via Jar de la clase Producto

@RestController
public class ProductoController {

	@Autowired
	//Inyectamos el puerto del app properties
	private Environment env;
	
	//Inyectamos valores utilizados en el properties
	@Value("${server.port}")
	private Integer port;
	
	@Autowired
	private IProductoService productoService;
	
	
	//Otra forma de definir el EndPoitn @RequestMapping(value = "/listar", method = RequestMethod.GET)
	@GetMapping("/listar")
	public List<Producto> detalle(){
		
		return productoService.findAll().stream().map(producto -> {
			//producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			producto.setPort(port);
			return producto;
		}).collect(Collectors.toList());
	}

	@GetMapping("/ver/{id}")
	public Producto detalle(@PathVariable Long id) {
		Producto producto = productoService.findById(id);
		//producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		producto.setPort(port);
		
		/*
		//Para simular un fallo con Hytrix
		boolean ok = false;
		if (ok == false) {
			throw new Exception("No se pudo cargar el producto");
		}
		*/
		return productoService.findById(id);
	}

	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto crear(@RequestBody Producto producto) {
		return productoService.save(producto);
	}
	
	@PutMapping("/editar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto editar(@RequestBody Producto producto, @PathVariable Long id) {
		Producto productoDb = productoService.findById(id);
		
		productoDb.setNombre(producto.getNombre());
		productoDb.setPrecio(producto.getPrecio());
		
		return productoService.save(productoDb);
	}
	
	@DeleteMapping("/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Long id) {
		
		productoService.deleteById(id);
		
	}
}
