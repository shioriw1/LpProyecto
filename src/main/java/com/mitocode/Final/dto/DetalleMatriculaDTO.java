package com.mitocode.Final.dto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.mitocode.Final.model.Curso;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DetalleMatriculaDTO {

    @JsonBackReference
    private MatriculaDTO matricula;

    @NotNull
    private CursoDTO curso;

    @NotNull
    private String aula;

}
