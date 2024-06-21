package com.mitocode.Final.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CursoDTO {

    private Integer idCurso;

    @NotNull
    @Size(min = 2, max = 30)
    private String nombre;

    @NotNull
    private String siglas;

    @NotNull
    private boolean estado;
}
