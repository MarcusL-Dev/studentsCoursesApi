package dev.marcus.studentsCoursesApi.controllers;

import org.apache.catalina.authenticator.SpnegoAuthenticator.AuthenticateAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.marcus.studentsCoursesApi.domain.entities.usuario.LoginFormDTO;
import dev.marcus.studentsCoursesApi.domain.entities.usuario.LoginResponseDTO;
import dev.marcus.studentsCoursesApi.domain.entities.usuario.Usuario;
import dev.marcus.studentsCoursesApi.infra.TokenService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;
    
    @PostMapping
    public ResponseEntity login(@RequestBody @Valid LoginFormDTO loginData){
        var userToken = new UsernamePasswordAuthenticationToken(loginData.email(), loginData.senha());
        var auth = this.authenticationManager.authenticate(userToken);

        var token = tokenService.genetateToken( (Usuario) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

}
