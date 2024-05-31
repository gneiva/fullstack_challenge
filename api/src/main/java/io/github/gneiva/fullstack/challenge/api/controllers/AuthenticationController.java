package io.github.gneiva.fullstack.challenge.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.gneiva.fullstack.challenge.api.dtos.RequestRefreshDto;
import io.github.gneiva.fullstack.challenge.api.dtos.TokenDTO;
import io.github.gneiva.fullstack.challenge.api.dtos.TokenResponseDto;
import io.github.gneiva.fullstack.challenge.api.form.LoginForm;
import io.github.gneiva.fullstack.challenge.api.services.AuthenticationService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthenticationService autenticacaoService;

    @PostMapping
    public ResponseEntity<Object> auth(@RequestBody @Valid LoginForm form) {

    	UsernamePasswordAuthenticationToken usuarioAutenticationToken = form.converter();
    	
    	try {
			Authentication authentication = authenticationManager.authenticate(usuarioAutenticationToken);
			return ResponseEntity.ok(autenticacaoService.getToken(authentication));
		} catch (AuthenticationException e) {
			return ResponseEntity.badRequest().build();
		}
    	
    }
    

    @PostMapping("/refresh-token")
    @ResponseStatus(HttpStatus.OK)
    public TokenResponseDto authRefreshToken(@RequestBody RequestRefreshDto requestRefreshDto) {
        return autenticacaoService.getRefreshToken(requestRefreshDto.refreshToken());
    }
}
