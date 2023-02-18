package cenglisch.hiring.domain;

public interface DomainEvent {
    default String topic() {
        return "hiring";
    }
}
