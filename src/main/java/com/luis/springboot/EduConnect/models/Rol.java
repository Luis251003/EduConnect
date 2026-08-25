package com.luis.springboot.EduConnect.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_roles")
@Getter
@Setter
@NoArgsConstructor
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Long id;
    @Column(nullable = false, unique = true)
    private String nombre;

    public Rol(String nombre){
        this.nombre = nombre;
    }

}
