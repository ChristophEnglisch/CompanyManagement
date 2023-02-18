package cenglisch.hiring.domain.person.event;

import cenglisch.hiring.domain.DomainEvent;
import cenglisch.hiring.domain.person.PersonId;

public record PersonalInformationDeposited(PersonId personId) implements PersonEvent {
    public String topic() {
        return PersonEvent.super.topic() + ".information.deposited";
    }
}