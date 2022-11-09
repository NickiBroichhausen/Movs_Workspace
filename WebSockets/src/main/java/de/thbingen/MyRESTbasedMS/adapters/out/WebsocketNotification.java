package de.thbingen.MyRESTbasedMS.adapters.out;

import de.thbingen.MyRESTbasedMS.ports.out.Operation;
import de.thbingen.MyRESTbasedMS.ports.out.UpdatesNotificationPort;
import de.thbingen.MyRESTbasedMS.service.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Controller("WebSocketText")
public class WebsocketNotification extends TextWebSocketHandler implements UpdatesNotificationPort {

    List<WebSocketSession> sessions = new LinkedList<>();

    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session);
        System.out.println("Client connected");
    }

    @Override
    public void notify(User user, Operation operation) {
        for (WebSocketSession s: sessions){
            try {
                s.sendMessage(new TextMessage(user.getName() + " was " + operation));
            } catch (IOException e) {
                e.printStackTrace();
                sessions.remove(s);
            }
        }
    }
}
