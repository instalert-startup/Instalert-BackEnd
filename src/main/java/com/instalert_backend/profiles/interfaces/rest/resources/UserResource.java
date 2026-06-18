package com.instalert_backend.profiles.interfaces.rest.resources;

public record UserResource(
        Long id,
        String name,
        String email,
        String password,
        String role,
        String currentLocation,
        String avatar,
        String phone
) {}