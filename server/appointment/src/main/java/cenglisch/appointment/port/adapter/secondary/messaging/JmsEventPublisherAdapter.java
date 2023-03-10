package cenglisch.appointment.port.adapter.secondary.messaging;

import cenglisch.appointment.domain.AppointmentDomainEvent;
import cenglisch.domain.model.DomainEvent;
import cenglisch.port.adapter.secondary.messaging.AbstractEventPublisher;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class JmsEventPublisherAdapter extends AbstractEventPublisher {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    protected void publishExternally(DomainEvent domainEvent) {
        Logger.getLogger(domainEvent.topic()).log(Level.INFO, String.valueOf(domainEvent.getClass()));
        rabbitTemplate.convertAndSend(domainEvent.topic(), domainEvent.toString());
    }
}