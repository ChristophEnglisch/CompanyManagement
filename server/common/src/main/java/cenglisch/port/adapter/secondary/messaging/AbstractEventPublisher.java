package cenglisch.port.adapter.secondary.messaging;

import cenglisch.domain.model.DomainEvent;
import cenglisch.domain.model.EventHandler;

import java.util.*;
import java.util.function.Consumer;

public abstract class AbstractEventPublisher implements EventHandler {

    protected final Map<Class<? extends DomainEvent>, List<Consumer<DomainEvent>>> subscriber = new HashMap<>();

    public final void publish(final DomainEvent domainEvent) {
        publishToConsumers(domainEvent);
        publishExternally(domainEvent);
    }

    public void publishToConsumers(final DomainEvent domainEvent) {
        Optional.ofNullable(subscriber.get(domainEvent.getClass()))
                .ifPresent(allConsumer -> allConsumer.forEach(consumer -> consumer.accept(domainEvent)));
    }

    protected abstract void publishExternally(final DomainEvent domainEvent);

    public final <T extends DomainEvent> void subscribe(final Class<T> eventClass, final Consumer<T> domainEventConsumer) {
        subscriber.putIfAbsent(eventClass, new ArrayList<>());
        subscriber.get(eventClass).add((Consumer<DomainEvent>) domainEventConsumer);
    }

    public Map<Class<? extends DomainEvent>, List<Consumer<DomainEvent>>> getSubscriber() {
        return Collections.unmodifiableMap(subscriber);
    }
}
