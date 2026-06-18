package com.instalert_backend.profiles.interfaces.rest.resources;

public record ChangePasswordResource(String currentPassword, String newPassword) {}