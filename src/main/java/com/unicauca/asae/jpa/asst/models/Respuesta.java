package com.unicauca.asae.jpa.asst.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Respuestas")
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRespuesta;

    @ManyToOne
    @JoinColumn(name = "idDocente", nullable = false)
    private Docente objDocente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idPregunta", nullable = false)
    private Pregunta objPregunta;

    @Column(nullable = false, length = 200)
    private String descripcion;

}
