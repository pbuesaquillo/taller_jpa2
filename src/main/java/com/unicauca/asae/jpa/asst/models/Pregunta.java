package com.unicauca.asae.jpa.asst.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "preguntas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPregunta;

    @Column(nullable = false, length = 250)
    private String enunciado;

    @ManyToOne
    @JoinColumn(name = "idtipopregunta")
    private TipoPregunta objTipoPregunta;

    @ManyToOne
    @JoinColumn(name = "idcuestionario")
    private Cuestionario objCuestionario;

    @OneToMany(mappedBy = "objPregunta",fetch = FetchType.EAGER)
    private List<Respuesta> respuestas;

}
