package com.luis.springboot.EduConnect.services;

import com.luis.springboot.EduConnect.DTOs.*;
import com.luis.springboot.EduConnect.context.AppContextHolder;
import com.luis.springboot.EduConnect.exceptions.ResourceNotFoundException;
import com.luis.springboot.EduConnect.exceptions.UnauthorizedAccessException;
import com.luis.springboot.EduConnect.models.Curso;
import com.luis.springboot.EduConnect.models.Inscripcion;
import com.luis.springboot.EduConnect.models.Usuario;
import com.luis.springboot.EduConnect.repositories.CursoRepository;
import com.luis.springboot.EduConnect.repositories.InscripcionRepository;
import com.luis.springboot.EduConnect.repositories.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
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

    //CONVERTIR REQUEST A ENTITY
    private Inscripcion mapToEntity(InscripcionRequestDTO bean) {
        //OBTENER CURSO
        Curso curso = cursoRepository
                .findById(bean.idCurso())
                .orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado con ID: " + bean.idCurso()));

        //OBTENER ESTUDIANTE
        Usuario estudiante = usuarioRepository
                .findById(bean.idUsuario())
                .orElseThrow(() -> new ResourceNotFoundException("Estudiante no encontrado con ID: " + bean.idUsuario()));

        return new Inscripcion(estudiante,curso);
    }

    //CONVERTIR ENTITY A RESPONSE
    private InscripcionResponseDTO mapToDTO(Inscripcion bean){
        //OBTENER CURSO
        Curso curso = cursoRepository
                .findById(bean.getCurso().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado con ID: " + bean.getCurso().getId()));

        //OBTENER ESTUDIANTE
        Usuario estudiante = usuarioRepository
                .findById(bean.getUsuario().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Estudiante no encontrado con ID: " + bean.getUsuario().getId()));

        return new InscripcionResponseDTO(
                bean.getId(),
                new UsuarioResponseDTO(estudiante.getId(),estudiante.getNombre(),estudiante.getEmail()),
                new CursoResponseDTO(estudiante.getId(),curso.getCodigo(),curso.getTitulo(),curso.getDescripcion()),
                bean.getFechaInscripcion(),
                bean.getEstado());
    }

    //LISTAMOS TODAS LAS INSCRIPCIONES POR ID CURSO
    @Override
    @Transactional(readOnly = true)
    public List<InscripcionResponseDTO> listarInscripcionesXIdCurso(Long id) {

        String appName = AppContextHolder.getAppName();

        log.info("Aplicación cliente recibida desde el servicio: {}",appName);

        if(!"2026-02".equals(appName)){
            log.warn("Intento de acceso no autorizado con la app: {}",appName);
            throw new UnauthorizedAccessException("Aplicación no autorizada");
        }

        return inscripcionRepository
                .findByCursoIdWithDetails(id)
                .orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado con ID: " + id))
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    //REGISTRAMOS UNA NUEVA INSCRIPCION
    @Override
    @Transactional
    public InscripcionResponseDTO registrarInscripcion(InscripcionRequestDTO bean) {
        return mapToDTO(inscripcionRepository.save(mapToEntity(bean)));
    }

    //ELIMINAMOS UNA INSCRIPCION POR ID
    @Override
    @Transactional
    public void eliminarInscripcionXId(Long id) {
        Inscripcion bean = inscripcionRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Inscripción no encontrada con ID: " + id));
        inscripcionRepository.delete(bean);
    }
}
