package dev.marcus.studentsCoursesApi.domain.entities.Curso;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import dev.marcus.studentsCoursesApi.domain.entities.Curso.DTOs.CursoDTO;
import dev.marcus.studentsCoursesApi.domain.entities.aluno.Aluno;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "cursos")
@Table(name = "cursos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "nome", nullable = false)
    private String nome;

    @JsonIgnore
    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<Aluno> alunos = new ArrayList<>();

    public Curso(CursoDTO cursoData){
        setNome(cursoData.nome());
    }
}
