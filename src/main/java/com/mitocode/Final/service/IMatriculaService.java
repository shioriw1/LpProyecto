package com.mitocode.Final.service;


import com.mitocode.Final.dto.CursosEstudianteDTO;
import com.mitocode.Final.model.Matricula;

import java.util.List;
import java.util.Map;

public interface IMatriculaService extends ICRUD<Matricula, Integer>{


    Map<String, List<CursosEstudianteDTO>> obtenerCursoEstudiantes();
}
