package com.luis.springboot.EduConnect.repositories;

import com.luis.springboot.EduConnect.models.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolRepository extends JpaRepository<Rol,Long> {

    Optional<Rol> findByNombre(String nombre);
}
