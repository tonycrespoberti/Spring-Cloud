package com.formacionbdi.springboot.app.oauth.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.formacionbdi.springboot.app.commons.usuarios.models.entity.Usuario;

//Indicamos el name del microservicio al que deseamos conectarnos
@FeignClient(name = "servicio-usuarios")
public interface UsuarioFeignClient {

	//Indicamos como endpoint el path usuarios que especificamos en el microservicio servicio-usuarios en la interfaz
	//UsuarioDao así como la palabra search para acceder a consultas customizadas buscar-username
	@GetMapping("/usuarios/search/buscar-username")
	public Usuario findByUsername(@RequestParam String username);
	
}
