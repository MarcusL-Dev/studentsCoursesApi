package dev.marcus.studentsCoursesApi.domain.entities.diretor;

import dev.marcus.studentsCoursesApi.domain.entities.diretor.DTOs.DiretorDTO;
import dev.marcus.studentsCoursesApi.domain.entities.usuario.UserRole;
import dev.marcus.studentsCoursesApi.domain.entities.usuario.Usuario;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "diretores")
@Table(name = "diretores")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Diretor extends Usuario{

    @Column(name = "salario", nullable = false)
    Integer salario;

    public Diretor(DiretorDTO diretorData, String hashadSenha){
        super(
            diretorData.nome(),
            diretorData.sobrenome(),
            diretorData.cpf(),
            diretorData.email(),
            hashadSenha,
            UserRole.ADMIN 
        );
        setSalario(diretorData.salario());
    }

}
