package com.luis.springboot.EduConnect.repositories;

import com.luis.springboot.EduConnect.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
