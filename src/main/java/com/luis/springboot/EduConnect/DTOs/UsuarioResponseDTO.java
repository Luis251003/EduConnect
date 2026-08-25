package com.luis.springboot.EduConnect.DTOs;

//Devolveremos el nombre y correo del administador
public record UsuarioResponseDTO(
        Long id,
        String nombre,
        String correo
){
}
