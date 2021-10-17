package com.jonathannavas.springboot.kruger.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jonathannavas.springboot.kruger.app.models.entity.Role;
import com.jonathannavas.springboot.kruger.app.models.entity.Usuario;
import com.jonathannavas.springboot.kruger.app.models.entity.Vacuna;

public interface IUsuarioDao extends CrudRepository<Usuario, Long>{
	
	public Usuario findByUsername(String username);
	
	@Query("from Vacuna")
	public List<Vacuna> findAllVacunas();
	
	@Query("from Role")
	public List<Role> findAllRoles();
	

	public List<Usuario> findByVacuna(String vacuna);
	public List<Usuario> findByEstado(Boolean estado);
	public List<Usuario> findByRole(String role);

}
