package dev.marcus.studentsCoursesApi.services.interfaces;

import java.util.List;

import dev.marcus.studentsCoursesApi.domain.entities.diretor.Diretor;
import dev.marcus.studentsCoursesApi.domain.entities.diretor.DTOs.DiretorDTO;

public interface DiretorService {
    Diretor createDiretor(DiretorDTO diretorData);
    List<Diretor> getAllDiretores();
}
