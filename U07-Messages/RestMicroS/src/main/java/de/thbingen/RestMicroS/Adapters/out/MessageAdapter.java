package de.thbingen.RestMicroS.Adapters.out;

import de.thbingen.RestMicroS.Ports.out.MessagePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.DirectExchange;

@Controller
public class MessageAdapter implements MessagePort {

    @Autowired
    private AmqpTemplate template;

    @Autowired
    private DirectExchange exchange;

    @Override
    public void notify(String message) {
        template.convertAndSend(exchange.getName(), "REST", message);
        System.out.println("sending Message: " + message);
    }


}
