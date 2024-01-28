package dev.marcus.studentsCoursesApi.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.marcus.studentsCoursesApi.domain.entities.aluno.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, UUID>{
    
}
