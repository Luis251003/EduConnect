package com.luis.springboot.EduConnect.services;

import com.luis.springboot.EduConnect.DTOs.CursoRequestDTO;
import com.luis.springboot.EduConnect.DTOs.CursoResponseDTO;
import com.luis.springboot.EduConnect.models.Curso;
import com.luis.springboot.EduConnect.repositories.CursoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CursoServiceImp implements CursoService{

    //DECLARAMOS LA VARIABLE REPOSITORY
    private final CursoRepository cursoRepository;

    //DEFINIMOS LA VARIABLE REPOSITORY
    public CursoServiceImp(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    //CONVERTIR REQUEST A ENTITY
    private Curso mapToEntity(CursoRequestDTO bean){
        return new Curso(bean.codigo(),bean.titulo(),bean.descripcion());
    }

    //CONVERTIR ENTITY A RESPONSE
    private CursoResponseDTO mapToDTO(Curso bean){
        return new CursoResponseDTO(bean.getId(),bean.getCodigo(),bean.getTitulo(),bean.getDescripcion());
    }

    //LISTAR TODOS LOS CURSOS
    @Override
    @Transactional(readOnly = true)
    public List<CursoResponseDTO> listarCursos() {
        return cursoRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    //GUARDAR UN NUEVO CURSO
    @Override
    @Transactional
    public CursoResponseDTO guardarCurso(CursoRequestDTO bean) {
        return mapToDTO(cursoRepository.save(mapToEntity(bean)));

    }
}
