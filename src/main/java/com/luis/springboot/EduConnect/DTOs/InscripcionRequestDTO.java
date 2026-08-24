package com.luis.springboot.EduConnect.DTOs;

import jakarta.validation.constraints.NotNull;

//Recibiremos el id del usuario y el id del curso para crear una inscripción
public record InscripcionRequestDTO (
        @NotNull
        Long idUsuario,
        @NotNull
        Long idCurso
){
}
