package cenglisch.company.managment.domain;

import java.util.Optional;

public interface Repository<Entity, Identity> {

    Optional<Entity> findById(Identity identity);

    Entity save(Entity entity);

    void remove(Entity company);
}
