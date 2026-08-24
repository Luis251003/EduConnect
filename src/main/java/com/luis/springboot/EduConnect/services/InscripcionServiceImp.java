package com.luis.springboot.EduConnect.services;

import com.luis.springboot.EduConnect.DTOs.InscripcionRequestDTO;
import com.luis.springboot.EduConnect.DTOs.InscripcionResponseDTO;
import com.luis.springboot.EduConnect.repositories.CursoRepository;
import com.luis.springboot.EduConnect.repositories.InscripcionRepository;
import com.luis.springboot.EduConnect.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscripcionServiceImp implements InscripcionService{

    //DECLARAMOS LAS VARIABLES REPOSITORIES
    private final InscripcionRepository inscripcionRepository;
    private final CursoRepository cursoRepository;
    private final UsuarioRepository usuarioRepository;

    //DEFINIMOS LAS VARIABLES REPOSITORIES
    public InscripcionServiceImp(InscripcionRepository inscripcionRepository, CursoRepository cursoRepository, UsuarioRepository usuarioRepository) {
        this.inscripcionRepository = inscripcionRepository;
        this.cursoRepository = cursoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    //LISTAMOS TODAS LAS INSCRIPCIONES POR ID CURSO
    @Override
    public List<InscripcionResponseDTO> listarInscripcionesXIdCurso(Long id) {
        return List.of();
    }

    //REGISTRAMOS UNA NUEVA INSCRIPCION
    @Override
    public InscripcionResponseDTO registrarInscripcion(InscripcionRequestDTO bean) {
        return null;
    }

    //ELIMINAMOS UNA INSCRIPCION POR ID
    @Override
    public void eliminarInscripcionXId(Long id) {

    }
}
