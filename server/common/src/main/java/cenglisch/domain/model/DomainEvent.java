package cenglisch.domain.model;

public interface DomainEvent {
    default String topic() {
        return "company.management";
    }
}
