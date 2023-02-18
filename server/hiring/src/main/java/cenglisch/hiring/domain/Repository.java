package cenglisch.hiring.domain;

import java.util.Optional;
import java.util.UUID;

public interface Repository<Entity, Identifier> {
    Optional<Entity> find(Identifier id);
    Entity save(Entity entity);

    default String generateId() {
        return UUID.randomUUID().toString().toUpperCase();
    }
}

