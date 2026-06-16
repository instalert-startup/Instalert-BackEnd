package com.instalert_backend.profiles.interfaces.rest.resources;

public record CreateUserResource(
        String name,
        String email,
        String password,
        String role,
        String currentLocation,
        String avatar,
        String phone
) {}