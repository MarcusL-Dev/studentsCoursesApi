package dev.marcus.studentsCoursesApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.marcus.studentsCoursesApi.domain.entities.Curso.Curso;
import dev.marcus.studentsCoursesApi.domain.entities.Curso.DTOs.CursoDTO;
import dev.marcus.studentsCoursesApi.services.interfaces.CursoService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    CursoService cursoService;

    @GetMapping()
    public ResponseEntity<List<Curso>> getAllCursos() {
        return ResponseEntity.ok().body(cursoService.getAllCursos());
    }

    @PostMapping()
    public ResponseEntity<Curso> createCurso(@RequestBody @Valid CursoDTO cursoData) {
        return ResponseEntity.ok().body(cursoService.createCurso(cursoData));
    }
}
