package com.unicauca.asae.jpa.asst.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Personas")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idPersona;

    @Column(nullable = false, length = 30)
    private String tipoIdentificacion;

    @Column(nullable = false, length = 30, unique = true)
    private String numeroIdentificacion;

    @Column(name = "nombres",nullable = false , length = 30)
    private String nombres;

    @Column(name = "apellidos",nullable = false , length = 30)
    private String apellidos;

    public Persona(String tipoIdentificacion, String numeroIdentificacion, String nombre, String apellido){
        this.tipoIdentificacion = tipoIdentificacion;
        this.numeroIdentificacion = numeroIdentificacion;
        this.nombres = nombre;
        this.apellidos = apellido;
    }
}
