package cenglisch.hiring.domain;

import java.util.function.Consumer;

public interface EventHandler {
    void publish(DomainEvent domainEvent);

    <T extends DomainEvent> void subscribe(final Class<T> eventClass, final Consumer<T> domainEventConsumer);
}
