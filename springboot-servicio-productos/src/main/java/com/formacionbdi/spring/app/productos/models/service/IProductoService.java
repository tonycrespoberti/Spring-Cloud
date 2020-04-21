package com.formacionbdi.spring.app.productos.models.service;

import java.util.List;

import com.formacionbdi.spring.app.productos.models.entity.Producto;
//import com.formacionbdi.spring.app.commons.models.entity.Producto;

public interface IProductoService {

	public List<Producto> findAll();
	public Producto findById(Long id);
	
	public Producto save(Producto producto);
	
	public void deleteById(Long id);

}
