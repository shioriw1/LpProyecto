package com.mitocode.Final.service.impl;

import com.mitocode.Final.dto.CursosEstudianteDTO;
import com.mitocode.Final.dto.EstudianteDTO;
import com.mitocode.Final.model.Matricula;
import com.mitocode.Final.repo.IGenericRepo;
import com.mitocode.Final.repo.IMatriculaRepo;
import com.mitocode.Final.service.IMatriculaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MatriculaServiceImpl extends CRUDImpl <Matricula, Integer> implements IMatriculaService {

    private final IMatriculaRepo repo;


    @Override
    protected IGenericRepo<Matricula, Integer> getRepo() {
        return repo;
    }

    @Override
    public  Map<String, List<CursosEstudianteDTO>> obtenerCursoEstudiantes() {
         List<CursosEstudianteDTO>list= new ArrayList<>();
         repo.obtenerEstudianteCurso().forEach(x->{
             CursosEstudianteDTO estudianteDTO = new CursosEstudianteDTO();
             estudianteDTO.setNombreEstudiante(String.valueOf(x[0]));
             estudianteDTO.setNombreCurso(String.valueOf(x[1]));
             list.add(estudianteDTO);
         });
        Map<String, List<CursosEstudianteDTO>> group =
         list.stream().collect(Collectors.groupingBy(CursosEstudianteDTO::getNombreCurso));
         return group;
    }
}
