package com.luis.springboot.EduConnect.DTOs;

import java.time.LocalDate;

//Devolveremos el estudiante, curso y fecha de inscripción
public record InscripcionResponseDTO (
        UsuarioResponseDTO estudiante,
        CursoResponseDTO curso,
        LocalDate fechaInscripcion,
        Boolean estado
){
}
