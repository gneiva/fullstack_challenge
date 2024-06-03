package io.github.gneiva.fullstack.challenge.api.infra.config;

import io.github.gneiva.fullstack.challenge.api.adapter.entities.User;
import io.github.gneiva.fullstack.challenge.api.adapter.respository.UserRepository;
import io.github.gneiva.fullstack.challenge.api.domain.services.ports.AuthenticationServicePort;
import io.github.gneiva.fullstack.challenge.api.infra.exceptions.UnauthorizedException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private AuthenticationServicePort autenticacaoService;

    @Autowired
    private UserRepository usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String token = extraiTokeHeader(request);

        if (token != null) {
            String login = autenticacaoService.validTokenJwt(token);
            User usuario = usuarioRepository.findByUsername(login);

            if (usuario == null) {
                throw  new UnauthorizedException("Unauthorizad");
            }

            var autentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(autentication);
        }

        filterChain.doFilter(request, response);
    }

    public String extraiTokeHeader(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");

        if (authHeader == null) {
            return null;
        }

        if (!authHeader.split(" ")[0].equals("Bearer")) {
            return authHeader;
        }

        return authHeader.split(" ")[1];
    }
}
