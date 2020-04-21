package com.formacionbdi.springboot.app.usuarios.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.formacionbdi.springboot.app.commons.usuarios.models.entity.Usuario;

//PagingAndSortingRepository hereda de CrudRepository por lo que a parte del pagineo y ordenar y otras
//funcionalidades tenemos la capacidad de hacer el CRUD
@RepositoryRestResource(path="usuarios")
public interface UsuarioDao extends PagingAndSortingRepository<Usuario, Long>{

	@RestResource(path = "buscar-username")
	public Usuario findByUsername(@Param("username") String username);
	
	//Podemos incorporar los filtros And u Or
	//Sería equivalente a where x.username = ?1 and x.email = ?2
	public Usuario findByUsernameAndEmail(String username, String email);
	
	//Consulta personalizada
	//Usuario es la clase porque estamos con JPA no es la tabla de la BBDD 
	//u es el alias de la clase Usuario
	@Query("select u from Usuario u where u.username=?1")
	public Usuario obtenerPorUsername(String username);
	
	//Si deseamos hacer una consulta SQL native a la BBDD usamos
	@Query(value = "select u from Usuario u where u.username=?1", nativeQuery = true)
	public Usuario obtenerNativoPorUsername(String username);
	
}
