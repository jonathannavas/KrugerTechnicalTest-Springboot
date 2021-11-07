package com.jonathannavas.springboot.kruger.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.jonathannavas.springboot.kruger.app.models.entity.Vacuna;

public interface IVacunaDao extends CrudRepository<Vacuna, Long> {

}
