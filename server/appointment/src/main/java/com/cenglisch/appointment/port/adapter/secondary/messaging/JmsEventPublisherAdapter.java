package com.cenglisch.appointment.port.adapter.secondary.messaging;

import com.cenglisch.appointment.domain.DomainEvent;
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