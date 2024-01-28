package dev.marcus.studentsCoursesApi.domain.entities.diretor.DTOs;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DiretorDTO(

    @NotBlank
    String nome,
    @NotBlank
    String sobrenome,
    @NotBlank
    @CPF
    String cpf,
    @NotBlank
    @Email
    String email,
    @NotBlank
    String senha,
    @NotNull

    @NotNull
    Integer salario

) {
    
}
