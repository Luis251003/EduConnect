package com.luis.springboot.EduConnect.security;

import com.luis.springboot.EduConnect.exceptions.ResourceNotFoundException;
import com.luis.springboot.EduConnect.models.Usuario;
import com.luis.springboot.EduConnect.repositories.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public CustomUserDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("El usuario no ha sido encontrado"));

        Set<GrantedAuthority> authorities = usuario.getRoles().stream()
                .map(rol->new SimpleGrantedAuthority("ROLE_" + rol.getNombre()))
                .collect(Collectors.toSet());

        return new User(usuario.getEmail(), usuario.getPassword(), authorities);
    }
}
