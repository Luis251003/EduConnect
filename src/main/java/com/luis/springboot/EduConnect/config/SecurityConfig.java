package com.luis.springboot.EduConnect.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration){
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http){
        http
        .csrf(AbstractHttpConfigurer::disable)
        .authorizeHttpRequests(auth->auth
                .requestMatchers(HttpMethod.POST,"/api/estudiantes").permitAll()
                .requestMatchers(HttpMethod.GET,"/api/estudiantes").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE,"/api/estudiantes/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.POST,"/api/cursos").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET,"/api/cursos").hasAnyRole("ESTUDIANTE","ADMIN")
                .requestMatchers(HttpMethod.POST,"/api/inscripciones").hasAnyRole("ESTUDIANTE","ADMIN")
                .requestMatchers(HttpMethod.GET,"/api/inscripciones/curso/**").hasAnyRole("ESTUDIANTE","ADMIN")
                .requestMatchers(HttpMethod.DELETE,"/api/inscripciones/**").hasAnyRole("ADMIN")
        )
        .httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
