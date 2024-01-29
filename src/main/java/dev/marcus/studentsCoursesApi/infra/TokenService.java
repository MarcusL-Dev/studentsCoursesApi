package dev.marcus.studentsCoursesApi.infra;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import dev.marcus.studentsCoursesApi.domain.entities.usuario.Usuario;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;
    
    public String genetateToken(Usuario user){
        try{

            Algorithm algorithm = Algorithm.HMAC256(secret);

            String token = JWT.create()
                .withIssuer("studentscoursesapi")
                .withSubject(user.getEmail())
                .withExpiresAt(getExpirationDate())
                .sign(algorithm);

            return token;

        }catch (JWTCreationException ex){
            throw new RuntimeException("error while generating token", ex);
        }
    }

    public String validateToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            return JWT.require(algorithm)
                .withIssuer("studentscoursesapi")
                .build()
                .verify(token)
                .getSubject();
        } catch (JWTVerificationException ex) {
            return "";
        }
    }

    private Instant getExpirationDate(){
        return LocalDateTime.now().plusHours(12).toInstant(ZoneOffset.of("-03:00"));
    }
}
