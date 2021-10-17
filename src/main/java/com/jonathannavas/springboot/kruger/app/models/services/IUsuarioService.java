package com.jonathannavas.springboot.kruger.app.models.services;

import java.util.List;

import com.jonathannavas.springboot.kruger.app.models.entity.Usuario;
import com.jonathannavas.springboot.kruger.app.models.entity.Vacuna;

public interface IUsuarioService {

	public List<Usuario> findAll();
	public Usuario findById(Long id);
	public Usuario save(Usuario usuario);
	public void delete(Long id);
	
	public List<Vacuna> findAllVacunas();
	public Usuario findByUsername(String username);
	public List<Usuario> findByVacuna(String vacuna);
	public List<Usuario> findByEstado(String estado);
	
}
