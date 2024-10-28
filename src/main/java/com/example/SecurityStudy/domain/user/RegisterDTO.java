package com.example.SecurityStudy.domain.user;

public record RegisterDTO(String login, String password, UserRole role) {
}
