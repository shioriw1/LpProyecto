package com.mitocode.Final.api;

import com.mitocode.Final.dto.EstudianteDTO;
import com.mitocode.Final.dto.MatriculaDTO;
import com.mitocode.Final.model.Estudiante;
import com.mitocode.Final.model.Matricula;
import com.mitocode.Final.service.IEstudianteService;
import com.mitocode.Final.service.IMatriculaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;


@RestController
@RequestMapping("/estudiante")
@RequiredArgsConstructor
public class EstudianteController {



    private final IEstudianteService service;

    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<EstudianteDTO>> readAll() throws Exception{


        List<EstudianteDTO> list = service.readAll().stream().map(this::convertToDto).sorted(Comparator.comparing(EstudianteDTO::getEdad).reversed()).toList();

        return ResponseEntity.ok(list);

    }

    @GetMapping("/{id}")
    public ResponseEntity<EstudianteDTO> readById(@PathVariable("id")  Integer id) throws Exception{
        Estudiante obj = service.readById(id);


        return ResponseEntity.ok(convertToDto(obj));
    }

    @PostMapping
    public ResponseEntity<EstudianteDTO> save(@Valid @RequestBody EstudianteDTO dto) throws Exception{
        Estudiante obj = service.save(convertToEntity(dto));

        return new ResponseEntity<>(convertToDto(obj),  HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<EstudianteDTO> update(@Valid @RequestBody  EstudianteDTO dto, @PathVariable("id") Integer id) throws Exception{
        dto.setId(id);
        Estudiante obj = service.update(convertToEntity(dto) , id);

        return ResponseEntity.ok(convertToDto(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);

        return ResponseEntity.noContent().build();

    }



    private EstudianteDTO convertToDto(Estudiante obj){
        return modelMapper.map(obj, EstudianteDTO.class);
    }

    private Estudiante convertToEntity(EstudianteDTO dto){
        return modelMapper.map(dto, Estudiante.class);
    }
}
