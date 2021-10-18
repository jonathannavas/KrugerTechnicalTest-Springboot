package com.jonathannavas.springboot.kruger.app.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Pattern(regexp = "[A-Za-z ]+", message = "El nombre no puede tener numeros o caracteres especiales")
	@NotEmpty(message = "El nombre es obligatorio")
	@Size(min = 2, max = 60, message = "El tamaño requerido esta entre 2 y 60 caracteres")
	@Column(nullable = false)
	private String nombre;

	@Pattern(regexp = "[A-Za-z ]+", message = "El apellido no puede tener numeros o caracteres especiales")
	@NotEmpty(message = "El apellido es obligatorio")
	@Column(nullable = false)
	private String apellido;

	@NotEmpty(message = "El email es requerido")
	@Email(message = "Ingrese un correo electronico correcto ej: test@test.com")
	@Column(nullable = false, unique = true)
	private String email;

	@Pattern(regexp = "[0-9]+", message = "La cedula no puede tener letras o caracteres especiales")
	@NotEmpty(message = "La cedula es requerida")
	@Size(min = 10, max = 10, message = "Ingrese una cédula válida")
	@Column(nullable = false, unique = true)
	private String cedula;

	@Column(nullable = true, unique = true)
	private String username;

	@Column(nullable = true)
	private String password;

	@Column(nullable = true)
	private Date fecha_nacimiento;

	@Column(nullable = true)
	private String direccion;

	@Column(nullable = true)
	private String numero_telefono;

	@Column(nullable = false)
	private Boolean estado;
	
	@Column(nullable = true)
	private Date fecha_vacuna;
	
	@Column(nullable = true)
	private Integer num_dosis;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vacuna_id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Vacuna vacuna;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "usuarios_roles", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "role_id"), uniqueConstraints = {
			@UniqueConstraint(columnNames = { "usuario_id", "role_id" }) })
	private List<Role> roles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNumero_telefono() {
		return numero_telefono;
	}

	public void setNumero_telefono(String numero_telefono) {
		this.numero_telefono = numero_telefono;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Vacuna getVacuna() {
		return vacuna;
	}

	public void setVacuna(Vacuna vacuna) {
		this.vacuna = vacuna;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Date getFecha_vacuna() {
		return fecha_vacuna;
	}

	public void setFecha_vacuna(Date fecha_vacuna) {
		this.fecha_vacuna = fecha_vacuna;
	}

	public Integer getNum_dosis() {
		return num_dosis;
	}

	public void setNum_dosis(Integer num_dosis) {
		this.num_dosis = num_dosis;
	}

	private static final long serialVersionUID = 1L;
}
