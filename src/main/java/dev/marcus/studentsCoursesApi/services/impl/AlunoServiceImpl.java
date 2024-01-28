package dev.marcus.studentsCoursesApi.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.marcus.studentsCoursesApi.domain.entities.aluno.Aluno;
import dev.marcus.studentsCoursesApi.domain.entities.aluno.DTOs.AlunoDTO;
import dev.marcus.studentsCoursesApi.repositories.AlunoRepository;
import dev.marcus.studentsCoursesApi.services.interfaces.AlunoService;
import dev.marcus.studentsCoursesApi.services.interfaces.CursoService;

@Service
public class AlunoServiceImpl implements AlunoService{

    @Autowired
    AlunoRepository alunoRepository;
    @Autowired
    CursoService cursoService;

    @Override
    public Aluno createAluno(AlunoDTO alunoData) {
        var curso = cursoService.getCursoById(alunoData.cursoId());

        var newAluno = new Aluno(alunoData, curso);
        alunoRepository.save(newAluno);
        return newAluno;
    }

    @Override
    public List<Aluno> getAllAluno() {
        var alunos = alunoRepository.findAll();
        return alunos;
    }
    
}
