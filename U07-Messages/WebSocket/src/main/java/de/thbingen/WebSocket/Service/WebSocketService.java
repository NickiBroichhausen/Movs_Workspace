package de.thbingen.WebSocket.Service;

import de.thbingen.WebSocket.Ports.out.WebsocketPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebSocketService {

    @Autowired
    private WebsocketPort out;

    public void recieve(String message){

        while(true){
            out.notify(message);

        }
    }
}
