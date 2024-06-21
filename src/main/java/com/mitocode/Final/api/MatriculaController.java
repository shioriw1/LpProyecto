package com.mitocode.Final.api;

import com.mitocode.Final.dto.CursosEstudianteDTO;
import com.mitocode.Final.dto.MatriculaDTO;
import com.mitocode.Final.model.Matricula;
import com.mitocode.Final.service.IMatriculaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/matricula")
@RequiredArgsConstructor
public class MatriculaController {

    private final IMatriculaService service;

    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity readAll() throws Exception{


        List<MatriculaDTO> list = service.readAll().stream().map(this::convertToDto ).toList();


        return ResponseEntity.ok(list);

    }

    @GetMapping("/{id}")
    public ResponseEntity<MatriculaDTO> readById(@PathVariable("id")  Integer id) throws Exception{
        Matricula obj = service.readById(id);


        return ResponseEntity.ok(convertToDto(obj));
    }

    @PostMapping
    public ResponseEntity<MatriculaDTO> save(@Valid @RequestBody MatriculaDTO dto) throws Exception{
        Matricula obj = service.save(convertToEntity(dto));

        return new ResponseEntity<>(convertToDto(obj),  HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<MatriculaDTO> update(@Valid @RequestBody  MatriculaDTO dto, @PathVariable("id") Integer id) throws Exception{
        dto.setIdMatricula(id);
        Matricula obj = service.update(convertToEntity(dto) , id);

        return ResponseEntity.ok(convertToDto(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);

        return ResponseEntity.noContent().build();

    }

    @GetMapping("/curso-estudiante")
    public  Map<String, List<CursosEstudianteDTO>> readByCurso() {
        Map<String, List<CursosEstudianteDTO>> list = service.obtenerCursoEstudiantes();
        return list;
    }


    private MatriculaDTO convertToDto(Matricula obj){
        return modelMapper.map(obj, MatriculaDTO.class);
    }

    private Matricula convertToEntity(MatriculaDTO dto){
        return modelMapper.map(dto, Matricula.class);
    }



}
