package com.luis.springboot.EduConnect.controllers;

import com.luis.springboot.EduConnect.DTOs.InscripcionRequestDTO;
import com.luis.springboot.EduConnect.services.InscripcionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inscripciones")
public class InscripcionController {

    //DECLARAMOS EL SERVICIO INSCRIPCION
    private final InscripcionService inscripcionService;

    //DEFINIMOS LA VARIABLE SERVICIO
    public InscripcionController(InscripcionService inscripcionService) {
        this.inscripcionService = inscripcionService;
    }

    //CREAMOS UNA NUEVA INSCRIPCION
    @PostMapping
    public ResponseEntity<?> guardar(@Valid @RequestBody InscripcionRequestDTO bean){
        return ResponseEntity.status(HttpStatus.CREATED).body(inscripcionService.registrarInscripcion(bean));
    }

    //LISTAR TODAS LAS INSCRIPCIONES
    @GetMapping("/curso/{id}")
    public ResponseEntity<?> listar(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(inscripcionService.listarInscripcionesXIdCurso(id));
    }

    //ELIINAR INSCRIPCION X ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarXid(@PathVariable Long id){
        inscripcionService.eliminarInscripcionXId(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
