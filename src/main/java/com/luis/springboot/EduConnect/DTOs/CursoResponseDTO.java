package com.luis.springboot.EduConnect.DTOs;

//Devolveremos el código, titulo y descripción del curso
public record CursoResponseDTO(
        String codigo,
        String titulo,
        String descripcion
) {
}
