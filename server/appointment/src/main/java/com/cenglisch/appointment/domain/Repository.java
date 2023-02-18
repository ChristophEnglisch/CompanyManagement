package com.cenglisch.appointment.domain;

import java.util.Optional;
import java.util.UUID;

public interface Repository<Entity, Identity> {

    Optional<Entity> findById(Identity identity);

    Entity save(Entity entity);

    default String generateId() {
        return UUID.randomUUID().toString().toUpperCase();
    }
}
