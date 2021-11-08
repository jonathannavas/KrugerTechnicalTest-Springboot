package com.jonathannavas.springboot.kruger.app.models.services;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jonathannavas.springboot.kruger.app.models.entity.Role;
import com.jonathannavas.springboot.kruger.app.models.entity.Usuario;
import com.jonathannavas.springboot.kruger.app.models.entity.Vacuna;

public interface IUsuarioService {

	public List<Usuario> findAll();
	public Usuario findById(Long id);
	public Usuario save(Usuario usuario);
	public void delete(Long id);
	
	public List<Vacuna> findAllVacunas();
	
	public List<Vacuna> findAllVacunaList();
	
	public Usuario findByUsername(String username);
	
	public List<Usuario> findByVacuna(String vacuna);
	
	public List<Usuario> findByEstado(Boolean estado);
	
	public Page<Usuario> findAll(Pageable pageable);
	
	public Page<Usuario> findByEstado(Pageable pageable,boolean estado);
	
	public Page<Usuario> findByVacuna(Pageable pageable,Long vacunaId);
	
	public Page<Usuario> findByFechaVacuna(Pageable pageable,Date fechaInicio, Date fechaFin);
	
}
