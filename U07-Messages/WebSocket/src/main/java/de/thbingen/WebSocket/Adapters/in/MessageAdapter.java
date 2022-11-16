package de.thbingen.WebSocket.Adapters.in;

import de.thbingen.WebSocket.Ports.in.MessagePort;
import de.thbingen.WebSocket.Ports.out.WebsocketPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Controller
public class MessageAdapter implements MessagePort {

    @Autowired
    private WebsocketPort out;


    @Override
    @RabbitListener(queues = "#{messageQueue}")
    public void recieve(String message) {
        out.notify(message);
    }
}
