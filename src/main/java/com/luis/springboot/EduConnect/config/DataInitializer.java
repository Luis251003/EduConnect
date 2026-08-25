package com.luis.springboot.EduConnect.config;

import com.luis.springboot.EduConnect.DTOs.UsuarioRequestDTO;
import com.luis.springboot.EduConnect.models.Rol;
import com.luis.springboot.EduConnect.repositories.RolRepository;
import com.luis.springboot.EduConnect.services.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.NonNull;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Configuration
public class DataInitializer implements CommandLineRunner{

    private final RolRepository rolRepository;
    private final UsuarioService usuarioService;

    public DataInitializer(RolRepository rolRepository, UsuarioService usuarioService) {
        this.rolRepository = rolRepository;
        this.usuarioService = usuarioService;
    }

    @Transactional
    private void crearRolSiNoExiste(RolRepository rolRepository,String nombre){
        if(rolRepository.findByNombre(nombre).isEmpty()){
            Rol rol = new Rol();
            rol.setNombre(nombre);
            rolRepository.save(rol);
            log.info("Rol '"+rol.getNombre()+"' creado exitosamente.");
        }
    }

    @Transactional
    private void crearAdministrador(){
        UsuarioRequestDTO user = new UsuarioRequestDTO("Pedro Castillo","pedro.castillo@gmail.com","palabraDeMaestro");
        usuarioService.registrarAdmin(user);
    }

    @Override
    public void run(String @NonNull ... args) throws Exception {
        crearRolSiNoExiste(rolRepository,"ADMIN");
        crearRolSiNoExiste(rolRepository,"ESTUDIANTE");
        crearAdministrador();
    }
}
