package com.instalert_backend.profiles.domain.model.commands;

public record ChangePasswordCommand(Long id, String currentPassword, String newPassword) {}