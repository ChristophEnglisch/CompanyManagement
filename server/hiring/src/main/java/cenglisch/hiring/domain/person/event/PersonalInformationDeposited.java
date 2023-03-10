package cenglisch.hiring.domain.person.event;

import cenglisch.hiring.domain.person.PersonId;

public record PersonalInformationDeposited(PersonId personId) implements PersonEventHiring {
    public String topic() {
        return PersonEventHiring.super.topic() + ".information.deposited";
    }
}