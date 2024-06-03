package io.github.gneiva.fullstack.challenge.api.domain.services.ports;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;

import io.github.gneiva.fullstack.challenge.api.dtos.TokenResponseDto;

public interface AuthenticationServicePort extends UserDetailsService {
	
    public TokenResponseDto getToken(Authentication authentication);
    public String validTokenJwt(String token);
    TokenResponseDto getRefreshToken(String s);

}
