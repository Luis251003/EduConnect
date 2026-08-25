package com.luis.springboot.EduConnect.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

//Recibiremos el nombre, correo y contraseña para crear un administrador
public record UsuarioRequestDTO(
        @NotBlank
        String nombre,
        @Email
        String correo,
        @Size(min = 8)
        String password
) {
}
