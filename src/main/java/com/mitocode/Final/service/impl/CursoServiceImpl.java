package com.mitocode.Final.service.impl;

import com.mitocode.Final.model.Curso;
import com.mitocode.Final.model.Estudiante;
import com.mitocode.Final.repo.ICursoRepo;
import com.mitocode.Final.repo.IEstudianteRepo;
import com.mitocode.Final.repo.IGenericRepo;
import com.mitocode.Final.service.ICursoService;
import com.mitocode.Final.service.IEstudianteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CursoServiceImpl extends CRUDImpl <Curso, Integer> implements ICursoService {

    private final ICursoRepo repo;


    @Override
    protected IGenericRepo<Curso, Integer> getRepo() {
        return repo;
    }
}
