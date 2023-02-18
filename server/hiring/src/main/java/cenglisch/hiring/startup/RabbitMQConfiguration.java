package cenglisch.hiring.startup;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {
    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Queue acceptInterviewQueue() {
        return new Queue("appointment.interview.accepted", true);
    }

    @Bean
    public Queue launchInterviewQueue() {
        return new Queue("appointment.interview.launched", true);
    }

    @Bean
    public Queue generateInterviewQueue() {
        return new Queue("appointment.interview.generated", true);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("interview-exchange");
    }

    @Bean
    public Binding acceptInterviewBinding(Queue acceptInterviewQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(acceptInterviewQueue).to(directExchange).with("appointment.interview.accepted");
    }

    @Bean
    public Binding launchInterviewBinding(Queue launchInterviewQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(launchInterviewQueue).to(directExchange).with("appointment.interview.launched");
    }

    @Bean
    public Binding generateInterviewBinding(Queue generateInterviewQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(generateInterviewQueue).to(directExchange).with("appointment.interview.generated");
    }
}