package com.instalert_backend.profiles.infrastructure.persistence.jpa.adapters;

import com.instalert_backend.profiles.domain.model.aggregates.User;
import com.instalert_backend.profiles.domain.repositories.UserRepository;
import com.instalert_backend.profiles.infrastructure.persistence.jpa.assemblers.UserPersistenceAssembler;
import com.instalert_backend.profiles.infrastructure.persistence.jpa.repositories.UserPersistenceRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("profilesUserRepository")
public class UserRepositoryImpl implements UserRepository {

    private final UserPersistenceRepository userPersistenceRepository;

    public UserRepositoryImpl(UserPersistenceRepository userPersistenceRepository) {
        this.userPersistenceRepository = userPersistenceRepository;
    }

    @Override
    public User save(User user) {
        var entity = UserPersistenceAssembler.toEntity(user);
        var saved = userPersistenceRepository.save(entity);
        return UserPersistenceAssembler.toDomain(saved);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userPersistenceRepository.findById(id)
                .map(UserPersistenceAssembler::toDomain);
    }

    @Override
    public List<User> findAll() {
        return userPersistenceRepository.findAll()
                .stream()
                .map(UserPersistenceAssembler::toDomain)
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        userPersistenceRepository.deleteById(id);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userPersistenceRepository.existsByEmail(email);
    }
}