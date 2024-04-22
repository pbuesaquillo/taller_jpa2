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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class TipoPregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoPregunta;

    @Column(nullable = false, length = 200)
    private String nombre;

    @Column(nullable = false, length = 200)
    private String descripcion;

    @OneToMany(mappedBy = "objTipoPregunta", fetch = FetchType.EAGER)
    private List<Pregunta> preguntas;

    public TipoPregunta() {

    }

}
