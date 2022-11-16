package de.thbingen.RestMicroS;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfig {

    @Bean
    public DirectExchange myExchange(){
        return new DirectExchange("ExchangeToQueue");
    }

}
