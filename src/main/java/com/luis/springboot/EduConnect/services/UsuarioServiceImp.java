package com.luis.springboot.EduConnect.services;

import com.luis.springboot.EduConnect.DTOs.AdminRequestDTO;
import com.luis.springboot.EduConnect.DTOs.AdminResponseDTO;
import com.luis.springboot.EduConnect.DTOs.EstudianteRequestDTO;
import com.luis.springboot.EduConnect.DTOs.EstudianteResponseDTO;
import com.luis.springboot.EduConnect.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImp implements UsuarioService{

    //DECLARAMOS LA VARIABLE REPOSITORY
    private final UsuarioRepository usuarioRepository;

    //DEFINIMOS LAS VARIABLE REPOSITORY
    public UsuarioServiceImp(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    //LISTAMOS A TODOS LOS ESTUDIANTES
    @Override
    public List<EstudianteResponseDTO> listarEstudiantes() {
        return List.of();
    }

    //REGISTRAR NUEVO ESTUDIANTE
    @Override
    public EstudianteResponseDTO registrarEstudiante(EstudianteRequestDTO bean) {
        return null;
    }

    //REGISTRAR NUEVO ADMINISTRADOR
    @Override
    public AdminResponseDTO registrarAdmin(AdminRequestDTO bean) {
        return null;
    }

    //ELIMINAR ESTUDIANTE POR ID
    @Override
    public void eliminarEstudianteXId(Long id) {

    }
}
