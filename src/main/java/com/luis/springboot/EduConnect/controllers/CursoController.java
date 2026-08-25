package com.luis.springboot.EduConnect.controllers;

import com.luis.springboot.EduConnect.DTOs.CursoRequestDTO;
import com.luis.springboot.EduConnect.models.Curso;
import com.luis.springboot.EduConnect.services.CursoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    //DECLARAMOS EL SERVICIO
    private final CursoService cursoService;

    //DEFINIMOS LA VARIABLE DEL SERVICIO
    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    //CREAMOS UN NUEVO CURSO
    @PostMapping
    public ResponseEntity<?> guardar(@Valid @RequestBody CursoRequestDTO curso){
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.guardarCurso(curso));
    }

    //LISTAMOS CURSOS DISPONIBLES
    @GetMapping
    public ResponseEntity<?> listarCursos(){
        return ResponseEntity.status(HttpStatus.OK).body(cursoService.listarCursos());
    }
}
