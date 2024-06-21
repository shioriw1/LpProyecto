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
public class EstudianteDTO {


    private Integer id;

    @NotNull
    @Size(min = 3, max = 30)
    private String nombre;

    @NotNull
    @Size(min = 3, max = 30)
    private String apellido;

    @NotNull
    private String DNI;

    @NotNull
    private String edad;

}
