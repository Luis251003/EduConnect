package com.luis.springboot.EduConnect.services;

import com.luis.springboot.EduConnect.DTOs.UsuarioRequestDTO;
import com.luis.springboot.EduConnect.DTOs.UsuarioResponseDTO;
import com.luis.springboot.EduConnect.exceptions.ResourceNotFoundException;
import com.luis.springboot.EduConnect.models.Rol;
import com.luis.springboot.EduConnect.models.Usuario;
import com.luis.springboot.EduConnect.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImp implements UsuarioService{

    //DECLARAMOS LA VARIABLE REPOSITORY
    private final UsuarioRepository usuarioRepository;

    //DEFINIMOS LAS VARIABLE REPOSITORY
    public UsuarioServiceImp(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    //CONVERTIMOS REQUEST A ENTITY
    private Usuario mapToEntity(UsuarioRequestDTO bean){
        return new Usuario(bean.nombre(),bean.correo(),bean.password());
    }

    //CONVERTIMOS ENTITY A RESPONSE
    private UsuarioResponseDTO mapToResponse(Usuario bean){
        return new UsuarioResponseDTO(bean.getNombre(),bean.getEmail());
    }

    //LISTAMOS A TODOS LOS ESTUDIANTES
    @Override
    @Transactional(readOnly = true)
    public List<UsuarioResponseDTO> listarEstudiantes() {
        return usuarioRepository.findAll().stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    //REGISTRAR NUEVO ESTUDIANTE
    @Override
    @Transactional
    public UsuarioResponseDTO registrarEstudiante(UsuarioRequestDTO bean) {

        //DEFINIMOS LOS ROLES PARA EL ESTUDIANTE
        Rol rol = new Rol("ROLE_ESTUDIANTE");
        //DEFINIMOS EL ARREGLO ROLES
        Set<Rol> roles = new HashSet<>();
        roles.add(rol);
        //OBTENEMOS EL ESTUDIANTE
        Usuario estudiante = mapToEntity(bean);
        estudiante.setRoles(roles);

        return mapToResponse(usuarioRepository.save(estudiante));
    }

    //REGISTRAR NUEVO ADMINISTRADOR
    @Override
    @Transactional
    public UsuarioResponseDTO registrarAdmin(UsuarioRequestDTO bean) {
        //DEFINIMOS LOS ROLES PARA EL ADMIN
        Rol rol = new Rol("ROLE_ADMIN");
        //DEFINIMOS EL ARREGLO ROLES
        Set<Rol> roles = new HashSet<>();
        roles.add(rol);
        //OBTENEMOS EL ADMIN
        Usuario admin = mapToEntity(bean);
        admin.setRoles(roles);

        return mapToResponse(usuarioRepository.save(admin));
    }

    //ELIMINAR ESTUDIANTE POR ID
    @Override
    @Transactional
    public void eliminarEstudianteXId(Long id) {
        Usuario user = usuarioRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Usuario no encontrado"));
        usuarioRepository.delete(user);
    }
}
