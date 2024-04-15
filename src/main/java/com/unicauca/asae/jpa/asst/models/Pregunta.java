package com.unicauca.asae.jpa.asst.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Pregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPregunta;

    @Column(nullable = false, length = 30)
    private String enunciado;

    @ManyToOne
    @JoinColumn(name = "idtipopregunta", nullable = false)
    private TipoPregunta objTipoPregunta;

    @ManyToOne
    @JoinColumn(name = "idcuestionario", nullable = false)
    private Cuestionario objCuestionario;
}
