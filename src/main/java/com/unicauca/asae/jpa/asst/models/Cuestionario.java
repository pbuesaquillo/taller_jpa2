package com.unicauca.asae.jpa.asst.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Cuestionarios")
@Getter
@Setter
public class Cuestionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCuestionario;

    @Column(length = 30, nullable = false)
    private String titulo;

    @Column(nullable = false, length = 30)
    private String descripcion;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "objCuestionario", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Pregunta> preguntas;


}
