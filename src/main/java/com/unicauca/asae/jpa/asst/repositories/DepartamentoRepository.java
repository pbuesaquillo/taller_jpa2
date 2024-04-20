package com.unicauca.asae.jpa.asst.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.unicauca.asae.jpa.asst.models.Departamento;

@Repository
public interface DepartamentoRepository extends CrudRepository<Departamento, Integer>{

}