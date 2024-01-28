package dev.marcus.studentsCoursesApi.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.marcus.studentsCoursesApi.domain.entities.Curso.Curso;
import dev.marcus.studentsCoursesApi.domain.entities.Curso.DTOs.CursoDTO;
import dev.marcus.studentsCoursesApi.repositories.CursoRepository;
import dev.marcus.studentsCoursesApi.services.interfaces.CursoService;

@Service
public class CursoServiceImpl implements CursoService{
    
    @Autowired
    CursoRepository cursoRepository;

    @Override
    public Curso createCurso(CursoDTO cursoData) {
        var newCurso = new Curso(cursoData);
        cursoRepository.save(newCurso);
        return newCurso;
    }

    @Override
    public List<Curso> getAllCursos() {
        return cursoRepository.findAll();
    }

    @Override
    public Curso getCursoById(UUID cursoId) {
        return cursoRepository.findById(cursoId).get();
    }

}
