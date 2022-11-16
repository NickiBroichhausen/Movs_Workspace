package de.thbingen.WebSocket.Adapters.out;

import de.thbingen.WebSocket.Ports.out.WebsocketPort;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WebsocketAdapter extends TextWebSocketHandler implements WebsocketPort {

    List<WebSocketSession> sessions = new ArrayList<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        sessions.add(session);
    }


    @Override
    public void notify(String message) {
        for (WebSocketSession webSocketSession : sessions) {
            try {
                webSocketSession.sendMessage(new TextMessage(message));
            } catch (IOException | IllegalStateException e) {
                sessions.remove(webSocketSession);
            }
        }
    }
}
