package com.luis.springboot.EduConnect.DTOs;

import com.luis.springboot.EduConnect.models.Curso;
import com.luis.springboot.EduConnect.models.Usuario;
import jakarta.validation.constraints.NotNull;

public record InscripcionRequestDTO (
        @NotNull
        Usuario usuario,
        @NotNull
        Curso curso
){
}
