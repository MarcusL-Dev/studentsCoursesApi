package dev.marcus.studentsCoursesApi.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.marcus.studentsCoursesApi.domain.entities.Curso.Curso;

public interface CursoRepository extends JpaRepository<Curso, UUID> {
    
}
