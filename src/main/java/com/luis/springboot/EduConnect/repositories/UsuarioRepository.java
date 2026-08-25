package com.luis.springboot.EduConnect.repositories;

import com.luis.springboot.EduConnect.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    Optional<Usuario> findByEmail(String email);

    boolean existsByEmail(String email);

}
