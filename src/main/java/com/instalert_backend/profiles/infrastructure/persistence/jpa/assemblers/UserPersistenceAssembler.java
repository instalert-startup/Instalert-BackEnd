package com.instalert_backend.profiles.infrastructure.persistence.jpa.assemblers;

import com.instalert_backend.profiles.domain.model.aggregates.User;
import com.instalert_backend.profiles.infrastructure.persistence.jpa.entities.UserPersistenceEntity;

public class UserPersistenceAssembler {

    public static UserPersistenceEntity toEntity(User user) {
        UserPersistenceEntity entity = new UserPersistenceEntity();
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPassword(user.getPassword());
        entity.setRole(user.getRole());
        entity.setCurrentLocation(user.getCurrentLocation());
        entity.setAvatar(user.getAvatar());
        entity.setPhone(user.getPhone());
        return entity;
    }

    public static User toDomain(UserPersistenceEntity entity) {
        User user = new User();
        user.setId(entity.getId());
        user.setName(entity.getName());
        user.setEmail(entity.getEmail());
        user.setPassword(entity.getPassword());
        user.setRole(entity.getRole());
        user.setCurrentLocation(entity.getCurrentLocation());
        user.setAvatar(entity.getAvatar());
        user.setPhone(entity.getPhone());
        return user;
    }
}