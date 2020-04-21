package com.formacionbdi.springboot.app.usuarios;

import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import com.formacionbdi.springboot.app.commons.usuarios.models.entity.Role;
import com.formacionbdi.springboot.app.commons.usuarios.models.entity.Usuario;

public class RepositoryConfig implements RepositoryRestConfigurer{

	//Se agrega vía click derecho Source/Override/Implement Method 
	//La finalidad de esto es exponer o que se vean los Id cuando hacemos una petición http de los usuarios.
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {

		config.exposeIdsFor(Usuario.class, Role.class);
	}

	
}
