package com.luis.springboot.EduConnect.services;

import com.luis.springboot.EduConnect.DTOs.UsuarioRequestDTO;
import com.luis.springboot.EduConnect.DTOs.UsuarioResponseDTO;

import java.util.List;

public interface UsuarioService {

    //LISTAR ESTUDIANTES
    List<UsuarioResponseDTO> listarEstudiantes();

    //GUARDAR UN ESTUDIANTE
    UsuarioResponseDTO registrarEstudiante(UsuarioRequestDTO bean);

    //GUARDAR UN ADMINISTRADOR
    UsuarioResponseDTO registrarAdmin(UsuarioRequestDTO bean);

    //ELIMINAR ESTUDIANTE X ID
    void eliminarEstudianteXId(Long id);

}
