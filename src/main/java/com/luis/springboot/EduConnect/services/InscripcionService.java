package com.luis.springboot.EduConnect.services;

import com.luis.springboot.EduConnect.DTOs.InscripcionRequestDTO;
import com.luis.springboot.EduConnect.DTOs.InscripcionResponseDTO;

import java.util.List;

public interface InscripcionService {

    //VER INSCRIPCIONES POR CURSO
    List<InscripcionResponseDTO> listarInscripcionesXIdCurso(Long id);

    //GUARDAR INSCRIPCION
    InscripcionResponseDTO registrarInscripcion(InscripcionRequestDTO bean);

    //ELIMINAR INSCRIPCION
    void eliminarInscripcionXId(Long id);
}
