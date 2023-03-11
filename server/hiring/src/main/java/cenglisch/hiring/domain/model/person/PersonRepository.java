package cenglisch.hiring.domain.model.person;

import cenglisch.domain.model.Repository;

public interface PersonRepository extends Repository<Person, PersonId> {
    boolean existsByEmail(String email);
}
