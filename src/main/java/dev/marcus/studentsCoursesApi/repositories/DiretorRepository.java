package dev.marcus.studentsCoursesApi.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.marcus.studentsCoursesApi.domain.entities.diretor.Diretor;

public interface DiretorRepository extends JpaRepository<Diretor, UUID> {
    
}
