package com.jonathannavas.springboot.kruger.app.models.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jonathannavas.springboot.kruger.app.models.entity.Role;
import com.jonathannavas.springboot.kruger.app.models.entity.Usuario;
import com.jonathannavas.springboot.kruger.app.models.entity.Vacuna;

public interface IUsuarioDao extends CrudRepository<Usuario, Long>{
	
	public Usuario findByUsername(String username);
	
	@Query("from Vacuna")
	public List<Vacuna> findAllVacunas();
	
	@Query("SELECT v FROM Vacuna v WHERE v.id != 1")
	public List<Vacuna> findAllVacunaList();
	
	public List<Usuario> findByVacuna(String vacuna);
	
	public List<Usuario> findByEstado(Boolean estado);
	
	//@Query("SELECT u FROM Usuario u")
	public Page<Usuario> findAll(Pageable pageable);

}
