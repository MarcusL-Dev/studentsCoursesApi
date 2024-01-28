package dev.marcus.studentsCoursesApi.domain.entities.aluno;

import dev.marcus.studentsCoursesApi.domain.entities.Curso.Curso;
import dev.marcus.studentsCoursesApi.domain.entities.aluno.DTOs.AlunoDTO;
import dev.marcus.studentsCoursesApi.domain.entities.pessoa.Pessoa;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "aluno")
@Table(name = "aluno")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Aluno extends Pessoa{

    @Column(name = "ira", nullable = false)
    private Integer ira;
    @Column(name = "matricula", nullable = false)
    private Integer matricula;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;

    public Aluno(AlunoDTO alunoData, Curso curso) {
        super(
            alunoData.nome(),
            alunoData.sobrenome(),
            alunoData.cpf(),
            alunoData.email(),
            alunoData.senha()
        );
        
        setIra(alunoData.ira());
        setMatricula(alunoData.matricula());
        setCurso(curso);
    }
    
}
