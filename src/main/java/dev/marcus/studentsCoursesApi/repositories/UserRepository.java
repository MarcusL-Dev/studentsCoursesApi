package dev.marcus.studentsCoursesApi.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import dev.marcus.studentsCoursesApi.domain.entities.usuario.Usuario;

public interface UserRepository extends JpaRepository<Usuario, UUID>{

    UserDetails findByEmail(String Email);
    
}
