package io.github.gneiva.fullstack.challenge.api.services.impl;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import io.github.gneiva.fullstack.challenge.api.dtos.TokenResponseDto;
import io.github.gneiva.fullstack.challenge.api.infra.exceptions.UnauthorizedException;
import io.github.gneiva.fullstack.challenge.api.models.User;
import io.github.gneiva.fullstack.challenge.api.respository.UserRepository;
import io.github.gneiva.fullstack.challenge.api.services.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Value("${auth.jwt.token.secret}")
    private String secretKey;

    @Value("${auth.jwt.token.expiration}")
    private Integer expirationToken;

    @Value("${auth.jwt.refresh-token.expiration}")
    private Integer expirationRefreshToken ;

    @Autowired
    private UserRepository usuarioRepository;
    
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
    	return usuarioRepository.findByUsername(login);
    }

    @Override
    public TokenResponseDto getToken(Authentication authentication) {
    	
    	User userForm = (User) authentication.getPrincipal();
    	
        User user = usuarioRepository.findByUsername(userForm.getUsername());

        return new TokenResponseDto(generateTokenJwt(user,expirationToken),"Bearer", Long.valueOf(expirationToken));
    }

    public  String generateTokenJwt(User usuario, Integer expiration) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            
            return JWT.create()
                    .withIssuer("auth-api")
                    .withSubject(usuario.getUsername())
                    .withExpiresAt(geraDateExpiry(expiration))
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Error when trying to generate the token!" +exception.getMessage());
        }
    }

    public String validTokenJwt(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);

            return JWT.require(algorithm)
                    .withIssuer("auth-api")
                    .build()
                    .verify(token)
                    .getSubject();

        } catch (JWTVerificationException exception) {
            return "";
        }
    }

    @Override
    public TokenResponseDto getRefreshToken(String refreshToken) {

        String login = validTokenJwt(refreshToken);
        User user = usuarioRepository.findByUsername(login);

        if (user == null) {
            throw new UnauthorizedException("UnauthorizedException");
        }

        Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        return new TokenResponseDto(generateTokenJwt(user,expirationToken),"Bearer", Long.valueOf(expirationToken));
        
    }

    private Instant geraDateExpiry(Integer expiration) {
        return LocalDateTime.now()
                .plusSeconds(expiration)
                .toInstant(ZoneOffset.UTC);
    }
}
