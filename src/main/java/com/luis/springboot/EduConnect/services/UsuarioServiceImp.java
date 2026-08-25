package com.luis.springboot.EduConnect.services;

import com.luis.springboot.EduConnect.DTOs.UsuarioRequestDTO;
import com.luis.springboot.EduConnect.DTOs.UsuarioResponseDTO;
import com.luis.springboot.EduConnect.exceptions.ResourceAlreadyExistsException;
import com.luis.springboot.EduConnect.exceptions.ResourceNotFoundException;
import com.luis.springboot.EduConnect.models.Rol;
import com.luis.springboot.EduConnect.models.Usuario;
import com.luis.springboot.EduConnect.repositories.RolRepository;
import com.luis.springboot.EduConnect.repositories.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private final RolRepository rolRepository;
    private final PasswordEncoder passwordEncoder;

    //DEFINIMOS LAS VARIABLE REPOSITORY
    public UsuarioServiceImp(UsuarioRepository usuarioRepository, RolRepository rolRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
        this.passwordEncoder = passwordEncoder;
    }

    //CONVERTIMOS REQUEST A ENTITY
    private Usuario mapToEntity(UsuarioRequestDTO bean){
        return new Usuario(bean.nombre(),bean.correo(),passwordEncoder.encode(bean.password()));
    }

    //CONVERTIMOS ENTITY A RESPONSE
    private UsuarioResponseDTO mapToResponse(Usuario bean){
        return new UsuarioResponseDTO(bean.getId(),bean.getNombre(),bean.getEmail());
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

        //VALIDAMOS SI EL CORREO YA EXISTE
        if (usuarioRepository.existsByEmail(bean.correo())){
            throw new ResourceAlreadyExistsException("El email ya existe");
        }

        //OBTENEMOS EL ROL ESTUDIANTE
        Rol rol = rolRepository.findByNombre("ESTUDIANTE").orElseThrow(()->new ResourceNotFoundException("Rol estudiante no encontrado"));
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
        //OBTENEMOS EL ROL ADMIN
        Rol rol = rolRepository.findByNombre("ADMIN").orElseThrow(()->new ResourceNotFoundException("Rol admin no encontrado"));
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
