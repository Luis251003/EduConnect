package com.luis.springboot.EduConnect.controllers;

import com.luis.springboot.EduConnect.DTOs.UsuarioRequestDTO;
import com.luis.springboot.EduConnect.DTOs.UsuarioResponseDTO;
import com.luis.springboot.EduConnect.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    //DECLARAMOS LA VARIABLE SERVICIO
    private final UsuarioService usuarioService;

    //DEFINIMOS LA VARIABLE SERVICIO
    public EstudianteController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    //REGISTRAR UN NUEVO ESTUDIANTE
    @PostMapping
    public ResponseEntity<?> registrar(@Valid @RequestBody UsuarioRequestDTO estudiante){
        UsuarioResponseDTO user = usuarioService.registrarEstudiante(estudiante);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    //OBTENER LISTA DE ESTUDIANTES
    @GetMapping
    public ResponseEntity<?> listar(){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.listarEstudiantes());
    }

    //ELIMINAR ESTUDIANTE X ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        usuarioService.eliminarEstudianteXId(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
