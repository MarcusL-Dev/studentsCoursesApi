package dev.marcus.studentsCoursesApi.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.marcus.studentsCoursesApi.domain.entities.diretor.Diretor;
import dev.marcus.studentsCoursesApi.domain.entities.diretor.DTOs.DiretorDTO;
import dev.marcus.studentsCoursesApi.repositories.DiretorRepository;
import dev.marcus.studentsCoursesApi.services.interfaces.DiretorService;

@Service
public class DiretorServiceImpl implements DiretorService{

    @Autowired
    DiretorRepository diretorRepository;

    @Override
    public Diretor createDiretor(DiretorDTO diretorData) {
        var newDiretor = new Diretor(diretorData);
        diretorRepository.save(newDiretor);
        return newDiretor;
    }

    @Override
    public List<Diretor> getAllDiretores() {
        return diretorRepository.findAll();
    }


}
