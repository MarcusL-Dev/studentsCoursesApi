package dev.marcus.studentsCoursesApi.services.interfaces;

import java.util.List;
import java.util.UUID;

import dev.marcus.studentsCoursesApi.domain.entities.Curso.Curso;
import dev.marcus.studentsCoursesApi.domain.entities.Curso.DTOs.CursoDTO;

public interface CursoService {
    Curso createCurso(CursoDTO cursoData);
    List<Curso> getAllCursos();
    Curso getCursoById(UUID cursoId);
}
