package dev.marcus.studentsCoursesApi.domain.entities.aluno.DTOs;

import java.util.UUID;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AlunoDTO(
    
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
    Integer ira,
    @NotNull
    Integer matricula,

    @NotNull
    UUID cursoId

) {
    
}
