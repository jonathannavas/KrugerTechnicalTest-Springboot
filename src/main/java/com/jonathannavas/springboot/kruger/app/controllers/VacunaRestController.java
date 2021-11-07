package com.jonathannavas.springboot.kruger.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jonathannavas.springboot.kruger.app.models.entity.Vacuna;
import com.jonathannavas.springboot.kruger.app.models.services.IUsuarioService;


@CrossOrigin(origins = "*" )
@RestController
@RequestMapping("/api")
public class VacunaRestController {

	@Autowired
	private IUsuarioService usuarioService;
	
	@Secured("ROLE_USER")
	@GetMapping("/vacunas")
	public List<Vacuna> index(){
		List<Vacuna> vacunas = usuarioService.findAllVacunaList();
		return vacunas;
	}
}
