package com.mitocode.Final.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MatriculaDTO {


    private Integer idMatricula;

    @NotNull
    private LocalDateTime fechaMatricula;

    @NotNull
    private EstudianteDTO estudiante;

    @JsonManagedReference
    @NotNull
    private List<DetalleMatriculaDTO> detallematricula;
    @NotNull
    private boolean enabledMatricula;
}
