package com.luis.springboot.EduConnect.DTOs;

import jakarta.validation.constraints.NotBlank;

//Recibiremos el código, titulo y descripción para crear el curso
public record CursoRequestDTO(
        @NotBlank
        String codigo,
        @NotBlank
        String titulo,
        String descripcion
) {
}
