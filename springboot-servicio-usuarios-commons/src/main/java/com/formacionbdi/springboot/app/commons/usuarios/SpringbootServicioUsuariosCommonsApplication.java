package com.formacionbdi.springboot.app.commons.usuarios;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class SpringbootServicioUsuariosCommonsApplication {

/* La quitamos para crear el commons de Usuario
	public static void main(String[] args) {
		SpringApplication.run(SpringbootServicioUsuariosCommonsApplication.class, args);
	}
*/
}
