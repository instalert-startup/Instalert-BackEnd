package com.instalert_backend.communities.infrastructure.persistence.jpa.assemblers;

import com.instalert_backend.communities.domain.model.aggregates.Community;
import com.instalert_backend.communities.infrastructure.persistence.jpa.entities.CommunityPersistenceEntity;

public final class CommunityPersistenceAssembler {
    private CommunityPersistenceAssembler() {}

    // De Base de Datos a Dominio
    public static Community toDomainFromPersistence(CommunityPersistenceEntity entity) {
        return new Community(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.isPrivate()
        );
    }

    // De Dominio a Base de Datos
    public static CommunityPersistenceEntity toPersistenceFromDomain(Community community) {
        var entity = new CommunityPersistenceEntity();
        entity.setId(community.getId());
        entity.setName(community.getName());
        entity.setDescription(community.getDescription());
        entity.setPrivate(community.isPrivate());
        return entity;
    }
}