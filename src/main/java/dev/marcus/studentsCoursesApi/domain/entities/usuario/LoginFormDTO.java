package dev.marcus.studentsCoursesApi.domain.entities.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginFormDTO(

    @NotBlank
    @Email
    String email,
    @NotBlank
    String senha

){
    
}
