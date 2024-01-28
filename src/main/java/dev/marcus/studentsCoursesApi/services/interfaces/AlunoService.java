package dev.marcus.studentsCoursesApi.services.interfaces;

import java.util.List;

import dev.marcus.studentsCoursesApi.domain.entities.aluno.Aluno;
import dev.marcus.studentsCoursesApi.domain.entities.aluno.DTOs.AlunoDTO;

public interface AlunoService {
    Aluno createAluno(AlunoDTO alunoData);
    List<Aluno> getAllAluno();
}
