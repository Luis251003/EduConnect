package com.luis.springboot.EduConnect.DTOs;

import jakarta.validation.constraints.NotBlank;

public record CursoRequestDTO(
        @NotBlank
        String codigo,
        @NotBlank
        String titulo,
        String descripcion
) {
}
