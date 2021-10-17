package com.jonathannavas.springboot.kruger.app.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jonathannavas.springboot.kruger.app.models.entity.Usuario;
import com.jonathannavas.springboot.kruger.app.models.entity.Vacuna;
import com.jonathannavas.springboot.kruger.app.models.services.IUsuarioService;

@RestController
@RequestMapping("/api")
public class UsuarioRestController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@GetMapping("/usuarios")
	public List<Usuario> index(){
		return usuarioService.findAll();
	}
	
	@GetMapping("/usuarios/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		
		Usuario usuario = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			usuario = usuarioService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(usuario==null) {
			response.put("mensaje", "El usuario con el ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
	@PostMapping("/usuarios")
	public ResponseEntity<?> create(@Valid @RequestBody Usuario usuario, BindingResult result) {
		
		Usuario usuarioNuevo = null;
		Vacuna vacuna = new Vacuna();
		vacuna.setId((long) 1);
		
		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {

			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "'" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			response.put("errors", errors); 
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		try {
			
			usuario.setUsername(usuario.getCedula());
			usuario.setPassword(usuario.getCedula());
			usuario.setEstado(false);
			usuario.setVacuna(vacuna);
			
			usuarioNuevo = usuarioService.save(usuario);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El usuario ha sido creado con éxito!");
		response.put("usuario", usuarioNuevo);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
	}
	
	@PutMapping("/usuarios/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Usuario usuario, BindingResult result, @PathVariable Long id) {
		
		Usuario usuarioActual = usuarioService.findById(id);
		Usuario usuarioActualizado = null;
		

		Map<String, Object> response = new HashMap<>();

		if(result.hasErrors()) {
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		if (usuarioActual == null) {
			response.put("mensaje", "Error: no se pudo editar, el usuario ID: "
					.concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		try {
			
			usuarioActual.setNombre(usuario.getNombre());
			usuarioActual.setApellido(usuario.getApellido());
			
			if(	usuario.getEstado()== null || usuario.getNum_dosis() == null || usuario.getFecha_vacuna() == null ) {
				Vacuna vacuna = new Vacuna();
				vacuna.setId((long) 1);
				usuarioActual.setVacuna(vacuna);
				usuarioActual.setFecha_vacuna(null);
				usuarioActual.setNum_dosis(0);
			}
			
			usuarioActual.setFecha_nacimiento(usuario.getFecha_nacimiento());
			usuarioActual.setEstado(usuario.getEstado());
			usuarioActual.setFecha_vacuna( usuario.getFecha_vacuna() );
			usuarioActual.setNum_dosis( usuario.getNum_dosis() );
			usuarioActual.setDireccion( usuario.getDireccion() );
			usuarioActual.setNumero_telefono( usuario.getNumero_telefono() );
			usuarioActual.setRole( usuario.getRole() );
			usuarioActual.setVacuna(  usuario.getVacuna());
			
			usuarioActualizado = usuarioService.save(usuarioActual);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar el usuario en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El cliente ha sido actualizado con éxito!");
		response.put("usuario", usuarioActualizado);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/usuarios/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		try {
			usuarioService.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el usuario de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El usuario ha sido eliminado con exito");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/usuarios/estado-vacunado")
	public List<Usuario> estadoVacuna(@RequestParam Boolean estado){
		return usuarioService.findByEstado(estado);
	}
	/*
	@GetMapping("/usuarios/tipo-vacuna")
	public List<Usuario> tipoVacuna(@RequestParam String vacuna){
		return usuarioService.findByVacuna(vacuna);
	}
	
	@GetMapping("/usuarios/fecha")
	public List<Usuario> rangofechaVacunacion( @RequestParam Date fechaInicio, @RequestParam Date fechaFin ){
		return usuarioService.findByFechaVacunacion(fechaInicio, fechaFin);
	}
*/
	

}
