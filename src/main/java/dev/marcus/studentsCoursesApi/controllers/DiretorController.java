package dev.marcus.studentsCoursesApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.marcus.studentsCoursesApi.domain.entities.diretor.Diretor;
import dev.marcus.studentsCoursesApi.domain.entities.diretor.DTOs.DiretorDTO;
import dev.marcus.studentsCoursesApi.services.interfaces.DiretorService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/diretores")
public class DiretorController {
    
    @Autowired
    DiretorService diretorService;

    @PostMapping()
    public ResponseEntity<Diretor> createDiretor(@RequestBody @Valid DiretorDTO diretorData) {        
        return ResponseEntity.ok().body(diretorService.createDiretor(diretorData));
    }

    @GetMapping()
    public ResponseEntity<List<Diretor>> getAllDiretores() {
        return ResponseEntity.ok().body(diretorService.getAllDiretores());
    }
}
