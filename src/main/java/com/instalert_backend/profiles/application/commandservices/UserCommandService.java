package com.instalert_backend.profiles.application.commandservices;

import com.instalert_backend.profiles.domain.model.aggregates.User;
import com.instalert_backend.profiles.domain.model.commands.ChangePasswordCommand;
import com.instalert_backend.profiles.domain.model.commands.CreateUserCommand;
import com.instalert_backend.profiles.domain.model.commands.DeleteUserCommand;
import com.instalert_backend.profiles.domain.model.commands.UpdateUserCommand;

import java.util.Optional;

public interface UserCommandService {
    Optional<User> handle(CreateUserCommand command);
    Optional<User> handle(UpdateUserCommand command);
    Optional<User> handle(ChangePasswordCommand command);
    void handle(DeleteUserCommand command);
}