package cenglisch.hiring.domain.person;

import cenglisch.domain.model.Repository;

public interface PersonRepository extends Repository<Person, PersonId> {
    boolean existsByEmail(String email);
}
