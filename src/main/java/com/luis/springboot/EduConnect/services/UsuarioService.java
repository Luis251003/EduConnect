package com.luis.springboot.EduConnect.services;

import com.luis.springboot.EduConnect.DTOs.AdminRequestDTO;
import com.luis.springboot.EduConnect.DTOs.AdminResponseDTO;
import com.luis.springboot.EduConnect.DTOs.EstudianteRequestDTO;
import com.luis.springboot.EduConnect.DTOs.EstudianteResponseDTO;

import java.util.List;

public interface UsuarioService {

    //LISTAR ESTUDIANTES
    List<EstudianteResponseDTO> listarEstudiantes();

    //GUARDAR UN ESTUDIANTE
    EstudianteResponseDTO registrarEstudiante(EstudianteRequestDTO bean);

    //GUARDAR UN ADMINISTRADOR
    AdminResponseDTO registrarAdmin(AdminRequestDTO bean);

    //ELIMINAR ESTUDIANTE X ID
    void eliminarEstudianteXId(Long id);

}
