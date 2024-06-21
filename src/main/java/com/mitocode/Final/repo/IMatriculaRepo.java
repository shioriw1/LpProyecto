package com.mitocode.Final.repo;

import com.mitocode.Final.dto.CursosEstudianteDTO;
import com.mitocode.Final.model.Matricula;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Objects;

public interface IMatriculaRepo extends IGenericRepo<Matricula, Integer> {
    @Query(value = "select e.nombre as nombreEstudiante,cu.nombre as nombreCurso from matricula ma inner join estudiante e on ma.id_estudiante = e.id\n" +
            " inner join detalle_matricula dm on ma.id_matricula = dm.id_matricula \n" +
            " inner join curso cu on dm.id_curso = cu.id_curso", nativeQuery = true)
    List<Object[]> obtenerEstudianteCurso();
}
