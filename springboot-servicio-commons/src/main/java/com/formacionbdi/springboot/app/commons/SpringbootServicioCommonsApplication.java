package com.formacionbdi.springboot.app.commons;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//Aun cuando EnableAutoConfiguration está incluñida en @SpringBootApplication
//la incorporamos para sobreescribir la de SpringBoot y excluimos el DataSource dado que
//no haremos uso de acceso a BBDD
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication
public class SpringbootServicioCommonsApplication {

	/* Se quita el método main porque es un proyecto de librería, no de ejecución de una app
	public static void main(String[] args) {
		SpringApplication.run(SpringbootServicioCommonsApplication.class, args);
	}
	 */
}
