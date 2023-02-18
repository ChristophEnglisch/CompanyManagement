package cenglisch.hiring.domain.person;

import cenglisch.hiring.domain.Repository;

public interface PersonRepository extends Repository<Person, PersonId> {
    boolean existsByEmail(String email);
}
