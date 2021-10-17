package com.jonathannavas.springboot.kruger.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jonathannavas.springboot.kruger.app.models.dao.IUsuarioDao;
import com.jonathannavas.springboot.kruger.app.models.entity.Role;
import com.jonathannavas.springboot.kruger.app.models.entity.Usuario;
import com.jonathannavas.springboot.kruger.app.models.entity.Vacuna;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
	
	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		return (List<Usuario>) usuarioDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findById(Long id) {
		return usuarioDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Usuario save(Usuario usuario) {
		return usuarioDao.save(usuario);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		usuarioDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Vacuna> findAllVacunas() {
		return usuarioDao.findAllVacunas();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Role> findAllRoles() {
		return usuarioDao.findAllRoles();
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findByUsername(String username) {
		return usuarioDao.findByUsername(username);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findByVacuna(String vacuna) {
		return usuarioDao.findByVacuna(vacuna);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findByEstado(Boolean estado) {
		return usuarioDao.findByEstado(estado);
	}



}
