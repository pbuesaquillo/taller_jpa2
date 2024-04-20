package com.unicauca.asae.jpa.asst.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Departamentos")
@Getter
@Setter
@AllArgsConstructor
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDepartamento;

    @Column(nullable = false, length = 100,unique = true, name = "nombreDepto")
    private String nombre;

    @Column(nullable = false, length = 100)
    private String descripcion;

    public Departamento() {

    }
    
}
