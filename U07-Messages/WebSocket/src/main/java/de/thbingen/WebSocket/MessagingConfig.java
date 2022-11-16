package de.thbingen.WebSocket;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfig {
  @Bean
  public Queue myQueue() {
    return new Queue("messageQueue");
  }

  @Bean
  public Binding myBinding(DirectExchange exchange, Queue queue) {
    return BindingBuilder.bind(queue).to(exchange).with("REST");

  }
}