package com.unicauca.asae.jpa.asst.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Docente extends Persona{

    @Column(nullable = false, length = 30)
    private String correo;

    @Column(nullable = false, length = 30)
    private String vinculacion;

    @OneToOne(cascade = {CascadeType.REMOVE, CascadeType.PERSIST}, mappedBy = "objDocente")
    @PrimaryKeyJoinColumn
    private Telefono objTelefono; 


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Departamentos-Docentes",joinColumns =  @JoinColumn(name = "idPersona"), inverseJoinColumns = @JoinColumn(name = "idDepartamento"))
    private List<Departamento> departamentos;

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "objDocente")
    private List<Respuesta> respuestas;


    public Docente(Integer idPersona, String tipoIdentificacion, String numeroIdentificacion, String nombres, String apellidos, String correo, String vinculacion) {
        super(idPersona, tipoIdentificacion, numeroIdentificacion, nombres, apellidos);
        this.correo=correo;
        this.vinculacion=vinculacion;
        this.departamentos = new ArrayList<>();
    }

}
