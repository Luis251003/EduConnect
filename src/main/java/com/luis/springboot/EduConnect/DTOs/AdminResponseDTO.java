package com.luis.springboot.EduConnect.DTOs;

//Devolveremos el nombre y correo del administador
public record AdminResponseDTO (
        String nombre,
        String correo
){
}
