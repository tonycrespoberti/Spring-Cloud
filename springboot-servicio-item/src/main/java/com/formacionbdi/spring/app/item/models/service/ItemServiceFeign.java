package com.formacionbdi.spring.app.item.models.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.formacionbdi.spring.app.item.clientes.ProductoClienteRest;
import com.formacionbdi.spring.app.item.models.Item;
import com.formacionbdi.spring.app.item.models.Producto;

@Service("serviceFeign")
@Primary
public class ItemServiceFeign implements ItemService{

	//Inyectamos la interfaz ProductoClienteRest que dispone de los métodos para consumir el microservicio
	@Autowired
	private ProductoClienteRest clienteFeign;
	
	@Override
	public List<Item> findAll() {
		//hacemos uso del método listar de la interfaz ProductoClienteRest a través del atributo clienteFeign
		return clienteFeign.listar().stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		return new Item(clienteFeign.detalle(id), cantidad);
	}

	@Override
	public Producto save(Producto producto) {
		return clienteFeign.crear(producto);
	}

	@Override
	public Producto update(Producto producto, Long id) {
		return clienteFeign.update(producto, id);
	}

	@Override
	public void delete(Long id) {
		
	}
}
