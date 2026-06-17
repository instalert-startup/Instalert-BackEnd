package com.instalert_backend.communities.domain.model.aggregates;

import com.instalert_backend.communities.domain.model.commands.CreateCommunityCommand;
import com.instalert_backend.communities.domain.model.events.CommunityCreatedEvent;
import com.instalert_backend.shared.domain.model.aggregates.AbstractDomainAggregateRoot;
import lombok.Getter;

/**
 * Entidad principal (Aggregate) para las Comunidades de InstAlert.
 */
public class Community extends AbstractDomainAggregateRoot<Community> {
    @Getter
    private Long id;

    @Getter
    private String name;

    @Getter
    private String description;

    @Getter
    private boolean isPrivate;

    // 1. Constructor vacío (Obligatorio para Spring/JPA)
    public Community() {
    }

    // 2. Constructor para cuando se crea desde el Frontend (Comando)
    public Community(CreateCommunityCommand command) {
        this.name = command.name();
        this.description = command.description();
        this.isPrivate = command.isPrivate();
    }

    // 3. NUEVO: Constructor para cuando se reconstruye desde la Base de Datos (Assembler)
    public Community(Long id, String name, String description, boolean isPrivate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.isPrivate = isPrivate;
    }

    public void onCreated() {
        registerDomainEvent(new CommunityCreatedEvent(this.id, this.name, this.isPrivate));
    }
}