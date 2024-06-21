package com.mitocode.Final.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class detalleMatricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idDetalleMatricula;

    @ManyToOne
    @JoinColumn(name = "id_curso", nullable = false, foreignKey = @ForeignKey(name = "FK_CURSO_DETALLE"))
    private Curso  curso;

    @Column
    private String aula;

    @ManyToOne
    @JoinColumn(name = "id_matricula", nullable = false, foreignKey = @ForeignKey(name = "FK_DETALLE_MATRICULA"))
    private Matricula matricula;

}
