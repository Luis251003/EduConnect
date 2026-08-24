package com.luis.springboot.EduConnect.DTOs;

import java.time.LocalDate;

public record InscripcionResponseDTO (
        EstudianteResponseDTO estudiante,
        CursoResponseDTO curso,
        LocalDate fechaInscripcion
){
}
