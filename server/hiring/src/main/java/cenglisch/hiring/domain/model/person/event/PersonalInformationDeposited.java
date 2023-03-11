package cenglisch.hiring.domain.model.person.event;

import cenglisch.hiring.domain.model.person.PersonId;

public record PersonalInformationDeposited(PersonId personId) implements PersonEventHiring {
    public String topic() {
        return PersonEventHiring.super.topic() + ".information.deposited";
    }
}