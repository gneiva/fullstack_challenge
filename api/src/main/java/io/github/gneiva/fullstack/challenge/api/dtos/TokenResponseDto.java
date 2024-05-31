package io.github.gneiva.fullstack.challenge.api.dtos;

public record TokenResponseDto(String token, String type, Long expiresIn) {
}
