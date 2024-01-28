package dev.marcus.studentsCoursesApi.domain.entities.Curso.DTOs;

import jakarta.validation.constraints.NotBlank;

public record CursoDTO(

    @NotBlank
    String nome

) {
    
}
