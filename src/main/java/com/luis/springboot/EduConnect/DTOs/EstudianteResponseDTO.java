package com.luis.springboot.EduConnect.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record EstudianteResponseDTO (
        String nombre,
        String correo
){
}
