package dev.marcus.studentsCoursesApi.domain.entities.diretor;

import org.springframework.security.core.userdetails.UserDetails;

import dev.marcus.studentsCoursesApi.domain.entities.diretor.DTOs.DiretorDTO;
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
    

    public Diretor(DiretorDTO diretorData){
        super(
            diretorData.nome(),
            diretorData.sobrenome(),
            diretorData.cpf(),
            diretorData.email(),
            diretorData.senha()
        );
        setSalario(diretorData.salario());
    }

}
