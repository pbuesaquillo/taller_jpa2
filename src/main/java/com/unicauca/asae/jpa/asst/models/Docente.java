package com.unicauca.asae.jpa.asst.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Docentes")
@Getter
@Setter
public class Docente extends Persona{

    @Column(nullable = false, length = 30)
    private String correo;

    @Column(nullable = false, length = 30)
    private String vinculacion;

    @OneToOne(cascade = {CascadeType.REMOVE, CascadeType.PERSIST}, mappedBy = "objDocente")
    @PrimaryKeyJoinColumn
    private Telefono objTelefono; 


    
    private List<Departamento> departamentos;

}
