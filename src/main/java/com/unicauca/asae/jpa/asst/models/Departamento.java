package com.unicauca.asae.jpa.asst.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Departamentos")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDepartamento;

    @Column(nullable = false, length = 30,unique = true, name = "nombreDepto")
    private String nombre;

    @Column(nullable = false, length = 30)
    private String descripcion;

    

}
