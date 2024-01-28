package dev.marcus.studentsCoursesApi.controllers;

import org.springframework.web.bind.annotation.RestController;

import dev.marcus.studentsCoursesApi.domain.entities.aluno.Aluno;
import dev.marcus.studentsCoursesApi.domain.entities.aluno.DTOs.AlunoDTO;
import dev.marcus.studentsCoursesApi.services.interfaces.AlunoService;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    
    @Autowired
    AlunoService alunoService;

    @GetMapping()
    public ResponseEntity<List<Aluno>> getAllAlunos() {
        return ResponseEntity.ok().body(alunoService.getAllAluno());
    }

    @PostMapping()
    public ResponseEntity<Aluno> postMethodName(@RequestBody @Valid AlunoDTO alunoData) {        
        return ResponseEntity.ok().body(alunoService.createAluno(alunoData));
    }
    
    
}
