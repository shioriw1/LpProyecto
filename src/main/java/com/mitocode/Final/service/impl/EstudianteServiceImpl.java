package com.mitocode.Final.service.impl;

import com.mitocode.Final.model.Estudiante;
import com.mitocode.Final.model.Matricula;
import com.mitocode.Final.repo.IEstudianteRepo;
import com.mitocode.Final.repo.IGenericRepo;
import com.mitocode.Final.repo.IMatriculaRepo;
import com.mitocode.Final.service.IEstudianteService;
import com.mitocode.Final.service.IMatriculaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EstudianteServiceImpl extends CRUDImpl <Estudiante, Integer> implements IEstudianteService {

    private final IEstudianteRepo repo;


    @Override
    protected IGenericRepo<Estudiante, Integer> getRepo() {
        return repo;
    }
}
