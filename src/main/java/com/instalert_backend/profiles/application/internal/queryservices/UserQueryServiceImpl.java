package com.instalert_backend.profiles.application.internal.queryservices;

import com.instalert_backend.profiles.application.queryservices.UserQueryService;
import com.instalert_backend.profiles.domain.model.aggregates.User;
import com.instalert_backend.profiles.domain.model.queries.GetAllUsersQuery;
import com.instalert_backend.profiles.domain.model.queries.GetUserByIdQuery;
import com.instalert_backend.profiles.domain.model.queries.LoginUserQuery;
import com.instalert_backend.profiles.domain.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserQueryServiceImpl implements UserQueryService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserQueryServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> handle(GetAllUsersQuery query) {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> handle(GetUserByIdQuery query) {
        return userRepository.findById(query.id());
    }

    @Override
    public Optional<User> handle(LoginUserQuery query) {
        var userOpt = userRepository.findAll().stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(query.email()))
                .findFirst();

        if (userOpt.isEmpty()) {
            return Optional.empty();
        }

        var user = userOpt.get();
        if (!passwordEncoder.matches(query.password(), user.getPassword())) {
            return Optional.empty();
        }

        return Optional.of(user);
    }
}