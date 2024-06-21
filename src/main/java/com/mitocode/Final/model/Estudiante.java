package com.mitocode.Final.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Estudiante {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@EqualsAndHashCode.Include
private Integer id;

@Column (length = 100, nullable = false)
private String nombre;

@Column (length = 100, nullable = false)
private String apellido;

@Column (length = 10, nullable = false, unique = true)
private String DNI;

@Column (length = 10, nullable = false)
private String edad;
}
