package com.luis.springboot.EduConnect.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record EstudianteRequestDTO (

        @NotBlank
        String nombre,
        @Email
        String correo,
        @Size(min = 8)
        String password
){
}
