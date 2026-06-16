package com.instalert_backend.profiles.domain.model.aggregates;

import com.instalert_backend.profiles.domain.model.commands.CreateUserCommand;
import com.instalert_backend.shared.domain.model.aggregates.AbstractDomainAggregateRoot;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User extends AbstractDomainAggregateRoot<User> {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String role;
    private String currentLocation;
    private String avatar;
    private String phone;

    public User() {}

    public User(CreateUserCommand command) {
        this.name = command.name();
        this.email = command.email();
        this.password = command.password();
        this.role = command.role();
        this.currentLocation = command.currentLocation();
        this.avatar = command.avatar();
        this.phone = command.phone();
    }
}