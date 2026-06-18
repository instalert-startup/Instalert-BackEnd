package com.instalert_backend.profiles.domain.model.commands;

public record CreateUserCommand(
        String name,
        String email,
        String password,
        String role,
        String currentLocation,
        String avatar,
        String phone,
        String birthDate,
        String gender
) {}