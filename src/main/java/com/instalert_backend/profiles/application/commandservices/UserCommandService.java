package com.instalert_backend.profiles.application.commandservices;

import com.instalert_backend.profiles.domain.model.aggregates.User;
import com.instalert_backend.profiles.domain.model.commands.CreateUserCommand;
import com.instalert_backend.profiles.domain.model.commands.DeleteUserCommand;

import java.util.Optional;

public interface UserCommandService {
    Optional<User> handle(CreateUserCommand command);
    void handle(DeleteUserCommand command);
}