package com.luis.springboot.EduConnect.controllers;

import com.luis.springboot.EduConnect.DTOs.UsuarioRequestDTO;
import com.luis.springboot.EduConnect.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

    //DECLARAMOS LA VARIABLE SERVICIO
    private final UsuarioService usuarioService;

    //DEFINIMOS LA VARIABLE SERVICIO
    public AdminController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    //CREAMOS UN NUEVO ADMIN
    @PostMapping
    public ResponseEntity<?> registrar(@Valid @RequestBody UsuarioRequestDTO user){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.registrarAdmin(user));
    }
}
