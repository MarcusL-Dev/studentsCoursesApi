package dev.marcus.studentsCoursesApi.domain.entities.usuario;

public enum UserRole {
    
    DIRETOR("diretor"),
    ALUNO("aluno");

    private String role;

    UserRole(String role){
        this.role = role;
    }

    public String getRole(){
        return this.role;
    }

}
