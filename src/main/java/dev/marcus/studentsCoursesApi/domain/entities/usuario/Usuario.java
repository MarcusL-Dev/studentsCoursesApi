package dev.marcus.studentsCoursesApi.domain.entities.usuario;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "pessoa")
@Table(name = "pessoa")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements UserDetails{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "sobrenome", nullable = false)
    private String sobrenome;
    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "senha", nullable = false)
    @JsonIgnore
    private String senha;

    private UserRole userRole;

    public Usuario(String nome, String sobrenome, String cpf, String email, String senha) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.userRole == UserRole.DIRETOR) return List.of(
            new SimpleGrantedAuthority("ROLE_DIRETOR"),
            new SimpleGrantedAuthority("ROLE_ALUNO")
        );
        else return List.of(new SimpleGrantedAuthority("ROLE_ALUNO"));
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
